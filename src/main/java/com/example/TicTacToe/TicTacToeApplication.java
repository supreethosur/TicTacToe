package com.example.TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.TicTacToe.stratergy.DiagonalWinningStratergy;
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
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the number of Players");
//		int playersCount = sc.nextInt();
//		for(int i=1 ; i<=playersCount ;i++ ){
//			System.out.println("Enter the name of Player : " + i);
//			String name = sc.next();
//			System.out.println("Enter the symbol for Player : " + name);
//			String symbol = sc.next();
//		}
//		System.out.println("Select the game difficulty");
//		System.out.println("1 for easy");
//		System.out.println("2 for difficult");
//		int difficutyInt = sc.nextInt();
//		BotPlayerDifficulty difficulty;
//		if(difficutyInt==1){
//			 difficulty = BotPlayerDifficulty.EASY;
//		}
//		else{
//			difficulty= BotPlayerDifficulty.MEDIUM;
//		}
		GameController gameController =new GameController();
		Player player = new HumanPlayer("Supreet" ,"1", 'X');
		
		Player player1 = new BotPlayer("Botty", "2", 'O' ,BotPlayerDifficulty.EASY);
		List<Player> players = Arrays.asList(player,player1);
		
		List<WinningStratergy> winningStratergy =new ArrayList<>();
		WinningStratergy rowWinningStratergy = new RowWinningStratergy();
		WinningStratergy colWinningStratergy = new ColumnwinningStratergy();
		WinningStratergy diaWinningStratergy = new DiagonalWinningStratergy();

		winningStratergy.add(rowWinningStratergy);
		winningStratergy.add(colWinningStratergy);
		winningStratergy.add(diaWinningStratergy);

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
