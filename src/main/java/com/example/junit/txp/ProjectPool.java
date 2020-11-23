package com.example.junit.txp;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ProjectPool {
  private List<Project> projectList = new ArrayList<>();

  public void add(Project project){
    projectList.add(project);
  }
}
