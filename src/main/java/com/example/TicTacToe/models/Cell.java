package com.example.TicTacToe.models;


public class Cell {
	private int row;
	private int col;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public CellState getCellState() {
		return cellState;
	}

	public void setCellState(CellState cellState) {
		this.cellState = cellState;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

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
