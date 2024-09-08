package com.example.TicTacToe.factory;

import com.example.TicTacToe.models.BotPlayerDifficulty;
import com.example.TicTacToe.stratergy.BotPlayingStratergy;
import com.example.TicTacToe.stratergy.EasyBotPlayingStratergy;
import com.example.TicTacToe.stratergy.HardBotPlayingStratergy;
import com.example.TicTacToe.stratergy.MediumBotPlayingStratergy;

public class BotPlayingStratergyFactory {
	
	public static BotPlayingStratergy botPlyingStratergy(BotPlayerDifficulty botPlayerDifficulty) {
		if(botPlayerDifficulty.equals(BotPlayerDifficulty.EASY)) {
			return new EasyBotPlayingStratergy();
		}
		else if(botPlayerDifficulty.equals(BotPlayerDifficulty.MEDIUM)) {
			return new MediumBotPlayingStratergy();
		}
		else {
			return new HardBotPlayingStratergy();
		}
		
	}

}
