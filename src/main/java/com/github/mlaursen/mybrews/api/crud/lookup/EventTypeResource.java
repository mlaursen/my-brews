package com.github.mlaursen.mybrews.api.crud.lookup;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.entity.lookup.EventType;

@Path("/eventtypes")
@Stateless
public class EventTypeResource extends GenericCRUDResource<EventType> {

  public EventTypeResource() {
    super(EventType.class);
  }
}
