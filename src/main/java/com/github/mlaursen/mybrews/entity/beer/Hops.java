/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class Hops extends AbstractRecipePart {

  private Integer boilTime;

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
