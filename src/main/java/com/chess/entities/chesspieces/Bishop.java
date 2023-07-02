package com.chess.entities.chesspieces;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.chess.chess.ChessBoard;
import com.chess.datatypes.Node;

/**
 * Defines a class (Bishop) that extends the class (ChessPiece)
 */

public class Bishop extends ChessPiece {

    public Bishop(ChessBoard chessboard, PieceColour colour) {
        super(chessboard, colour);
    }

    public Bishop(ChessBoard chessboard, PieceColour colour, Node position) {
        super(chessboard, colour, position);
    }

    @Override
    public IChessTheme getPieceIcon() {
       return DefualtTheme.BISHOP;
    }

    @Override
    public void tick() {
    }

    @Override
    public PieceType pieceType() {
        return PieceType.BISHOP;
    }

    @Override
    public Set<Node> getValidMoves() {
        Set<Node> validMoves = new HashSet<>();
        int x = position.x;
        int y = position.y;
        final int SIZE = this.Chessboard.getGrid().getWidth();

        // Check all diagonal directions
        for (int deltaX : new int[] {-1, 1}) {
            for (int deltaY : new int[] {-1, 1}) {
                int newX = x + deltaX;
                int newY = y + deltaY;

                while (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
                    Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(newX, newY));

                    if (!piece.isPresent()) {
                        validMoves.add(Node.of(newX, newY));
                    } else {
                        // There is a piece at this location
                        if (piece.get().colour != this.colour) {
                            validMoves.add(Node.of(newX, newY));
                        }

                        break; // Stop looking in this direction
                    }

                    // Move to the next square in this direction
                    newX += deltaX;
                    newY += deltaY;
                }
            }
        }

        return validMoves;
    }



    
}
