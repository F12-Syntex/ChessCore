package com.chess.datatypes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Optional;
import java.util.function.Consumer;

/*
 * This class is used to store the nodes of the chess board
 * @author Saif
 * @version 1.0.0
 * @since 1.0.1
 */
public class Grid {

    private BoardSquare[][] grid;

    public Grid(int width, int height){
        this.grid = new BoardSquare[height][width];
    }

    public Grid(){
        this(8, 8);
    }

    public int getHeight(){
        return this.grid.length;
    }

    public Optional<BoardSquare> getNode(int x, int y){
        BoardSquare pieceType = grid[y][x];
        if(pieceType == null){
            return Optional.empty();
        }else{
            return Optional.of(pieceType);
        }
    }

    public Optional<BoardSquare> getNode(Node node){
        BoardSquare pieceType = grid[node.y][node.x];
        if(pieceType == null){
            return Optional.empty();
        }else{
            return Optional.of(pieceType);
        }
    }

    /* 
    public void setNodeChessPiece(int x, int y, ChessPiece node){
        this.initialiseNode(Node.of(x, y));
        this.grid[y][x].setChesspiece(node);
    }
    */
    
    public void setNodeChessDimentions(int x, int y, Rectangle dimention){
        this.initialiseNode(Node.of(x, y));
        this.grid[y][x].setBounds(dimention);
    }

    private void initialiseNode(Node node){
        if(this.grid[node.y][node.x] == null){
            this.grid[node.y][node.x] = new BoardSquare(null, null, node);
        }
    }
    
    public int getWidth(){
        return this.grid.length == 0 ? 0 : this.grid[0].length;
    }

    public void traverse(Consumer<Node> node){
        for(int y = 0; y < this.getHeight(); y++){
            for(int x = 0; x < this.getWidth(); x++){
                node.accept(Node.of(x, y));
            }
        }
    }

    public Optional<BoardSquare> getSquareFromPoint(Point point){
        for(BoardSquare[] row : this.grid){
            for(BoardSquare col : row){
                if(col == null || col.getBounds() == null){
                    continue;
                }
                if(col.getBounds().contains(point)){
                    return Optional.of(col);
                }
            }
        }
        return Optional.empty();
    }

}
