package com.chess.entities.chesspieces;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.chess.chess.ChessBoard;
import com.chess.datatypes.Node;

/**
 * Defines a class (Knight) that extends the class (ChessPiece)
 */

public class Knight extends ChessPiece{

    public Knight(ChessBoard chessboard, PieceColour colour) {
        super(chessboard, colour);
    }

    public Knight(ChessBoard chessboard, PieceColour colour, Node position) {
        super(chessboard, colour, position);
    }

    @Override
    public IChessTheme getPieceIcon() {
       return DefualtTheme.KNIGHT;
    }

    @Override
    public void tick() {
    }
    
    @Override
    public PieceType pieceType() {
        return PieceType.KNIGHT;
    }

    @Override
    public Set<Node> getValidMoves() {
        Set<Node> validMoves = new HashSet<>();
        int x = position.x;
        int y = position.y;
        final int SIZE = this.Chessboard.getGrid().getWidth();
    
        // Possible moves for the knight in a 2x3 L shape
        int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
        int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
    
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
    
            if (newX >= 0 && newX < SIZE && newY >= 0 && newY < SIZE) {
                Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(newX, newY));
                if (!piece.isPresent() || piece.get().colour != this.colour) {
                    validMoves.add(Node.of(newX, newY));
                }
            }
        }
    
        return validMoves;
    }
    
    
    
}
