package com.chess.entities.chesspieces;

import com.chess.datatypes.Node;
import com.chess.engine.Engine;

public class Pawn extends ChessPiece{

    public Pawn(Engine engine) {
        super(engine);
    }

    @Override
    public void move(Node position) {
        
    }

    @Override
    public IChessTheme getIcon() {
        return DefualtTheme.PAWN;
    }

    @Override
    public void tick() {

    }
    
}
