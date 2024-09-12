package com.example.TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

import com.example.TicTacToe.stratergy.WinningStratergy;

public class Game {
	private Board board;
	private List<Player> players;
	private int nextPlayerIndex;
	private Player winner;
	private List<Move> moves;
	private GameState gameState;
	private List<WinningStratergy> winningStratergies;

	public Game(int dimension, List<Player> players, List<WinningStratergy> winningStratergy) {
		this.nextPlayerIndex = 0;
		this.gameState=GameState.IN_PROGRESS;
		this.board = new Board(dimension);
		this.players = players;
		this.winningStratergies = winningStratergy;
		this.gameState = GameState.IN_PROGRESS;
		this.moves= new ArrayList<>();
	}

	
	public GameState getGameState() {
		return gameState;
	}


	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	

	public Player getWinner() {
		return winner;
	}


	public static  Builder getBuilder() {
		return new Builder();
	}

	public static class Builder{

		private int dimension;
		private List<Player> players;
		private List<WinningStratergy> winningStratergies;

		public Builder setDimension(int dimension) {
			this.dimension = dimension;
			return this;
		}

		public Builder setPlayers(List<Player> players) {
			this.players = players;
			return this;
		}

		public Builder setWinningStratergy(List<WinningStratergy> winningStratergy) {
			this.winningStratergies = winningStratergy;
			return this;
		}

		public Game build() throws Exception {
			if(validate(this.dimension, this.players)) {
				return new Game(this.dimension, this.players, this.winningStratergies);
			}
			throw new Exception("");
		}

		public static boolean validate(int dimension, List<Player> players) {
			if(dimension > players.size() ) {
				return true;
			}
			return false;
		}
	}

	public void display() {
			board.display();
	}

//	public Move makeMove() {
//		Player currentPlayer = players.get(nextPlayerIndex);
//		Move move = currentPlayer.makeMove(board);
//		
//		
//		moves.add(move);
//		
//		if(checkWinner(move)) {
//			this.winner = currentPlayer;
//			this.gameState = GameState.GAME_WON;
//		}
//		nextPlayerIndex=(nextPlayerIndex+1)%players.size();
//		return move;
//	}
	
	public void makeMove(){
        //make a move
        //Check the next player
        Player currentPlayer = players.get(nextPlayerIndex);
        Move move;
        //Validate the move
        do {
            //Ask the player to make the move
            move = currentPlayer.makeMove(board);
        }while(!validateMove(move));
        //Update the board/cell
        Cell cellToUpdate = board.getGrid().get(move.getCell().getRow()).get(move.getCell().getCol());
        move.setCell(cellToUpdate);
        
        move.getCell().setCellState(CellState.FILLED);
        move.getCell().setPlayer(currentPlayer);

        //Store the move
        moves.add(move);

        //Check and set winner
        if(checkWinner(move)){
            setGameState(GameState.GAME_WON);
            this.winner = currentPlayer;
        }
        else if (moves.size()==board.getDimensions()*board.getDimensions()) {
        	setGameState(GameState.DRAW);
        	this.winner=null;
        }
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();

    }
	private boolean validateMove(Move move) {
		if(move.getCell().getRow()>=board.getDimensions() || move.getCell().getCol()>=board.getDimensions()
				|| move.getCell().getRow()<0 || move.getCell().getCol()<0
				) {
			return false;
		}
		if(board.getGrid().get(move.getCell().getRow()).get(move.getCell().getCol()).getCellState()
				==CellState.FILLED) {
			return false;
		}
		
		return true;
	}

	boolean checkWinner(Move move){
		for(WinningStratergy winningStratergy : this.winningStratergies) {
			if(winningStratergy.checkWinner(this.board, move)) {
				return true;
			}
		}
		return false;
	}

}
