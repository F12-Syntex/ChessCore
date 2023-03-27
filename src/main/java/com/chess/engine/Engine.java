package com.chess.engine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Constructor;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import javax.swing.JPanel;

import org.reflections.Reflections;

import com.chess.configuration.Configuration;
import com.chess.controller.InputController;
import com.chess.entities.AutoJoin;
import com.chess.entities.GraphicEntity;

/**
 * this class handles the graphics of the game.
 * @author Saif
 * @version 1.0.0
 * @since 1.0.0
 * @see com.chess.engine.Window
 */
public class Engine extends JPanel implements WindowListener{

	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getGlobal();
	
	private final InputController inputController;
	private final ConcurrentLinkedQueue<GraphicEntity> entities = new ConcurrentLinkedQueue<>();

	private FrameRate fps;
	private AtomicBoolean running = new AtomicBoolean(true);

	private BorderLayout layout = new BorderLayout();
	
	/* threads */
	private Thread processThread;
	private ExecutorService threadHandler = Executors.newFixedThreadPool(4);

	public Engine() {
		this.inputController = new InputController(this);
		
		this.addKeyListener(this.inputController.getKeyboardInputEvent());
		this.addMouseListener(this.inputController.getMouseInputListener());
		this.addMouseWheelListener(this.inputController.getMouseInputListener());
		this.addMouseMotionListener(this.inputController.getMouseInputListener());
		
		this.setFocusable(true);
		this.requestFocus();
		
		this.setLayout(this.layout);
		this.fps = new FrameRate();

		this.loadEntities();
		
		this.processThread = new Thread(() -> {
			this.run();
		});

		this.threadHandler.submit(this.processThread);
	
		this.setBackground(Color.gray);
	}
	

	/*
	 * Loads all the entities in the game.
	 * @return the worker thread
	 */
	public Thread getProcessThread() {
		return processThread;
	}

	/*
	 * get the thread handler.
	 * @return the thread handler
	 */
	public ExecutorService getThreadHandler() {
		return threadHandler;
	}

	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    
	    synchronized(this.entities) {
	    	this.entities.stream()
			 			 .sorted((a, b) -> a.getPriority() - b.getPriority())
			 			 .forEach(o -> {
							o.render(g);
							System.out.println("rendering: " + o.getClass().getSimpleName() + " at " + o.getPriority());
						});	
		}
	    
	}
	
	/*
	 * exits the game.
	 */
	public void close() {
		logger.info("exiting program");
		this.running = new AtomicBoolean(false);
		this.threadHandler.shutdown();
		try {
			this.threadHandler.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		System.exit(1);
	}
	
	/*
	 * the main game loop.
	 */
	public void run(){
	    long lastTime = System.nanoTime();

	
	    double amountOfTicks = Configuration.MAX_FPS;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		this.fps.reset();

	    long renderLastTime=System.nanoTime();
	    double renderNs=1000000000/amountOfTicks;
	    double renderDelta = 0;

	    while(this.running.get()){
	        long now = System.nanoTime();
	        delta += (now - lastTime) / ns;
	        lastTime = now;
	        while(delta >= 1){
	            tick();
	            delta--;
	        }

	        now = System.nanoTime();
	        renderDelta += (now - renderLastTime) / renderNs;
	        renderLastTime = now;
	        while(this.running.get() && renderDelta >= 1){
	            render();
	            this.fps.increment();
	            renderDelta--;
	        }

	        if(System.currentTimeMillis() - timer > 1000){
	            timer += 1000;
	            this.fps.reset();
	        }
	    }
	}

	/*
	 * tick every entity.
	 */
	public void tick() {
	    for(GraphicEntity entity : entities) {
			entity.tick();
	    }
	}
	
	/*
	 * render every entity.
	 */
	public void render() {
		repaint();
	}
	
	/*
	 * get the input controller.
	 * @return the input controller
	 */
	public InputController getInputController() {
		return inputController;
	}
	
	/*
	 * get the entities.
	 * @return the entities
	 */
	public ConcurrentLinkedQueue<GraphicEntity> getEntities() {
		return entities;
	}


	/*
	 * load all the entities in the game.
	 */
	public void loadEntities() {
		Reflections reflections = new Reflections("com.chess");

		Set<Class<? extends GraphicEntity>> entityClazzes = reflections.getSubTypesOf(GraphicEntity.class);

		for (Class<? extends GraphicEntity> clazz : entityClazzes) {
		    try {
		    	
		    	if(clazz.isAnnotationPresent(AutoJoin.class)) {
		    		
			        Constructor<? extends GraphicEntity> constructor = clazz.getConstructor(Engine.class);
			        GraphicEntity entity = constructor.newInstance(this);
			       
			        this.entities.add(entity);
		    		
		    	}
		    	
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		}
	}

	/*
	 * get the fps.
	 * @return the fps
	 */
	public FrameRate getFps() {
		return this.fps;
	}

	/*
	 * set the fps.
	 * @param fps the fps
	 */
	public void setFps(FrameRate fps) {
		this.fps = fps;
	}

	/*
	 * returns the isntance of the entity specified by the class.
	 * @param clazz the class of the entity
	 * @return the entity
	 */
	public <T extends GraphicEntity> T getGraphicEntity(Class<T> clazz) {
		return this.entities.stream()
			.filter(o -> clazz.isInstance(o))
			.map(clazz::cast)
			.findFirst()
			.orElse(null);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.close();
	}

	@Override
	public void windowOpened(WindowEvent e) {}
	
	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}


}
