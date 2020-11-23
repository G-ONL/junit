package com.example.junit.four;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import com.example.junit.txp.Level;
import com.example.junit.txp.MatchingApplication;
import com.example.junit.txp.People;
import com.example.junit.txp.Project;
import com.example.junit.txp.ProjectPool;
import com.example.junit.txp.Skill;

import com.example.junit.txp.Weight;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class matchingTest {

  private People people;
  private Project perfectMatchProject;
  private Project importantProject;
  private Project dontCareProject;
  private ProjectPool projectPool;

  MatchingApplication matchingApplication = new MatchingApplication();

  // MustMatch(5),
  //  Important(2),
  //  DontCare(0);

  @Before
  public void init(){
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
  public void perfectMatchingProject(){
    assertThat(matchingApplication.match(people, perfectMatchProject), equalTo(Weight.MustMatch));
  }

  @Test
  public void importantMatchingProject(){
    assertThat(matchingApplication.match(people, importantProject), equalTo(Weight.Important));
  }

  @Test
  public void dontCareMatchingProject(){
    assertThat(matchingApplication.match(people, dontCareProject), equalTo(Weight.DontCare));
  }

  @Test
  public void recommendMatchingProject(){
    assertThat(matchingApplication.recommend(people, projectPool), equalTo(Arrays.asList(perfectMatchProject)));
  }

}
