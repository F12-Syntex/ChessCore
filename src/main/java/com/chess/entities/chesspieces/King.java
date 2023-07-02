package com.chess.entities.chesspieces;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.chess.chess.ChessBoard;
import com.chess.datatypes.Node;

/**
 * Defines a class (King) that extends the class (ChessPiece)
 */

public class King extends ChessPiece{

    public King(ChessBoard chessboard, PieceColour colour) {
        super(chessboard, colour);
    }

    public King(ChessBoard chessboard, PieceColour colour, Node position) {
        super(chessboard, colour, position);
    }

    @Override
    public IChessTheme getPieceIcon() {
        return DefualtTheme.KING;
    }

    @Override
    public void tick() {
    }

    @Override
    public PieceType pieceType() {
        return PieceType.KING;
    }

    @Override
    public Set<Node> getValidMoves() {
        Set<Node> validMoves = new HashSet<>();
        int x = position.x;
        int y = position.y;
        final int SIZE = this.Chessboard.getGrid().getWidth();
    
        // Check all adjacent squares
        for (int deltaX = -1; deltaX <= 1; deltaX++) {
            for (int deltaY = -1; deltaY <= 1; deltaY++) {
                if (deltaX == 0 && deltaY == 0) {
                    continue; // Skip the current square
                }
    
                int newX = x + deltaX;
                int newY = y + deltaY;
    
                if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
                    Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(newX, newY));
                    if (!piece.isPresent() || piece.get().colour != this.colour) {
                        validMoves.add(Node.of(newX, newY));
                    }
                }
            }
        }
    
        return validMoves;
    }
    

    
}
