/**
 * 
 */
package com.github.mlaursen.mybrews.entity.recipe;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
  
}
