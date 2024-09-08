package com.example.TicTacToe.stratergy;

import com.example.TicTacToe.models.Board;
import com.example.TicTacToe.models.Move;

public interface WinningStratergy {

	boolean checkWinner(Board board,Move move);
	
}
