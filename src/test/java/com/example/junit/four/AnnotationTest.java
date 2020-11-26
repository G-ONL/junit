package com.example.junit.four;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationTest {

  static Object staticObject = new Object();
  Object object1;

  @BeforeClass
  public static void beforeClassTest(){
    System.out.println("BeforeClass");
    System.out.println("staticObject" + staticObject.hashCode());
  }

  @Before
  public void beforeTest(){
    System.out.println("Before");
    object1 = new Object();
    System.out.println("staticObject" + staticObject.hashCode());
    System.out.println("object" + object1.hashCode());
  }

  @After
  public void afterTest(){
    System.out.println("After");
    object1 = new Object();
    System.out.println("staticObject" + staticObject.hashCode());
    System.out.println("object" + object1.hashCode());
  }

  @AfterClass
  public static void afterClassTest(){
    System.out.println("After");
    System.out.println("staticObject" + staticObject.hashCode());
  }

  @Test
  public void test1(){
    System.out.println("test1");
    object1 = new Object();
    System.out.println("staticObject" + staticObject.hashCode());
    System.out.println("object" + object1.hashCode());
  }

  @Test
  public void test2(){
    System.out.println("test2");
    object1 = new Object();
    System.out.println("staticObject" + staticObject.hashCode());
    System.out.println("object" + object1.hashCode());
  }

  //output

  //BeforeClass
  //staticObject1579526446

  //Before
  //staticObject1579526446
  //object93314457
  //test1
  //staticObject1579526446
  //object1796371666
  //After
  //staticObject1579526446
  //object2076287037

  //Before
  //staticObject1579526446
  //object1773638882
  //test2
  //staticObject1579526446
  //object1059063940
  //After
  //staticObject1579526446
  //object1295226194

  //After
  //staticObject1579526446

}
