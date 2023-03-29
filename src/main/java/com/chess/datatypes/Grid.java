package com.chess.datatypes;

import java.util.Optional;
import java.util.function.Consumer;

import com.chess.entities.chesspieces.ChessPiece;

/*
 * This class is used to store the nodes of the chess board
 * @author Saif
 * @version 1.0.0
 * @since 1.0.1
 */
public class Grid {

    private ChessPiece[][] grid;

    public Grid(int width, int height){
        this.grid = new ChessPiece[height][width];
    }

    public Grid(){
        this(8, 8);
    }

    public int getHeight(){
        return this.grid.length;
    }

    public Optional<ChessPiece> getNode(int x, int y){
        ChessPiece pieceType = grid[y][x];
        if(pieceType == null){
            return Optional.empty();
        }else{
            return Optional.of(pieceType);
        }
    }

    public void setNode(int x, int y, ChessPiece node){
        this.grid[y][x] = node;
    }

    public int getWidth(){
        return this.grid[0].length;
    }

    public void traverse(Consumer<Node> node){
        for(int y = 0; y < this.getHeight(); y++){
            for(int x = 0; x < this.getWidth(); x++){
                node.accept(Node.of(x, y));
            }
        }
    }

}
