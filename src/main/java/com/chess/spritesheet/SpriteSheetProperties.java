package com.chess.spritesheet;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import com.chess.datatypes.Node;

public class SpriteSheetProperties {

	private final boolean spriteSheet;
	private final Dimension size;
	
	public Map<Node, BufferedImage> map;

	public SpriteSheetProperties() {
		super();
		this.map = new LinkedHashMap<>();
		this.spriteSheet = false;
		this.size = new Dimension(0, 0);
	}
	
	public SpriteSheetProperties(boolean spriteSheet, Dimension size) {
		super();
		this.map = new LinkedHashMap<>();
		this.spriteSheet = spriteSheet;
		this.size = size;
	}

	public SpriteSheetProperties(boolean spriteSheet, int width, int height) {
		super();
		this.map = new LinkedHashMap<>();
		this.spriteSheet = spriteSheet;
		this.size = new Dimension(width, height);
	}
	
	public boolean isSpriteSheet() {
		return spriteSheet;
	}
	
	public Dimension getSize() {
		return size;
	}
	
	public void renderSpriteLocation(Node node, BufferedImage image) {
		synchronized(this.map) {
			this.map.put(node, image);	
		}
	}
	
	public BufferedImage getImageFromLocation(int x, int y) {
		return map.get(Node.of(x, y));
	}

	public BufferedImage getRandomImage() {
		int size = this.map.values().size();
		BufferedImage[] spriteImages = this.map.values().toArray(new BufferedImage[size]);

		return spriteImages[ThreadLocalRandom.current().nextInt(size)];
	}
	
	public BufferedImage getImageFromLocation(Node node) {
		BufferedImage image = map.get(node);
		return image;
	}
	
}