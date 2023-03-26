package com.chess.engine;

import java.util.logging.Logger;

import com.chess.configuration.Configuration;

/**
 * The singleton class responsible for acting as the global handler in this game.
 * @author Saif
 * @version 1.0.0
 * @since 1.0.0
 * @see com.chess.engine.Window
 * @see com.chess.engine.Engine
 */
public final class ChessCore {
	
	private final Window window;
	private final Engine engine;
	private static final ChessCore instance = new ChessCore();
	private final Logger logger = Logger.getGlobal();
	
	private ChessCore() {
		this.window = new Window();
		this.engine = new Engine();
	}
	
	/*
	 * Starts the game.
	 */
	public void start(){
		logger.info(Configuration.NAME + " v" + Configuration.VERSION + " has started");
		this.window.show(engine);
	}
	
	public static void main(String[] args) {
		ChessCore enchantedRealm = ChessCore.getInstance();
		enchantedRealm.start();
	}
	
	/*
	 * Returns the instance of the game.
	 */
	public static ChessCore getInstance() {
		return ChessCore.instance;
	}
	
	/*
	 * Returns the window of the game.
	 */
	public Window getWindow() {
		return window;
	}

	/*
	 * Returns the engine of the game.
	 */
	public Engine getEngine() {
		return engine;
	}
	

}
