package com.chess.engine;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import com.chess.configuration.Configuration;

/**
 * this class handles the actual window of the game
 * @author Saif
 * @version 1.0
 * @since 1.0
 * @see JFrame
 */
public class Window extends JFrame implements ComponentListener{

	public static final Dimension DIMENSION = new Dimension(1016, 1040);
	
	public Window() {
		
		// set the title and size of the window
		this.setTitle(Configuration.NAME + " v" + Configuration.VERSION);
		this.setSize(DIMENSION);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	/**
	 * shows the window
	 * @param engine the engine to be shown
	 */
	public void show(Engine engine) {
		this.add(engine);
		this.setVisible(true);
		this.addComponentListener(this);
	}
	
	/**
	 * @return the dimensions of the window
	 */
	public Dimension getDimensions() {
		return this.getSize();
	}

	@Override
	public void componentResized(ComponentEvent e) {
		//System.out.println("new Dimension(" + this.getDimensions().width + ", " + this.getDimensions().height + ");");
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
