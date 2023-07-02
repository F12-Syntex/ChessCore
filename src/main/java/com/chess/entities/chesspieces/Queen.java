package com.chess.entities.chesspieces;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.chess.chess.ChessBoard;
import com.chess.datatypes.Node;

/**
 * Defines a class (Queen) that extends the class (ChessPiece)
 */

public class Queen extends ChessPiece{

    public Queen(ChessBoard chessboard, PieceColour colour) {
        super(chessboard, colour);
    }

    public Queen(ChessBoard chessboard, PieceColour colour, Node position) {
        super(chessboard, colour, position);
    }

    @Override
    public IChessTheme getPieceIcon() {
        return DefualtTheme.QUEEN;
    }

    @Override
    public void tick() {
    }

    @Override
    public PieceType pieceType() {
        return PieceType.QUEEN;
    }

    @Override
    public Set<Node> getValidMoves() {
        Set<Node> validMoves = new HashSet<>();
        int x = position.x;
        int y = position.y;
        final int SIZE = this.Chessboard.getGrid().getWidth();
    
        // Check moves to the east (right)
        for (int right = x + 1; right < SIZE; right++) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(right, y));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(right, y));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(right, y));
                break;
            } else {
                break;
            }
        }
    
        // Check moves to the west (left)
        for (int left = x - 1; left >= 0; left--) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(left, y));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(left, y));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(left, y));
                break;
            } else {
                break;
            }
        }
    
        // Check moves to the north (up)
        for (int up = y + 1; up < SIZE; up++) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(x, up));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(x, up));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(x, up));
                break;
            } else {
                break;
            }
        }
    
        // Check moves to the south (down)
        for (int down = y - 1; down >= 0; down--) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(x, down));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(x, down));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(x, down));
                break;
            } else {
                break;
            }
        }
    
        // Check moves to the northeast
        for (int i = 1; x + i < SIZE && y + i < SIZE; i++) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(x + i, y + i));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(x + i, y + i));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(x + i, y + i));
                break;
            } else {
                break;
            }
        }
    
        // Check moves to the northwest
        for (int i = 1; x - i >= 0 && y + i < SIZE; i++) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(x - i, y + i));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(x - i, y + i));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(x - i, y + i));
                break;
            } else {
                break;
            }
        }
    
        // Check moves to the southwest
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(x - i, y - i));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(x - i, y - i));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(x - i, y - i));
                break;
            } else {
                break;
            }
        }
    
        // Check moves to the southeast
        for (int i = 1; x + i < SIZE && y - i >= 0; i++) {
            Optional<ChessPiece> piece = this.Chessboard.getPieceFromLocation(Node.of(x + i, y - i));
            if (!piece.isPresent()) {
                validMoves.add(Node.of(x + i, y - i));
            } else if (piece.get().colour != this.colour) {
                validMoves.add(Node.of(x + i, y - i));
                break;
            } else {
                break;
            }
        }
    
        return validMoves;
    }
    
    
    
}
