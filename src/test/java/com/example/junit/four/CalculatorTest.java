package com.example.junit.four;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.example.junit.calculator.Calculator;
import org.junit.jupiter.api.Test;

class CalculatorTest {


  Calculator calculator = new Calculator();

  @Test
  public void addTest() {
    assertThat(calculator.add(1, 2), equalTo(3));
  }

}
