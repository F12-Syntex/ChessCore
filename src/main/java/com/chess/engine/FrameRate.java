package com.chess.engine;

/*
 * 
 */
public class FrameRate {

    private int fps;

    /*
     * Creates a new FrameRate object.
     */
    public FrameRate() {
        this.fps = 0;
    }

    /*
     * Sets the fps.
     * @param fps the fps
     */
    public void setFps(int fps) {
        this.fps = fps;
    }

    /*
     * Increments the fps.
     */
    public void increment() {
        this.fps++;
    }

    /*
     * Gets the fps.
     * @return the fps
     */
    public int getFPS() {
        return this.fps;
    }

    /*
     * Resets the fps.
     */
    public void reset() {
        this.fps = 0;
    }

}
