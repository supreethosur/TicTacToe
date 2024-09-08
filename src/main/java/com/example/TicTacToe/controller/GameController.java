package com.example.TicTacToe.controller;

import java.util.List;

import com.example.TicTacToe.models.Game;
import com.example.TicTacToe.models.Player;
import com.example.TicTacToe.stratergy.WinningStratergy;

public class GameController {

	public Game startGame(int dimension,List<Player> players, List<WinningStratergy> winningStratergy) throws Exception {
		// TODO Auto-generated method stub
		return Game.getBuilder()
		.setDimension(dimension)
		.setPlayers(players)
		.setWinningStratergy(winningStratergy)
		.build();
	}


	public Object checkGameState(Game game) {
		return game.getGameState();
	}

	public void display(Game game) {
		game.display();
		
	}

	public void makeMove(Game game) {
		game.makeMove();
		
	}

	public Player getWinner(Game game) {
		// TODO Auto-generated method stub
		return game.getWinner();
	}

}
