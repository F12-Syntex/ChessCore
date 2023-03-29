package com.chess.chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Optional;

import com.chess.datatypes.Grid;
import com.chess.datatypes.RainbowColour;
import com.chess.datatypes.TrueRainbowColour;
import com.chess.engine.Engine;
import com.chess.entities.AutoJoin;
import com.chess.entities.GraphicEntity;
import com.chess.entities.chesspieces.Bishop;
import com.chess.entities.chesspieces.ChessPiece;
import com.chess.entities.chesspieces.King;
import com.chess.entities.chesspieces.Knight;
import com.chess.entities.chesspieces.Pawn;
import com.chess.entities.chesspieces.PieceColour;
import com.chess.entities.chesspieces.Queen;
import com.chess.entities.chesspieces.Rook;


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
  private Grid grid = new Grid();
  private Color boardColour = Color.gray;

  public ChessBoard(Engine engine) {
    super(engine);
    this.resetBoard();
  }

  public void resetBoard(){

    for(int i = 0; i < this.grid.getWidth(); i++){
        ChessPiece blackPawn = new Pawn(this.engine, this.grid, PieceColour.BLACK);
        ChessPiece whitePawn = new Pawn(this.engine, this.grid, PieceColour.WHITE);

        ChessPiece blackRook = new Rook(this.engine, this.grid, PieceColour.BLACK);
        ChessPiece whiteRook = new Rook(this.engine, this.grid, PieceColour.WHITE);

        ChessPiece blackKnight = new Knight(this.engine, this.grid, PieceColour.BLACK);
        ChessPiece whiteKnight = new Knight(this.engine, this.grid, PieceColour.WHITE);

        ChessPiece blackBishop = new Bishop(this.engine, this.grid, PieceColour.BLACK);
        ChessPiece whiteBishop = new Bishop(this.engine, this.grid, PieceColour.WHITE);

        ChessPiece blackQueen = new Queen(this.engine, this.grid, PieceColour.BLACK);
        ChessPiece whiteQueen = new Queen(this.engine, this.grid, PieceColour.WHITE);

        ChessPiece blackKing = new King(this.engine, this.grid, PieceColour.BLACK);
        ChessPiece whiteKing = new King(this.engine, this.grid, PieceColour.WHITE);

        grid.setNode(i, 1, blackPawn);
        grid.setNode(i, this.grid.getHeight() - 2, whitePawn);

        if(i == 0 || i == this.grid.getWidth() - 1){
            grid.setNode(i, 0, blackRook);
            grid.setNode(i, this.grid.getHeight() - 1, whiteRook);
        }

        if(i == 1 || i == this.grid.getWidth() - 2){
            grid.setNode(i, 0, blackKnight);
            grid.setNode(i, this.grid.getHeight() - 1, whiteKnight);
        }

        if(i == 2 || i == this.grid.getWidth() - 3){
            grid.setNode(i, 0, blackBishop);
            grid.setNode(i, this.grid.getHeight() - 1, whiteBishop);
        }

        if(i == 3){
            grid.setNode(i, 0, blackQueen);
            grid.setNode(i, this.grid.getHeight() - 1, whiteQueen);
        }

        if(i == 4){
            grid.setNode(i, 0, blackKing);
            grid.setNode(i, this.grid.getHeight() - 1, whiteKing);
        }

    }

  }

  public void paintComponent(Graphics g) {
      super.paintComponent(g);
       // Get the size of the screen
       Dimension size = this.engine.getSize();
 
       //int red = ThreadLocalRandom.current().nextInt(100, 255);
       //int blue = ThreadLocalRandom.current().nextInt(100, 255);
       //int green = ThreadLocalRandom.current().nextInt(100, 255);

       int width = (int)(size.getWidth() / this.grid.getWidth());
       int height = (int)(size.getHeight() / this.grid.getHeight());

       //System.out.println("width: " + width + ", height: " + height);
   
        //this.boardColour = this.boardColour.updateColour();

       // Loop through each row and column to draw the squares
       for (int row = 0; row < 8; row++) {
           for (int col = 0; col < 8; col++) {
               // Calculate the x and y coordinates for the current square
               int x = row * width;
               int y = col * height;
   
               // Check whether the row and column are even or odd
               boolean isEvenRow = row % 2 == 0;
               boolean isEvenCol = col % 2 == 0;
               boolean isEvenSquare = isEvenRow == isEvenCol;
   
               // Set the color of the square based on whether it's even or odd
               if (isEvenSquare) {
                   g.setColor(boardColour);
               } else {
                   g.setColor(boardColour.darker());
               }
   
               // Draw the square
               g.fillRect(x, y, width, height);

                // Draw the piece
                Optional<ChessPiece> piece = this.grid.getNode(row, col);

                piece.ifPresent(type -> {
                    //g.setColor(Color.black);
                    //URL url;
                    try {

                        BufferedImage img = piece.get().getPieceIcon().getIcon(type.getColour());
                        //double SCALE_FACTOR = 1.1;
                        //url = new URL(piece.get().getIcon().getWhiteIcon());
                        g.drawImage(img, x, y, width, height, engine);
                        //g.drawImage(img, x, y, (int)(img.getWidth() * SCALE_FACTOR), (int)(img.getHeight() * SCALE_FACTOR), engine);
                        
                        //BufferedImage img = piece.get().getPieceIcon().getIcon(type.getColour());
                        //g.drawImage(img, x, y, engine);
                       
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                });

           }
       }
       
       this.bounds = new Rectangle(0, 0, (int)(this.grid.getWidth()*size.getWidth()), (int)(this.grid.getHeight()*size.getHeight()));
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
