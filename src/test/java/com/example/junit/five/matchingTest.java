package com.example.junit.five;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.junit.txp.Level;
import com.example.junit.txp.MatchingApplication;
import com.example.junit.txp.People;
import com.example.junit.txp.Project;
import com.example.junit.txp.ProjectPool;
import com.example.junit.txp.Skill;
import com.example.junit.txp.Weight;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class matchingTest {

  private People people;
  private Project perfectMatchProject;
  private Project importantProject;
  private Project dontCareProject;
  private ProjectPool projectPool;

  MatchingApplication matchingApplication = new MatchingApplication();

  @BeforeEach
  void init() {
    people = new People("홍길동");
    people.add(new Skill("Java", Level.PROFESSIONAL));
    people.add(new Skill("Spring Boot", Level.PROFESSIONAL));
    people.add(new Skill("PostgreSQL", Level.INTERMEDIATE));
    people.add(new Skill("Spring Batch", Level.INTERMEDIATE));
    people.add(new Skill("MySQL", Level.INTERMEDIATE));
    people.add(new Skill("Kafka", Level.BEGINNER));
    people.add(new Skill("Git", Level.INTERMEDIATE));

    perfectMatchProject = new Project("[성남]네이버 차세대 시스템 구축");

    perfectMatchProject.add(new Skill("Java", Level.PROFESSIONAL));
    perfectMatchProject.add(new Skill("Spring Boot", Level.PROFESSIONAL));
    perfectMatchProject.add(new Skill("PostgreSQL", Level.INTERMEDIATE));
    perfectMatchProject.add(new Skill("Spring Batch", Level.INTERMEDIATE));
    perfectMatchProject.add(new Skill("MySQL", Level.INTERMEDIATE));
    perfectMatchProject.add(new Skill("Kafka", Level.BEGINNER));
    perfectMatchProject.add(new Skill("Git", Level.INTERMEDIATE));

    importantProject = new Project("[서울]스타벅스 차세대 시스템 구축");

    importantProject.add(new Skill("Python", Level.PROFESSIONAL));
    importantProject.add(new Skill("Django", Level.PROFESSIONAL));
    importantProject.add(new Skill("MongoDB", Level.INTERMEDIATE));
    importantProject.add(new Skill("MySQL", Level.INTERMEDIATE));
    importantProject.add(new Skill("Kafka", Level.BEGINNER));
    importantProject.add(new Skill("Git", Level.INTERMEDIATE));

    dontCareProject = new Project("[수원]삼성전자 차세대 시스템 구축");

    dontCareProject.add(new Skill("Python", Level.PROFESSIONAL));
    dontCareProject.add(new Skill("Django", Level.PROFESSIONAL));
    dontCareProject.add(new Skill("MongoDB", Level.INTERMEDIATE));
    dontCareProject.add(new Skill("Ruby", Level.INTERMEDIATE));
    dontCareProject.add(new Skill("Kafka", Level.PROFESSIONAL));
    dontCareProject.add(new Skill("Git", Level.EXPERT));

    projectPool = new ProjectPool();
    projectPool.add(perfectMatchProject);
    projectPool.add(importantProject);
    projectPool.add(dontCareProject);
  }

  @Test
  void perfectMatchingProject() {
    assertEquals(matchingApplication.match(people, perfectMatchProject), Weight.MustMatch);
  }

  @Test
  void importantMatchingProject() {
    assertEquals(matchingApplication.match(people, importantProject), Weight.Important);
  }

  @Test
  void dontCareMatchingProject() {
    assertEquals(matchingApplication.match(people, dontCareProject), Weight.DontCare);
  }

  @Test
  void recommendMatchingProject() {
    assertEquals(matchingApplication.recommend(people, projectPool),
        Arrays.asList(perfectMatchProject));
  }

}
