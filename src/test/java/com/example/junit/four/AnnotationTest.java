package com.example.junit.four;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Slf4j
public class AnnotationTest {

  static Object staticObject;
  Object object1;

  @BeforeClass
  public static void beforeClassTest() {
    log.debug("BeforeClass");
    staticObject = new Object();
    log.debug("staticObject : " + staticObject.hashCode());
  }

  @Before
  public void beforeTest() {
    log.debug("Before");
    object1 = new Object();
    log.debug("object : " + object1.hashCode());
  }

  @After
  public void afterTest() {
    log.debug("After");
    object1 = new Object();
    log.debug("object : " + object1.hashCode());
  }

  @AfterClass
  public static void afterClassTest() {
    log.debug("After");
    staticObject = new Object();
    log.debug("staticObject : " + staticObject.hashCode());
  }

  @Test
  public void test1() {
    log.debug("test1");
    log.debug("staticObject : " + staticObject.hashCode());
    log.debug("object : " + object1.hashCode());
  }

  @Test
  public void test2() {
    log.debug("test2");
    log.debug("staticObject : " + staticObject.hashCode());
    log.debug("object : " + object1.hashCode());
  }

  //output

  //22:59:44.032 [main] DEBUG com.example.junit.four.AnnotationTest - BeforeClass
  //22:59:44.070 [main] DEBUG com.example.junit.four.AnnotationTest - staticObject : 667447085

  //22:59:44.078 [main] DEBUG com.example.junit.four.AnnotationTest - Before
  //22:59:44.079 [main] DEBUG com.example.junit.four.AnnotationTest - object : 689401025
  //22:59:44.079 [main] DEBUG com.example.junit.four.AnnotationTest - test1
  //22:59:44.080 [main] DEBUG com.example.junit.four.AnnotationTest - staticObject : 667447085
  //22:59:44.080 [main] DEBUG com.example.junit.four.AnnotationTest - object : 689401025
  //22:59:44.081 [main] DEBUG com.example.junit.four.AnnotationTest - After
  //22:59:44.081 [main] DEBUG com.example.junit.four.AnnotationTest - object : 790067787

  //22:59:44.089 [main] DEBUG com.example.junit.four.AnnotationTest - Before
  //22:59:44.089 [main] DEBUG com.example.junit.four.AnnotationTest - object : 867148091
  //22:59:44.089 [main] DEBUG com.example.junit.four.AnnotationTest - test2
  //22:59:44.090 [main] DEBUG com.example.junit.four.AnnotationTest - staticObject : 667447085
  //22:59:44.090 [main] DEBUG com.example.junit.four.AnnotationTest - object : 867148091
  //22:59:44.091 [main] DEBUG com.example.junit.four.AnnotationTest - After
  //22:59:44.091 [main] DEBUG com.example.junit.four.AnnotationTest - object : 2051853139

  //22:59:44.092 [main] DEBUG com.example.junit.four.AnnotationTest - After
  //22:59:44.093 [main] DEBUG com.example.junit.four.AnnotationTest - staticObject : 815674463

}
