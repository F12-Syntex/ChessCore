package com.chess.datatypes;

/*
 * This class is used to store the nodes of the chess board
 * @author Saif
 * @version 1.0.0
 * @since 1.0.1
 */
public class Grid {

    private Node[][] grid;

    public Grid(int width, int height){
        this.grid = new Node[height][width];
    }

    public Grid(){
        this(8, 8);
    }

    public Node getNode(int x, int y){
        return this.grid[y][x];
    }

    public void setNode(int x, int y, Node node){
        this.grid[y][x] = node;
    }

}
