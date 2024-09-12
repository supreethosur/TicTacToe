package com.example.TicTacToe.stratergy;

import com.example.TicTacToe.models.Board;
import com.example.TicTacToe.models.Cell;
import com.example.TicTacToe.models.CellState;

public class EasyBotPlayingStratergy implements BotPlayingStratergy{

	@Override
	public Cell makeMove(Board board) {
		
		for(int r = 0; r < board.getDimensions(); r++) {
			for(int c = 0; c < board.getDimensions(); c++) {
				if(!board.getGrid().get(r).get(c).getCellState().equals(CellState.FILLED)) {
					return new Cell(r,c);
				}
			}
		}
		
		return null;
	}

}
