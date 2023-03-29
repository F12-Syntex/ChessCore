package com.chess.entities.chesspieces;

import com.chess.datatypes.Node;
import com.chess.engine.Engine;
import com.chess.entities.GraphicEntity;

public abstract class ChessPiece extends GraphicEntity{

    public ChessPiece(Engine engine) {
        super(engine);
    }

    public abstract void move(Node position);
    public abstract IChessTheme getIcon();
}
