package com.example.TicTacToe.stratergy;

import com.example.TicTacToe.models.Board;
import com.example.TicTacToe.models.Cell;

public interface BotPlayingStratergy {
	
	Cell makeMove(Board board);
	
}
