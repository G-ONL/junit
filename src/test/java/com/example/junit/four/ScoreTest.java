package com.example.junit.four;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.example.junit.score.ScoreCollection;
import org.junit.jupiter.api.Test;

public class ScoreTest {

  private ScoreCollection collection = new ScoreCollection();

  @Test
  public void scoreCollectionArithmeticMean(){
    collection.add(()-> 5);
    collection.add(()-> 7);
    assertThat(collection.arithmeticMean(), equalTo(6));

  }
}
