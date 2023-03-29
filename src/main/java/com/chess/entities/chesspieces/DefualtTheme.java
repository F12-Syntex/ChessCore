package com.chess.entities.chesspieces;

public enum DefualtTheme implements IChessTheme{

    PAWN("https://upload.wikimedia.org/wikipedia/commons/4/45/Chess_plt45.svg", "https://upload.wikimedia.org/wikipedia/commons/c/c7/Chess_pdt45.svg");
    
    private final String WHITE_ICON;
    private final String BLACK_ICON;

    private DefualtTheme(String whiteIcon, String blackIcon) {
        this.WHITE_ICON = whiteIcon;
        this.BLACK_ICON = blackIcon;
    }

    @Override
    public String getWhiteIcon() {
        return this.WHITE_ICON;
    }

    @Override
    public String getBlackIcon() {
        return this.BLACK_ICON;
    }
}
