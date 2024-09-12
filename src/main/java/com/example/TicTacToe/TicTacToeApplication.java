package com.example.TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.TicTacToe.controller.GameController;
import com.example.TicTacToe.models.BotPlayer;
import com.example.TicTacToe.models.BotPlayerDifficulty;
import com.example.TicTacToe.models.Game;
import com.example.TicTacToe.models.GameState;
import com.example.TicTacToe.models.HumanPlayer;
import com.example.TicTacToe.models.Player;
import com.example.TicTacToe.stratergy.ColumnwinningStratergy;
import com.example.TicTacToe.stratergy.RowWinningStratergy;
import com.example.TicTacToe.stratergy.WinningStratergy;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TicTacToeApplication.class, args);
		
		GameController gameController =new GameController();
		Player player = new HumanPlayer("Supreet" ,"1", 'X');
		
		Player player1 = new BotPlayer("Botty", "2", 'O' ,BotPlayerDifficulty.EASY);
		List<Player> players = Arrays.asList(player,player1);
		
		List<WinningStratergy> winningStratergy =new ArrayList<>();
		WinningStratergy rowWinningStratergy = new RowWinningStratergy();
		WinningStratergy colWinningStratergy = new ColumnwinningStratergy();
		
		winningStratergy.add(rowWinningStratergy);
		winningStratergy.add(colWinningStratergy);
		
		Game game = gameController.startGame(3, players, winningStratergy);
		while(gameController.checkGameState(game).equals(GameState.IN_PROGRESS)) {
			gameController.makeMove(game);
			if(gameController.checkGameState(game).equals(GameState.GAME_WON)) {
				System.out.println("game won by:" + gameController.getWinner(game).getName());
			}
			else if(gameController.checkGameState(game).equals(GameState.DRAW)) {
				System.out.println("It's  a Tie");
			}
			gameController.display(game);
		}
	}

}
