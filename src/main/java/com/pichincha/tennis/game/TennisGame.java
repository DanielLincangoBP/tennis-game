package com.pichincha.tennis.game;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

  private Map<Integer, Integer> score;

  public TennisGame() {
    this.score = new HashMap<>();
    this.score.put(0, 0);
    this.score.put(1, 15);
    this.score.put(2, 30);
    this.score.put(3, 40);
  }

  public int getScore(Integer score) {
    return 0;
  }

}
