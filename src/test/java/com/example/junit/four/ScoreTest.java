package com.example.junit.four;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.example.junit.score.ScoreCollection;
import org.junit.jupiter.api.Test;

public class ScoreTest {

  private ScoreCollection scores = new ScoreCollection();

  @Test
  public void scoreCollectionArithmeticMean(){
    scores.add(()-> 5);
    scores.add(()-> 7);
    assertThat(scores.arithmeticMean(), equalTo(6));

  }
}
