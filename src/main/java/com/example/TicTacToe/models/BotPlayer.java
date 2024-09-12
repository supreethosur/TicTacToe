package com.example.TicTacToe.models;

import com.example.TicTacToe.factory.BotPlayingStratergyFactory;
import com.example.TicTacToe.stratergy.BotPlayingStratergy;

public class BotPlayer extends Player{
	
	private BotPlayingStratergy botPlayingStratergy;

	public BotPlayer(String name, String id, Character symbol, BotPlayerDifficulty botPlayerDifficulty) {
		super(name, id, symbol, PlayerType.BOT);
		this.botPlayingStratergy = BotPlayingStratergyFactory.botPlyingStratergy(botPlayerDifficulty);
	}

	

	@Override
	public Move makeMove(Board board) {
		System.out.println("Calculating Bot's move");
		Cell cell = botPlayingStratergy.makeMove(board);
		return new Move(cell,this);
	}
}