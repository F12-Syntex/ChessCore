package com.chess.entities.chesspieces;

import java.util.Optional;

/*
 * This enum is used to store the types of chess pieces
 * @author Saif
 * @version 1.0.0
 * @since 1.0.0
 */
public enum PieceType {
    PAWN(1), ROOK(2), KNIGHT(3), BISHOP(4), QUEEN(5), KING(6);

    private int id;

    private PieceType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    /*
     * This method is used to get the PieceType from the id
     * @param id the id of the PieceType
     * @return the PieceType
     */
    public static Optional<PieceType> valueOf(int id) {
        for (PieceType type : PieceType.values()) {
            if (type.getId() == id) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

}
