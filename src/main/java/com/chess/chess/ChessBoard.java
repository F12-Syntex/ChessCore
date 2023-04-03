package com.chess.chess;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.chess.datatypes.BoardSquare;
import com.chess.datatypes.Grid;
import com.chess.datatypes.Node;
import com.chess.datatypes.RainbowColour;
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
    private RainbowColour boardColour = new RainbowColour(0.6f, 0.6f, 0.6f, true);
    
    public Optional<ChessPiece> selectedPiece = Optional.empty();
    public Optional<MouseEvent> lastMouseEvent = Optional.empty();

    public List<ChessPiece> pieces;

    public ChessBoard(Engine engine) {
        super(engine);
        this.resetBoard();
    }

    public void resetBoard(){

        this.pieces = new ArrayList<>();
        
        for(int i = 0; i < this.grid.getWidth(); i++){
            ChessPiece blackPawn = new Pawn(this, PieceColour.BLACK);
            ChessPiece whitePawn = new Pawn(this, PieceColour.WHITE);

            blackPawn.setPosition(Node.of(i, 1));
            whitePawn.setPosition(Node.of(i, this.grid.getHeight() - 2));

            this.pieces.add(whitePawn);
            this.pieces.add(blackPawn);


            if(i == 0 || i == this.grid.getWidth() - 1){
                ChessPiece blackRook = new Rook(this, PieceColour.BLACK);
                ChessPiece whiteRook = new Rook(this, PieceColour.WHITE);
                blackRook.setPosition(Node.of(i, 0));
                whiteRook.setPosition(Node.of(i, this.grid.getHeight() - 1));
                this.pieces.add(whiteRook);
                this.pieces.add(blackRook);
                System.out.println("Rook position: " + whiteRook.getPosition());
                
            }

            if(i == 1 || i == this.grid.getWidth() - 2){
                ChessPiece blackKnight = new Knight(this, PieceColour.BLACK);
                ChessPiece whiteKnight = new Knight(this, PieceColour.WHITE);
                blackKnight.setPosition(Node.of(i, 0));
                whiteKnight.setPosition(Node.of(i, this.grid.getHeight() - 1));
                this.pieces.add(whiteKnight);
                this.pieces.add(blackKnight);
                System.out.println("Knight position: " + whiteKnight.getPosition());
            }

            if(i == 2 || i == this.grid.getWidth() - 3){
                ChessPiece blackBishop = new Bishop(this, PieceColour.BLACK);
                ChessPiece whiteBishop = new Bishop(this, PieceColour.WHITE);
                blackBishop.setPosition(Node.of(i, 0));
                whiteBishop.setPosition(Node.of(i, this.grid.getHeight() - 1));
                this.pieces.add(whiteBishop);
                this.pieces.add(blackBishop);
                System.out.println("Bishop position: " + whiteBishop.getPosition());
            }

            if(i == 3){
                ChessPiece blackQueen = new Queen(this, PieceColour.BLACK);
                ChessPiece whiteQueen = new Queen(this, PieceColour.WHITE);
                blackQueen.setPosition(Node.of(i, 0));
                whiteQueen.setPosition(Node.of(i, this.grid.getHeight() - 1));
                this.pieces.add(whiteQueen);
                this.pieces.add(blackQueen);
                System.out.println("Queen position: " + whiteQueen.getPosition());
            }

            if(i == 4){
                ChessPiece blackKing = new King(this, PieceColour.BLACK);
                ChessPiece whiteKing = new King(this, PieceColour.WHITE);
                blackKing.setPosition(Node.of(i, 0));
                whiteKing.setPosition(Node.of(i, this.grid.getHeight() - 1));
                this.pieces.add(whiteKing);
                this.pieces.add(blackKing);
                System.out.println("King position: " + whiteKing.getPosition());
            }            
        }


        //Node node1 = Node.of(2, 4);
        //Node node2 = Node.of(5, 4);
        
        //ChessPiece rook1 = new Rook(this, PieceColour.WHITE, node2);
        //ChessPiece pawn1 = new Pawn(this, PieceColour.WHITE, node1);

        //this.pieces.add(rook1);
        //this.pieces.add(pawn1);
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

        //this.boardColour = this.boardColour.updateColour();

        // Loop through each row and column to draw the squares
        for (int row = 0; row < this.grid.getWidth(); row++) {
            for (int col = 0; col < this.grid.getHeight(); col++) {
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
                Rectangle bounds = new Rectangle(x, y, width, height);

                g.fillRect(x, y, width, height);

                final Node node = Node.of(row, col);

                //draw the highlighted squares
                if(this.selectedPiece.isPresent()){
                    Set<Node> movements = this.selectedPiece.get().getValidMoves();

                    if(movements.contains(node)){
                        g.setColor(Color.red);
                        g.fillRect(x, y, width, height);
                    }
                }

                    // Draw the piece
                    Optional<ChessPiece> piece = this.pieces.stream().filter(i -> i.getPosition().equals(node)).findFirst();

                    if(piece.isPresent()){
                        ChessPiece chessPiece = piece.get();

                        try {
                            BufferedImage img = chessPiece.getPieceIcon().getIcon(chessPiece.getColour());
                            chessPiece.setBounds(bounds);
                            
                            if(this.selectedPiece.isPresent()){


                                if(this.selectedPiece.get().equals(chessPiece)){
                                    Graphics2D g2 = (Graphics2D) g;
                                    Composite originalComposite = g2.getComposite(); // Save the original composite
                                    AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
                                    g2.setComposite(alphaComposite);
                                    g2.drawImage(img, x, y, width, height, engine);
                                    g2.setComposite(originalComposite); // Restore the original composite

                                    continue;
                                }

                               
                            }

                            g.drawImage(img, x, y, width, height, engine);
                        
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }
                    }else{
                        this.grid.setNodeChessDimentions(row, col, bounds);
                    }

            }
        }

        this.selectedPiece.ifPresent(chessPiece -> {
            this.lastMouseEvent.ifPresent(point -> {
                BufferedImage img = chessPiece.getPieceIcon().getIcon(chessPiece.getColour());
                g.drawImage(img, (int)point.getX() - (int)(img.getWidth() / 1.7), (int)point.getY() - img.getHeight() / 2, width, height, engine);
                
            });
        });

        this.bounds = new Rectangle(0, 0, (int)(this.grid.getWidth()*size.getWidth()), (int)(this.grid.getHeight()*size.getHeight()));
    }

        @Override
        public void tick() {
            this.pieces.forEach(ChessPiece::tick);
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

        /*
        * this method notifies the chess piece that a mouse event on it has accursed
        */
        private Optional<ChessPiece> notifyMouseEventToChessPieces(MouseEvent e){
            for(int y = 0; y < this.grid.getHeight(); y++){
                for(int x = 0; x < this.grid.getWidth(); x++){
                    final int xFinal = x;
                    final int yFinal = y;
                    Optional<ChessPiece> element = this.pieces.stream().filter(o -> o.getPosition().equals(Node.of(xFinal, yFinal))).findFirst();
                    if(element.isPresent() && element.get().getBounds().contains(e.getPoint())){
                        return element;
                    }
                }
            }

            if(!this.selectedPiece.isPresent()){
                Cursor c = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
                e.getComponent().setCursor(c);
            }else{
                Cursor c = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                e.getComponent().setCursor(c);
            }

            return Optional.empty();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.notifyMouseEventToChessPieces(e).ifPresent(type -> {
                    type.mousePressed(e);
                    selectedPiece = Optional.of(type);
                    this.lastMouseEvent = Optional.of(e);
            });
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            this.notifyMouseEventToChessPieces(e).ifPresent(type -> {
                type.mouseReleased(e);
            });

            Optional<BoardSquare> board = this.getGrid().getSquareFromPoint(e.getPoint());
            board.ifPresent(position -> {
                selectedPiece.ifPresent(selectedPiece -> {
                    selectedPiece.move(position.getPositionInGrid());
                });
            });
        
            this.selectedPiece = Optional.empty();
            this.lastMouseEvent = Optional.empty();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            this.notifyMouseEventToChessPieces(e).ifPresent(type -> {
                    type.mouseClicked(e);
            });
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            this.notifyMouseEventToChessPieces(e).ifPresent(type -> {
                type.mouseDragged(e);
            });
            this.lastMouseEvent = Optional.of(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            this.notifyMouseEventToChessPieces(e).ifPresent(type -> {
                type.mouseMoved(e);
            });
        }

        public Optional<ChessPiece> getPieceFromLocation(Node node){
            return this.pieces.stream().filter(o -> o.getPosition().equals(node)).findFirst();
        }

        public void setBounds(Rectangle bounds) {
            this.bounds = bounds;
        }

        public Grid getGrid() {
            return grid;
        }

        public void setGrid(Grid grid) {
            this.grid = grid;
        }

        public RainbowColour getBoardColour() {
            return boardColour;
        }

        public void setBoardColour(RainbowColour boardColour) {
            this.boardColour = boardColour;
        }

        public Optional<ChessPiece> getSelectedPiece() {
            return selectedPiece;
        }

        public void setSelectedPiece(Optional<ChessPiece> selectedPiece) {
            this.selectedPiece = selectedPiece;
        }

        public Optional<MouseEvent> getLastMouseEvent() {
            return lastMouseEvent;
        }

        public void setLastMouseEvent(Optional<MouseEvent> lastMouseEvent) {
            this.lastMouseEvent = lastMouseEvent;
        }

        public List<ChessPiece> getPieces() {
            return pieces;
        }

        public void setPieces(List<ChessPiece> pieces) {
            this.pieces = pieces;
        }

        


}
