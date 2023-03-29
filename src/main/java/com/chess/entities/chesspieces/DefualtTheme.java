package com.chess.entities.chesspieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.chess.datatypes.Node;
import com.chess.spritesheet.SpriteSheet;

/**
 * This enum is used to store the default chess pieces
 * WARNING: all constants must contain variable names only found in the PieceType enum
 */
public enum DefualtTheme implements IChessTheme{

    PAWN(Node.of(PAWN_INDEX, WHITE_INDEX), Node.of(PAWN_INDEX, BLACK_INDEX)),
    ROOK(Node.of(ROOK_INDEX, WHITE_INDEX), Node.of(ROOK_INDEX, BLACK_INDEX)),
    KNIGHT(Node.of(KNIGHT_INDEX, WHITE_INDEX), Node.of(KNIGHT_INDEX, BLACK_INDEX)),
    BISHOP(Node.of(BISHOP_INDEX, WHITE_INDEX), Node.of(BISHOP_INDEX, BLACK_INDEX)),
    QUEEN(Node.of(QUEEN_INDEX, WHITE_INDEX), Node.of(QUEEN_INDEX, BLACK_INDEX)),
    KING(Node.of(KING_INDEX, WHITE_INDEX), Node.of(KING_INDEX, BLACK_INDEX));
    
    private final Node WHITE_ICON_INDEX;
    private final Node BLACK_ICON_INDEX;

    private DefualtTheme(Node whiteIconIndex, Node blackIconIndex) {
        this.WHITE_ICON_INDEX = whiteIconIndex;
        this.BLACK_ICON_INDEX = blackIconIndex;

        new ArrayList<String>().stream().reduce((a, b) -> a + b);
    }

    public BufferedImage getWhiteIcon() {
        return SpriteSheet.DEFUALT_CHESS_PIECE_THEME.getProperties().getImageFromLocation(WHITE_ICON_INDEX);
    }

    public BufferedImage getBlackIcon() {
        return SpriteSheet.DEFUALT_CHESS_PIECE_THEME.getProperties().getImageFromLocation(BLACK_ICON_INDEX);
    }

    @Override
    public BufferedImage getIcon(PieceColour colour) {
        switch(colour) {
            case WHITE:
                return getWhiteIcon();
            case BLACK:
                return getBlackIcon();
            default:
                throw new IllegalArgumentException("Invalid colour");
        }
    }

    @Override
    public PieceType getType() {
        return PieceType.valueOf(this.name());
    }
}
