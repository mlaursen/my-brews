/**
 * 
 */
package com.github.mlaursen.mybrews.entity.lookup;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.entity.GeneratedIdNamedEntity;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class EventType extends GeneratedIdNamedEntity {
  
  private String color;

  /**
   * @return the color
   */
  public String getColor() {
    return color;
  }

  /**
   * @param color the color to set
   */
  public void setColor(String color) {
    this.color = color;
  }
  
  
}
