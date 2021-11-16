package com.pichincha.tennis.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


	private static String playerOne;
	private static String playerTwo;

	private static Integer scorePlayerOne;
	private static Integer scorePlayerTwo;

	private static boolean isWinner;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		addPoint();
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

	public static void addPoint() {
		Scanner in = new Scanner(System.in);

		while (!isWinner){
			/*
			System.out.print("Player (1 or 2 --> Default 1): ");
			String playerSelected = in.nextLine();
			if (playerSelected.compareTo("2")==0) {
				scorePlayerTwo += 1;
			} else {
				scorePlayerOne += 1;
			}
			 */

			if (Math.round( Math.random())  == 1) {
				scorePlayerTwo += 1;
			} else {
				scorePlayerOne += 1;
			}
			System.out.println(getScore());
			isWinner = (scorePlayerOne == 3 || scorePlayerTwo == 3);
		}



	}

	public static String getScore () {

		 StringBuilder result = new StringBuilder();
		 result.append("Score Player 1: ");
		result.append(getResult(scorePlayerOne));
		result.append(" - Score Player 2: ");
		result.append(getResult(scorePlayerTwo));

		return result.toString();
	}

	private static String getResult (Integer points) {
		Map<Integer, String> score = new HashMap<>();
		score.put(0, "0");
		score.put(1, "15");
		score.put(2, "30");
		score.put(3, "40");
		return score.get(points);


	}

}
