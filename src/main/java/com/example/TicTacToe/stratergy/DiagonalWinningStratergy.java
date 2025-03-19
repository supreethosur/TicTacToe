package com.example.TicTacToe.stratergy;

import com.example.TicTacToe.models.Board;
import com.example.TicTacToe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStratergy implements WinningStratergy{
		//row 			 char		count
	Map<String,HashMap<Character,Integer>> playerDiagonalCount;

	public DiagonalWinningStratergy() {
		this.playerDiagonalCount = new HashMap<>();
		this.playerDiagonalCount.put("left" , new HashMap<>());
		this.playerDiagonalCount.put("right" , new HashMap<>());
	}
	
	@Override
	public boolean checkWinner(Board board, Move move) {
		Integer row = move.getCell().getRow();
		Integer col = move.getCell().getCol();
		String dia = diagonalCell(row,col, board.getDimensions());
		HashMap<Character, Integer> leftDia = playerDiagonalCount.get("left");
		HashMap<Character, Integer> rightDia = playerDiagonalCount.get("right");
		if(dia.equals("left") || dia.equals("both")){
			leftDia.putIfAbsent(move.getPlayer().getSymbol(),0);
			leftDia.put(move.getPlayer().getSymbol(),leftDia.get(move.getPlayer().getSymbol())+1);
			this.playerDiagonalCount.put("left" , leftDia);
			if(leftDia.get(move.getPlayer().getSymbol()) == board.getDimensions() ){
				return true;
			}
		}
		if( dia.equals("right") || dia.equals("both") ){
			rightDia.putIfAbsent(move.getPlayer().getSymbol(),0);
			rightDia.put(move.getPlayer().getSymbol(),rightDia.get(move.getPlayer().getSymbol())+1);
			this.playerDiagonalCount.put("right" , rightDia);
			if(rightDia.get(move.getPlayer().getSymbol()) == board.getDimensions() ){
				return true;
			}
		}
		return false;
	}

	private String diagonalCell(Integer row, Integer col, int dimensions) {
		if(row==col && row+col == dimensions-1){
			return "both";
		}
		else{
			if(row==col){
				return "left";
			}
			else if(row+col == dimensions-1){
					return "right";
			}
			else{
				return "none";
			}
		}
	}
}
