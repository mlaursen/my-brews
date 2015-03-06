/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.lookup.Hops;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class RecipeHops extends RecipePart {
  
  @OneToOne
  @JoinColumn(name = "hops_id")
  private Hops hops;
  
  private Integer boilTime;

  /**
   * @return the malt
   */
  public Hops getHops() {
    return hops;
  }

  /**
   * @param hops the hops to set
   */
  public void setHops(Hops hops) {
    this.hops = hops;
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
}
