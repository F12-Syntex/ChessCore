
package com.chess.spritesheet;

import java.awt.image.BufferedImage;

import javax.annotation.Nonnull;

/**
 * This enum is used to define the classic chest background.
 */

public enum SpriteSheet {
	DEFUALT_CHESS_PIECE_THEME("C:\\Users\\synte\\OneDrive - University of Kent\\Desktop\\chess\\default_theme\\classic_theme.png", new SpriteSheetProperties(true, 320, 426));
    
    private final String dir;
    private BufferedImage image;
    private final SpriteSheetProperties sprite_sheet;
    
    private SpriteSheet(@Nonnull final String dir, @Nonnull final SpriteSheetProperties sprite_sheet) {
        this.dir = dir;
        this.sprite_sheet = sprite_sheet;
    }

    public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getDir() {
        return dir;
    }

	public BufferedImage getImage() {
		return image;
	}

	public SpriteSheetProperties getProperties() {
		synchronized(this.sprite_sheet) {
			return sprite_sheet;
		}
	}
}