package com.example.junit.txp;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class People {
  private String name;
  private List<Skill> hasSkills = new ArrayList<>();

  public People(String name){
    this.name = name;
  }

  public void add(Skill skill){
    hasSkills.add(skill);
  }

}