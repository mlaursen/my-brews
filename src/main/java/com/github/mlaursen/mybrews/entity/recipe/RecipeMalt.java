/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.lookup.Malt;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class RecipeMalt extends RecipeBoilTimePart {
  
  @OneToOne
  @JoinColumn(name = "malt_id")
  private Malt malt;

  /**
   * @return the malt
   */
  public Malt getMalt() {
    return malt;
  }

  /**
   * @param malt the malt to set
   */
  public void setMalt(Malt malt) {
    this.malt = malt;
  }

}
