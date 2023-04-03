package com.chess.entities.chesspieces;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.swing.event.MouseInputListener;

import com.chess.chess.ChessBoard;
import com.chess.datatypes.BoardSquare;
import com.chess.datatypes.Node;

public abstract class ChessPiece implements MouseInputListener, KeyListener, MouseWheelListener{

    protected PieceColour colour;

    protected ChessBoard Chessboard;
    protected Node position;
    protected Rectangle bounds;



    public ChessPiece(ChessBoard chessboard, PieceColour colour, Node position) {
        this.Chessboard = chessboard;
        this.colour = colour;
        this.position = position;
    }

    public ChessPiece(ChessBoard chessboard, PieceColour colour) {
        this.Chessboard = chessboard;
        this.colour = colour;
        this.position = null;
    }

    public abstract IChessTheme getPieceIcon();
    public abstract PieceType pieceType();
    public abstract void tick();
    public abstract Set<Node> getValidMoves();

    public void move(Node position){
        if(this.getValidMoves().contains(position)){
            System.out.println("Moving " + this.getClass().getName() + " to " + position.toString());
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(position);
            if(piece.isPresent()){
                this.Chessboard.getPieces().remove(piece.get());
            }
            this.position = position;
        }   
    }

    public Node getPosition(){
        return this.position;   
    }

    public void setPosition(Node position){
        this.position = position;
    }
    


    /*
     * This method is used to get the colour of the piece
     * @return the colour of the piece
     * @see com.chess.entities.chesspieces.PieceColour
     */
    public PieceColour getColour() {
        return colour;
    }

    /*
     * This method is used to set the colour of the piece
     * @param colour the colour to set the piece to
     */
    public void setColour(@Nonnull PieceColour colour) {
        this.colour = colour;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed by " + this.getClass().getName() + " : " + this.colour.name());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Cursor c = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        e.getComponent().setCursor(c);
        //System.out.println("Mouse entered by " + e.getComponent().getCursor().getName());
    }

    public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void mouseClicked(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseWheelMoved(MouseWheelEvent e) {}
    public void mouseEntered(MouseEvent e) {}

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }



}


