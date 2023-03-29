package com.chess.entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.logging.Logger;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

import com.chess.engine.Engine;

/**
 * this class is the base class for all entities that are to be rendered
 * @author Saif
 * @version 1.0
 * @since 1.0
 */
public abstract class GraphicEntity extends JComponent implements MouseInputListener, KeyListener, MouseWheelListener{

	protected Engine engine;
	private final Logger logger = Logger.getGlobal();

	public GraphicEntity(Engine engine) {
		this.engine = engine;
		logger.info(this.getClass().getName() + " has loaded.");
		this.engine.setPreferredSize(null);
	}

	public abstract void tick();
	
	/**
	 * @return the priority of the entity, the higher the priority, the earlier it is rendered
	 */
	public int getPriority() {
		return 1;
	}
	
	
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	public void mouseWheelMoved(MouseWheelEvent e) {}

}
