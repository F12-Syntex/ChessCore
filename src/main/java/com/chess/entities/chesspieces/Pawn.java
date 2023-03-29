package com.chess.entities.chesspieces;

import com.chess.datatypes.Grid;
import com.chess.datatypes.Node;
import com.chess.engine.Engine;

public class Pawn extends ChessPiece{

    public Pawn(Engine engine, Grid chessBoard, PieceColour colour) {
        super(engine, chessBoard, colour);
    }

    @Override
    public void move(Node position) {
        
    }

    @Override
    public IChessTheme getPieceIcon() {
        return DefualtTheme.PAWN;
    }

    @Override
    public void tick() {

    }
    
}
