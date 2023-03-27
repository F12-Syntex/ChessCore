package com.chess.chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.chess.engine.Engine;
import com.chess.entities.AutoJoin;
import com.chess.entities.GraphicEntity;


/*
 * This class is responsible for drawing the chess board.
 * It is an entity, so it will be automatically added to the engine.
 * @author: Saif
 * @version: 1.0.0
 * @since: 1.0.0
 * @see: GraphicEntity 
 * 
 */
@AutoJoin
public class ChessBoard extends GraphicEntity{

  private Rectangle bounds = new Rectangle();

  public ChessBoard(Engine engine) {
    super(engine);
  }

  @Override
  public void render(Graphics g) {
      // Get the size of the screen
      Dimension size = this.engine.getSize();
      System.out.println("size: " + size);

      //int red = ThreadLocalRandom.current().nextInt(100, 255);
      //int blue = ThreadLocalRandom.current().nextInt(100, 255);
      //int green = ThreadLocalRandom.current().nextInt(100, 255);

      Color initColor = Color.gray;
  
      // Calculate the size of each square on the board
      int squareSize = Math.min(size.width, size.height) / 8;
  
      // Loop through each row and column to draw the squares
      for (int row = 0; row < 8; row++) {
          for (int col = 0; col < 8; col++) {
              // Calculate the x and y coordinates for the current square
              int x = col * squareSize;
              int y = row * squareSize;
  
              // Check whether the row and column are even or odd
              boolean isEvenRow = row % 2 == 0;
              boolean isEvenCol = col % 2 == 0;
              boolean isEvenSquare = isEvenRow == isEvenCol;
  
              // Set the color of the square based on whether it's even or odd
              if (isEvenSquare) {
                  g.setColor(initColor);
              } else {
                  g.setColor(initColor.darker());
              }
  
              // Draw the square
              g.fillRect(x, y, squareSize, squareSize);
          }
      }
      
      this.bounds = new Rectangle(0, 0, squareSize*8, squareSize);

      // Draw a border around the chess board
      g.setColor(Color.black);
      g.drawRect(0, 0, 8 * squareSize, 8 * squareSize);
  }
  


    @Override
    public void tick() {

    }

    /**
     * @return the bounds
     */
    public Rectangle getBounds() {
        return this.bounds;
    }

    
    @Override
    public int getPriority() {
        return 2;
    }
}
