package com.example.TicTacToe.stratergy;

import java.util.HashMap;
import java.util.Map;

import com.example.TicTacToe.models.Board;
import com.example.TicTacToe.models.Move;

public class ColumnwinningStratergy implements WinningStratergy{
		//col,   	player   ,count
	Map<Integer,HashMap<Character,Integer>> playerColumnCount = new HashMap<>();
	
	public  ColumnwinningStratergy() {
		this.playerColumnCount = new HashMap<>();
	}
	
	@Override
	public boolean checkWinner(Board board, Move move) {
		Integer col = move.getCell().getCol();
		if(playerColumnCount.get(col)==null) {
			Map<Character , Integer> playercount = new HashMap<>();
			playercount.put(move.getPlayer().getSymbol(), 1);
			playerColumnCount.put(col, (HashMap<Character, Integer>) playercount);
		}
		else {
			Map<Character , Integer> playercount = playerColumnCount.get(col);
			if(playercount.get(move.getPlayer().getSymbol())==null) {
				playercount.put(move.getPlayer().getSymbol(), 1);
			}
			else {
				playercount.put(move.getPlayer().getSymbol(), playercount.get(move.getPlayer().getSymbol())+1);
			}
			playerColumnCount.put(col, (HashMap<Character, Integer>) playercount);
			
			if(playerColumnCount.get(col).get(move.getCell().getPlayer().getSymbol())== board.getDimensions()) {
				return true;
			}
		}
		return false;
	}

}
