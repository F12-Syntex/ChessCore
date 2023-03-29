package com.chess.entities.chesspieces;

import com.chess.datatypes.Grid;
import com.chess.datatypes.Node;
import com.chess.engine.Engine;

public class Knight extends ChessPiece{

    public Knight(Engine engine, Grid chessBoard, PieceColour colour) {
        super(engine, chessBoard, colour);
    }

    @Override
    public void move(Node position) {
    }

    @Override
    public IChessTheme getPieceIcon() {
       return DefualtTheme.KNIGHT;
    }

    @Override
    public void tick() {
    }
    
}
