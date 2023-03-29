package com.chess.entities.chesspieces;

import com.chess.datatypes.Grid;
import com.chess.datatypes.Node;
import com.chess.engine.Engine;

public class Queen extends ChessPiece{

    public Queen(Engine engine, Grid chessBoard, PieceColour colour) {
        super(engine, chessBoard, colour);
    }

    @Override
    public void move(Node position) {
    }

    @Override
    public IChessTheme getPieceIcon() {
        return DefualtTheme.QUEEN;
    }

    @Override
    public void tick() {
    }
    
}
