package com.example.TicTacToe.models;

import lombok.Data;

@Data
public class Cell {
	private int row;
	private int col;
	private CellState cellState;
	private Player player;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		this.cellState=CellState.EMPTY;
	}

	public void display() {
		if(this.cellState.equals(CellState.EMPTY)) {
			System.out.print("|_|");
		}
		else if(this.cellState.equals(CellState.FILLED)) {
			System.out.print("|"+this.player.getSymbol()+"|");
		}
		
	}
	
	
	
}
