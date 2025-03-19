package com.example.TicTacToe.models;


public abstract class Player {
	protected String name;
	private String Id;
	private Character symbol;
	private PlayerType playerType;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Character getSymbol() {
		return symbol;
	}

	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	public abstract Move makeMove(Board board) ;



	public Player(String name, String id, Character symbol, PlayerType playerType) {
		super();
		this.name = name;
		Id = id;
		this.symbol = symbol;
		this.playerType = playerType;
	}
		
	
}
