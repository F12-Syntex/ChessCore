package com.chess.entities.chesspieces;

import java.awt.event.MouseEvent;

import javax.annotation.Nonnull;

import com.chess.datatypes.Grid;
import com.chess.datatypes.Node;
import com.chess.engine.ChessCore;
import com.chess.engine.Engine;
import com.chess.entities.GraphicEntity;

public abstract class ChessPiece extends GraphicEntity{

    protected Grid ChessBoard;
    protected PieceColour colour;

    public ChessPiece(Engine engine, Grid chessBoard, PieceColour colour) {
        super(engine);
        this.ChessBoard = chessBoard;
        this.colour = colour;
    }

    public abstract void move(Node position);
    public abstract IChessTheme getPieceIcon();

    public static ChessPiece getPiece(PieceType type, PieceColour colour, Grid ChessBoard) {

        Engine engine = ChessCore.getInstance().getEngine();

        switch(type) {
            case PAWN:
                return new Pawn(engine, ChessBoard, colour);
            /*
            case ROOK:
                return new Rook(engine);
            case KNIGHT:
                return new Knight(engine);
            case BISHOP:
                return new Bishop(engine);
            case QUEEN:
                return new Queen(engine);
            case KING:
                return new King(engine);
            */
            default:
                throw new IllegalArgumentException("Invalid piece type");
        }
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
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered chess piece" + this);
        super.mouseEntered(e);
    }


}


