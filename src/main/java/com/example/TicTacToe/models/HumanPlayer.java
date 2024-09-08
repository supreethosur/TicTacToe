package com.example.TicTacToe.models;

import java.util.Scanner;

public class HumanPlayer  extends Player{

	Scanner sc = new Scanner(System.in);
	
	public HumanPlayer(String name, String id, Character symbol ) {
		super(name,id,symbol,PlayerType.HUMAN);
	}
	
	@Override
	public Move makeMove(Board board) {
		System.out.println(this.name + " pls make ur move");
		System.out.println("Enter row:");
		int r = sc.nextInt();
		System.out.println("Enter col:");
		int c = sc.nextInt();
		return new Move(new Cell(r, c), this);
	}

}
