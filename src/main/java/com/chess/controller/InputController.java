package com.chess.controller;

import com.chess.engine.Engine;

/*
 * This class is the base class for all input classes.
 * @author: Saif
 * @version: 1.0.0
 * @since: 1.0.0
 * @see com.chess.controller.GameInput
 */
public class InputController {
	
	private final Engine engine;
	
	private final KeyboardInputEvent keyboardInputEvent;
	private final MouseListener mouseInputListener;

	public InputController(Engine engine) {
		this.engine = engine;
		
		this.mouseInputListener = new MouseListener(engine);
		this.keyboardInputEvent = new KeyboardInputEvent(engine);
	}

	/*
	 * get the game engine
	 * @return the game engine
	 * @see Engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/*
	 * get the keyboard input event
	 * @return the keyboard input event
	 */
	public KeyboardInputEvent getKeyboardInputEvent() {
		return keyboardInputEvent;
	}

	/**
	 * get the mouse input listener
	 * @return the mouse input listener
	 */
	public MouseListener getMouseInputListener() {
		return mouseInputListener;
	}

}
