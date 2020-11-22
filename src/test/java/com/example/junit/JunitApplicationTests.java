package com.example.junit;

import com.example.junit.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitApplicationTests {

  //beforeAll
  //beforeEach
  //Test
  //afterEach
  //afterAll

  //tag
  //disabled

  //assertThrows
  //assertAll
  //assertTimeout

  //NESTED

  Calculator calculator = new Calculator();

  @Nested
  @DisplayName("Plus method")
  class PlusMethod {
    @Nested
    @DisplayName("더하는 숫자가 음수일 경우")
    class Handle_Minus_Number {

      @Test
      void return_sum_of_number() {
        Assertions.assertEquals(-1, calculator.add(-1,0));
      }
    }
  }

  @Test
  @DisplayName("계산기")
  void contextLoads() {

    Assertions.assertAll("계산기 더하기/빼기 테스트",
        () -> Assertions.assertEquals(3,calculator.add(1,2)),
        () -> Assertions.assertEquals(2,calculator.minus(3,1))
    );
  }

}
