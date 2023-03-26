package com.chess.datatypes;

import java.awt.Point;
import java.util.Objects;

/*
 * This class represents a node in the graph.
 * A better alternative to java.awt.Point
 * @author: Saif
 * @version: 1.0.0
 * @since: 1.0.0
 * @see java.awt.Point
 */
public class Node extends Point{
	
	private static final long serialVersionUID = 432228847006839544L;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Node of(int x, int y) {
		Node node = new Node(x, y);
		return node;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.x, this.y);
	}
	
	@Override
	public boolean equals(Object obj) {	
		if(obj instanceof Point) {
			Point p = (Point)obj;
			if(p.x == this.x && p.y == this.y) {
				return true;
			}
		}
		
		return false;
	}
	
	public Node add(int x, int y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Node add(Point point) {
		this.x += point.x;
		this.y += point.y;
		return this;
	}

}
