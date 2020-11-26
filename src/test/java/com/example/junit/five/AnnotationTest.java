package com.example.junit.five;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class AnnotationTest {

  static Object staticObject;

  Object object1;

  @BeforeAll
  static void beforeAllTest() {
    log.debug("beforeAllTest");
    staticObject = new Object();
    log.debug("staticObject : " + staticObject.hashCode());
  }

  @BeforeEach
  void beforeEachTest() {
    log.debug("beforeEachTest");
    object1 = new Object();
    log.debug("object : " + object1.hashCode());
  }

  @AfterEach
  void afterEachTest() {
    log.debug("afterEachTest");
    object1 = new Object();
    log.debug("object : " + object1.hashCode());
  }

  @AfterAll
  static void afterAllTest() {
    log.debug("afterAllTest");
    staticObject = new Object();
    log.debug("staticObject : " + staticObject.hashCode());
  }

  @Test
  void test1() {
    log.debug("test1");
    log.debug("staticObject : " + staticObject.hashCode());
    log.debug("object : " + object1.hashCode());
  }

  @Test
  void test2() {
    log.debug("test2");
    log.debug("staticObject : " + staticObject.hashCode());
    log.debug("object : " + object1.hashCode());
  }

  //output

  //23:01:31.539 [main] DEBUG com.example.junit.five.AnnotationTest - beforeAllTest
  //23:01:31.547 [main] DEBUG com.example.junit.five.AnnotationTest - staticObject : 1328238652
  //
  //23:01:31.560 [main] DEBUG com.example.junit.five.AnnotationTest - beforeEachTest
  //23:01:31.560 [main] DEBUG com.example.junit.five.AnnotationTest - object : 313239742
  //23:01:31.562 [main] DEBUG com.example.junit.five.AnnotationTest - test1
  //23:01:31.563 [main] DEBUG com.example.junit.five.AnnotationTest - staticObject : 1328238652
  //23:01:31.563 [main] DEBUG com.example.junit.five.AnnotationTest - object : 313239742
  //23:01:31.566 [main] DEBUG com.example.junit.five.AnnotationTest - afterEachTest
  //23:01:31.566 [main] DEBUG com.example.junit.five.AnnotationTest - object : 290579508
  //
  //
  //23:01:31.577 [main] DEBUG com.example.junit.five.AnnotationTest - beforeEachTest
  //23:01:31.578 [main] DEBUG com.example.junit.five.AnnotationTest - object : 1623009085
  //23:01:31.578 [main] DEBUG com.example.junit.five.AnnotationTest - test2
  //23:01:31.578 [main] DEBUG com.example.junit.five.AnnotationTest - staticObject : 1328238652
  //23:01:31.579 [main] DEBUG com.example.junit.five.AnnotationTest - object : 1623009085
  //23:01:31.579 [main] DEBUG com.example.junit.five.AnnotationTest - afterEachTest
  //23:01:31.580 [main] DEBUG com.example.junit.five.AnnotationTest - object : 303240439
  //
  //23:01:31.583 [main] DEBUG com.example.junit.five.AnnotationTest - afterAllTest
  //23:01:31.584 [main] DEBUG com.example.junit.five.AnnotationTest - staticObject : 1297502382
}
