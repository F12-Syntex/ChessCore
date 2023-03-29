package com.chess.chess;

import com.chess.engine.Engine;
import com.chess.entities.GraphicEntity;

public class MoveCounter extends GraphicEntity {

   // private JTextArea area;

    public MoveCounter(Engine engine) {
        super(engine);
        //this.area = new JTextArea("asd");
        //this.area.setVisible(true);
        //this.add(this.area);
    }

    @Override
    public void tick() {

        /*
        ChessBoard board = this.engine.getGraphicEntity(ChessBoard.class);
        Rectangle boardBounds = board.getBounds();
        System.out.println("bounds: " + boardBounds);

        Dimension window = ChessCore.getInstance().getWindow().getSize();
        //window.width - boardBounds.width, window.height
        Dimension size = new Dimension(400, (int)window.getHeight());

        this.area.setPreferredSize(size);
        this.area.setVisible(true);
        */
    }

    @Override
    public int getPriority() {
        return 1;
    }
    
}
