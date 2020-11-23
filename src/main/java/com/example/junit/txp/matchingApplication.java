package com.example.junit.txp;

import java.util.ArrayList;
import java.util.List;

public class matchingApplication {

  public List<Project> recommend(People people , ProjectPool projectPool){
    List<Project> recommendProjectList = new ArrayList<>();
    Weight max = Weight.DontCare;
    for(Project project : projectPool.getProjectList()){
      Weight matchingResult = match(people, project);
      if(max.getValue() < matchingResult.getValue()){
        max = matchingResult;
        recommendProjectList = new ArrayList<>();
        recommendProjectList.add(project);
      }else if(max != Weight.DontCare && (max.getValue() == matchingResult.getValue())){
        recommendProjectList.add(project);
      }
    }
    return recommendProjectList;
  }

  public Weight match(People people, Project project){
    int matchCount = 0;
    int check;

    for( Skill requireSkill : project.getRequiredSkill()){
      for( Skill hasSkill : people.getHasSkills()){
         if(requireSkill.getName().equals(hasSkill.getName())){
           matchCount++;
           check = Math.abs(hasSkill.getLevel().getValue() - requireSkill.getLevel().getValue());
           if( check > 2){
             matchCount--;
           }
         }
      }
    }
    int matchingScore = (matchCount * 10) / (project.getRequiredSkill().size() * 2);
    Weight matching = Weight.DontCare;

    for(Weight weight : Weight.values()){
      if(weight.getValue() == matchingScore){
        matching = weight;
      }
    }

    return matching;
  }

}
