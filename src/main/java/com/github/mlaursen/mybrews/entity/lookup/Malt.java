/**
 * 
 */
package com.github.mlaursen.mybrews.entity.lookup;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.mlaursen.mybrews.constants.MaltType;
import com.github.mlaursen.mybrews.entity.GeneratedIdNamedEntity;

/**
 *
 * @author mlaursen
 *
 */
@Entity
@XmlRootElement
public class Malt extends GeneratedIdNamedEntity {
  
  @Enumerated(EnumType.STRING)
  private MaltType type;

  /**
   * @return the type
   */
  public MaltType getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(MaltType type) {
    this.type = type;
  }
}
