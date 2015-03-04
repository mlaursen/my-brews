/**
 * 
 */
package com.github.mlaursen.mybrews.entity.beer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.GeneratedIdEntity;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class Recipe extends GeneratedIdEntity {
  @OneToOne
  @JoinColumn
  private Yeast yeast;
  
  @OneToMany
  @JoinColumn
  private List<RecipePart> recipeParts;

  /**
   * @return the yeast
   */
  public Yeast getYeast() {
    return yeast;
  }

  /**
   * @param yeast
   *          the yeast to set
   */
  public void setYeast(Yeast yeast) {
    this.yeast = yeast;
  }

  /**
   * @return the recipeParts
   */
  public List<RecipePart> getRecipeParts() {
    return recipeParts;
  }

  /**
   * @param recipeParts the recipeParts to set
   */
  public void setRecipeParts(List<RecipePart> recipeParts) {
    this.recipeParts = recipeParts;
  }
}
