package com.example.TicTacToe.models;

import lombok.Data;

@Data
public abstract class Player {
	protected String name;
	private String Id;
	private Character symbol;
	private PlayerType playerType;
	
	
	
	public abstract Move makeMove(Board board) ;



	public Player(String name, String id, Character symbol, PlayerType playerType) {
		super();
		this.name = name;
		Id = id;
		this.symbol = symbol;
		this.playerType = playerType;
	}
		
	
}
