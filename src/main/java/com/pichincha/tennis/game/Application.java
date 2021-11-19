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
	private static boolean isDeuce;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		scorePlayerOne = 0;
		scorePlayerTwo = 0;
		addPointManual();
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
			if (Math.round( Math.random())  == 1) {
				scorePlayerTwo += 1;
			} else {
				scorePlayerOne += 1;
			}
			System.out.println(getScore());
			isWinner = validateWinner();
		}

	}

	public static void addPointManual() {
		Scanner in = new Scanner(System.in);

		while (!isWinner) {
			System.out.print("Player (1 or 2 --> Default 1): ");
			String playerSelected = in.nextLine();
			if (playerSelected.compareTo("2") == 0) {
				scorePlayerTwo += 1;
			} else {
				scorePlayerOne += 1;
			}
			isDeuce = (scorePlayerOne ==scorePlayerTwo) && (scorePlayerTwo >= 3);
			System.out.println(getScore());
			isWinner = validateWinner();
		}
	}

	private static boolean validateWinner() {

		if (isDeuce) return false;
		if (scorePlayerTwo <= 3 && scorePlayerOne <= 3) return false;
		if (scorePlayerTwo == 4 && scorePlayerOne < 3) return true;
		if (scorePlayerTwo < 3 && scorePlayerOne == 4) return true;
		return Math.abs (scorePlayerTwo - scorePlayerOne) == 2;

	}

	public static String getScore () {

		StringBuilder result = new StringBuilder();
		result.append("Score Player 1: ");
		if (scorePlayerOne<=3) {
			result.append(getResult(scorePlayerOne));
		} else if (scorePlayerOne > scorePlayerTwo) {
			result.append(getResult(5));
		}else if (scorePlayerOne < scorePlayerTwo) {
			result.append(getResult(3));
		} else {
			result.append(getResult(scorePlayerOne));
		}
		result.append(" - Score Player 2: ");
		if (scorePlayerTwo<=3) {
			result.append(getResult(scorePlayerTwo));
		} else if (scorePlayerOne < scorePlayerTwo) {
			result.append(getResult(5));
		}else if (scorePlayerOne > scorePlayerTwo) {
			result.append(getResult(3));
		} else {
			result.append(getResult(scorePlayerOne));
		}

		return result.toString();
	}

	private static String getResult (Integer points) {
		String result;
		Map<Integer, String> score = new HashMap<>();
		score.put(0, "0");
		score.put(1, "15");
		score.put(2, "30");
		score.put(3, "40");
		score.put(4, "WINNER");
		score.put(5, "ADVANTAGE");
		return isDeuce ? "DEUCE" :score.get(points);


	}

}
