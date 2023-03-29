
package com.chess.spritesheet;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.chess.datatypes.Node;

public class SpriteSheetLoader {
	
	private final File root;
	private boolean loading;
	private final String DIRECTORY_OF_SPRITES = "C:\\Users\\synte\\OneDrive - University of Kent\\Desktop\\chess";
	
	public SpriteSheetLoader() {
		this.root = new File(DIRECTORY_OF_SPRITES); 
	}

	public void loadSpriteSheets() {
		this.setLoading(true);
		this.generateCode(root);
		this.setLoading(false);
	}
	
	public void generateCode(File root) {
		
		if(root == null) {
			return;
		}
		
		for(File file : root.listFiles()) {
			
			if(file.isDirectory()) {
				this.generateCode(file);
				continue;
			}
			
			String name = file.getName().toUpperCase().split("[.]")[0]
											.replaceAll("[^a-zA-Z0-9]", "_");
			
			//System.out.println(name + "(\"" + path.split("spritesheet\\\\")[1].replace("\\", "\\\\") + "\", new SpriteSheetDimensions()),");

			try {
				
				SpriteSheet sheet = SpriteSheet.valueOf(name);
				
				if(sheet.getProperties().isSpriteSheet()) {
					
					Logger.getGlobal().info("rendering sprite sheet");
					
					
					//Dimension cell = sheet.getProperties().getSize();
					
					BufferedImage img = ImageIO.read(file);

					System.out.println("width: " + img.getWidth() + " height: " + img.getHeight());



					Dimension cell = new Dimension(img.getWidth() / 6, img.getHeight() / 2);
					
					for(int y = 0; y < 2; y++) {
						for(int x = 0; x < 6; x++) {
							System.out.println("x: " + x + " y: " + y);
							BufferedImage sprite = img.getSubimage(x*cell.width, y*cell.height, cell.width, cell.height);
							sheet.getProperties().renderSpriteLocation(Node.of(x, y), sprite);
						}
					}
					
					Logger.getGlobal().info("rendered sprite sheet");
					
				}
				
				sheet.setImage(ImageIO.read(file));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public boolean isLoading() {
		return loading;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
	}
	

	
}