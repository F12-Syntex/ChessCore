package com.chess.chess;

import java.awt.Graphics;

import javax.swing.JTextArea;

import com.chess.engine.Engine;
import com.chess.entities.GraphicEntity;

public class MoveCounter extends GraphicEntity {

    private JTextArea area;

    public MoveCounter(Engine engine) {
        super(engine);
       // this.area = new JTextArea("asd");
       // this.engine.add(area, BorderLayout.EAST);
       // this.area.setVisible(false);
    }

    @Override
    public void render(Graphics g) {}

    @Override
    public void tick() {

        //ChessBoard board = this.engine.getGraphicEntity(ChessBoard.class);
       // Rectangle boardBounds = board.getBounds();
        //System.out.println("bounds: " + boardBounds);

        //Dimension window = ChessCore.getInstance().getWindow().getSize();
        //Dimension size = new Dimension(window.width - boardBounds.width, window.height);

        //this.area.setPreferredSize(size);
        //this.area.setVisible(true);
    }

    @Override
    public int getPriority() {
        return 1;
    }
    
}
