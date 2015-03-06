/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;
import com.github.mlaursen.mybrews.entity.lookup.Yeast;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class Recipe extends GeneratedIdEntity {
  
  @OneToOne
  @JoinColumn(name = "yeast_id")
  private Yeast yeast;
  
  @OneToMany
  @JoinColumn(name = "id")
  private List<RecipeMalt> malts;
  
  @OneToMany
  @JoinColumn(name = "id")
  private List<RecipeGrain> grains;
  
  @OneToMany
  @JoinColumn(name = "id")
  private List<RecipeHops> hops;
  
  private Integer boilTime;

  /**
   * @return the yeast
   */
  public Yeast getYeast() {
    return yeast;
  }

  /**
   * @param yeast the yeast to set
   */
  public void setYeast(Yeast yeast) {
    this.yeast = yeast;
  }

  /**
   * @return the boilTime
   */
  public Integer getBoilTime() {
    return boilTime;
  }

  /**
   * @param boilTime the boilTime to set
   */
  public void setBoilTime(Integer boilTime) {
    this.boilTime = boilTime;
  }

  /**
   * @return the malts
   */
  public List<RecipeMalt> getMalts() {
    return malts;
  }

  /**
   * @param malts the malts to set
   */
  public void setMalts(List<RecipeMalt> malts) {
    this.malts = malts;
  }

  /**
   * @return the grains
   */
  public List<RecipeGrain> getGrains() {
    return grains;
  }

  /**
   * @param grains the grains to set
   */
  public void setGrains(List<RecipeGrain> grains) {
    this.grains = grains;
  }

  /**
   * @return the hops
   */
  public List<RecipeHops> getHops() {
    return hops;
  }

  /**
   * @param hops the hops to set
   */
  public void setHops(List<RecipeHops> hops) {
    this.hops = hops;
  }
  
}
