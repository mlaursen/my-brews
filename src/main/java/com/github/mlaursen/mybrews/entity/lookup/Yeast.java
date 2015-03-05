/**
 * 
 */
package com.github.mlaursen.mybrews.entity.lookup;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.constants.YeastType;
import com.github.mlaursen.mybrews.entity.GeneratedIdNamedEntity;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class Yeast extends GeneratedIdNamedEntity {
  
  @Enumerated(EnumType.STRING)
  private YeastType type;

  /**
   * @return the type
   */
  public YeastType getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(YeastType type) {
    this.type = type;
  }
  
}
