package com.chess.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.chess.engine.Engine;

/*
 * This class is the base class for all input classes.
 * @author: Saif
 * @version: 1.0.0
 * @since: 1.0.0
 */
public abstract class GameInput {
	protected final Logger logger = Logger.getLogger(this.getClass().getName());
	protected final Engine engine;
	
	private final Level MIN_LOG_LEVEL = Level.INFO;
	
	public GameInput(Engine engine) {
		this.engine = engine;
		logger.setFilter(record -> record.getLevel().intValue() > MIN_LOG_LEVEL.intValue());
	}
}
