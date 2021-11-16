package com.pichincha.tennis.game;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static String playerOne;
	private static String playerTwo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void initGame() {

		Scanner in = new Scanner(System.in);
		System.out.print("Player 1 name: ");
		playerOne = in.nextLine();
		System.out.println("Player 2 name: " );
		playerTwo = in.nextLine();
		System.out.println("Iniciar juego" );

		in.close();
	}

}
