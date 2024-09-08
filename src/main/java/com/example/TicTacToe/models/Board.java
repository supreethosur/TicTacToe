package com.example.TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Board {

	
	private int dimensions;
	private List<List<Cell>> grid;
	
	public Board(int dimension) {
		this.dimensions = dimension;
		grid = new ArrayList<>();
		for(int i= 0;i<dimension;i++) {
			grid.add(new ArrayList<>());
			for(int j= 0 ;j< dimension ;j++) {
				grid.get(i).add(new Cell(i,j));
			}
		}
	}

	public void display() {
		for(List<Cell> row :grid) {
			for(Cell cell: row) {
				cell.display();
			}
			System.out.println();
		}
	}
	
}
