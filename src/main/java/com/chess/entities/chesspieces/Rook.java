package com.chess.entities.chesspieces;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.chess.chess.ChessBoard;
import com.chess.datatypes.Node;

/**
 * Defines a class (Rook) that extends the class (ChessPiece)
 */

public class Rook extends ChessPiece{

    public Rook(ChessBoard chessboard, PieceColour colour) {
        super(chessboard, colour);
    }

    public Rook(ChessBoard chessboard, PieceColour colour, Node position) {
        super(chessboard, colour, position);
    }

    @Override
    public IChessTheme getPieceIcon() {
        return DefualtTheme.ROOK;
    }

    @Override
    public void tick() {
    }

    @Override
    public PieceType pieceType() {
        return PieceType.ROOK;
    }

    @Override
public Set<Node> getValidMoves() {
    Set<Node> validMoves = new HashSet<>();
    int x = position.x;
    int y = position.y;
    final int SIZE = this.Chessboard.getGrid().getWidth();

    // Check moves to the right
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

    // Check moves to the left
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

    // Check moves upwards
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

    // Check moves downwards
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

    return validMoves;
}
    
}
