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
public class RecipeHops extends RecipeBoilTimePart {
  
  @OneToOne
  @JoinColumn(name = "hops_id")
  private Hops hops;

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
}
