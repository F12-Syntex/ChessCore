package com.chess.entities.chesspieces;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.chess.chess.ChessBoard;
import com.chess.datatypes.Node;

public class Pawn extends ChessPiece{

    public Pawn(ChessBoard chessboard, PieceColour colour) {
        super(chessboard, colour);
    }

    public Pawn(ChessBoard chessboard, PieceColour colour, Node position) {
        super(chessboard, colour, position);
    }

    @Override
    public IChessTheme getPieceIcon() {
        return DefualtTheme.PAWN;
    }

    @Override
    public void tick() {

    }

    @Override
    public PieceType pieceType() {
        return PieceType.PAWN;
    }
 
    @Override
    public Set<Node> getValidMoves() {
        Set<Node> validMoves = new HashSet<>();
    
        // Determine the direction the pawn can move based on its color
        int direction = (this.colour == PieceColour.WHITE) ? -1 : 1;
        
        // Calculate the destination square for a single move forward
        Node forwardOne = Node.of(position.x, position.y + direction);
        
        // Check if the square in front of the pawn is empty
        if (!Chessboard.getPieceFromLocation(forwardOne).isPresent()) {
            validMoves.add(forwardOne);
            
            // If the pawn hasn't moved yet, check if it can move two squares forward
            if ((colour == PieceColour.WHITE && position.y == 6)
                || (colour == PieceColour.BLACK && position.y == 1)) {
                Node forwardTwo = Node.of(position.x, position.y + 2 * direction);
                if (!Chessboard.getPieceFromLocation(forwardTwo).isPresent()) {
                    validMoves.add(forwardTwo);
                }
            }
        }
    
        // Check if the pawn can capture an opponent's piece diagonally
        for (int dx : new int[] { -1, 1 }) {
            Node diagonal = Node.of(position.x + dx, position.y + direction);
            Optional<ChessPiece> piece = Chessboard.getPieceFromLocation(diagonal);
            if (piece.isPresent() && piece.get().colour != this.colour) {
                validMoves.add(diagonal);
            }
        }
    
        return validMoves;
    }
    
    

}
