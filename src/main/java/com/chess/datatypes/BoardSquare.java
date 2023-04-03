package com.chess.datatypes;

import java.awt.Rectangle;

import com.chess.entities.chesspieces.ChessPiece;

/*
 * This class is used to the data of a square on the chess board
 * @author Saif
 * @version 1.0.0
 * @since 1.0.0
 */
public class BoardSquare {
    private Rectangle bounds;
    private Node positionInGrid;

    public BoardSquare(ChessPiece chesspiece, Rectangle bounds, Node positionInGrid) {
        this.bounds = bounds;
        this.positionInGrid = positionInGrid;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public Node getPositionInGrid() {
        return positionInGrid;
    }

    public void setPositionInGrid(Node positionInGrid) {
        this.positionInGrid = positionInGrid;
    }

}
