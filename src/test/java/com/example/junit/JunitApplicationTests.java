package com.example.junit;

import com.example.junit.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitApplicationTests {

  @Test
  void contextLoads() {
    Calculator calculator = new Calculator();

    Assertions.assertAll(() -> {
      Assertions.assertEquals(3,calculator.add(1,2));
      Assertions.assertEquals(2,calculator.minus(3,1));
    });
  }

}
