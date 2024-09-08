package com.example.TicTacToe.models;

import com.example.TicTacToe.factory.BotPlayingStratergyFactory;
import com.example.TicTacToe.stratergy.BotPlayingStratergy;

public class BotPlayer extends Player{
	
	private BotPlayerDifficulty botPlayerDifficulty;
	private BotPlayingStratergy botPlayingStratergy;

	public BotPlayer(String name, String id, Character symbol, BotPlayerDifficulty botPlayerDifficulty) {
		super(name, id, symbol, PlayerType.BOT);
		this.botPlayerDifficulty = botPlayerDifficulty;
		this.botPlayingStratergy = BotPlayingStratergyFactory.botPlyingStratergy(botPlayerDifficulty);
	}

	

	@Override
	public Move makeMove(Board board) {
		// TODO Auto-generated method stub
		return null;
	}
}