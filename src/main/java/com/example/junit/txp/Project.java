package com.example.junit.txp;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Project {
  private String name;
  private List<Skill> requiredSkill= new ArrayList<>();

  public Project (String name ){
    this.name = name;
  }

  public void add(Skill skill){
    requiredSkill.add(skill);
  }
}
