package com.example.TicTacToe.stratergy;

import java.util.HashMap;
import java.util.Map;

import com.example.TicTacToe.models.Board;
import com.example.TicTacToe.models.Move;

public class RowWinningStratergy implements WinningStratergy{
		//row 			 char		count
	Map<Integer,HashMap<Character,Integer>> playerRowCount;
	
	public RowWinningStratergy() {
		// TODO Auto-generated constructor stub
		this.playerRowCount = new HashMap<>();
	}
	
	@Override
	public boolean checkWinner(Board board, Move move) {
		Integer row = move.getCell().getRow();
		if(playerRowCount.get(row)==null) {
			HashMap<Character, Integer> playercount = new HashMap<>();
			playercount.put(move.getPlayer().getSymbol(), 1);
			playerRowCount.put(row, playercount);
		}
		else {
			Map<Character , Integer> playercount = playerRowCount.get(row);
			if(playercount.get(move.getPlayer().getSymbol())==null) {
				playercount.put(move.getPlayer().getSymbol(), 1);
			}
			else {
				playercount.put(move.getPlayer().getSymbol(), playercount.get(move.getPlayer().getSymbol())+1);
			}
			playerRowCount.put(row, (HashMap<Character, Integer>) playercount);
			
			if(playerRowCount.get(row).get(move.getCell().getPlayer().getSymbol())== board.getDimensions()) {
				return true;
			}
		}
		return false;
	}

}
