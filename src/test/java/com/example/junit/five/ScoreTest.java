package com.example.junit.five;

import static org.junit.jupiter.api.Assertions.*;
import com.example.junit.score.ScoreCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {

  private ScoreCollection collection = new ScoreCollection();

  @Test
  @DisplayName("스코어 컬렉션 평균 구하기")
  void scoreCollectionArithmeticMean(){
    collection.add(() -> 5);
    collection.add(() -> 7);
    assertEquals(collection.arithmeticMean(), 6);
  }
}
