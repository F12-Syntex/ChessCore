package com.chess.entities.chesspieces;

import java.awt.image.BufferedImage;

public interface IChessTheme {

    public static final int PAWN_INDEX = 5;
    public static final int ROOK_INDEX = 4;
    public static final int KNIGHT_INDEX = 3;
    public static final int BISHOP_INDEX = 2;
    public static final int QUEEN_INDEX = 1;
    public static final int KING_INDEX = 0;

    public static final int BLACK_INDEX = 1;
    public static final int WHITE_INDEX = 0;

    public abstract BufferedImage getIcon(PieceColour colour);
    public abstract PieceType getType();
}
