package com.github.mlaursen.mybrews.api.crud.event;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.time.DateUtils;

import com.github.mlaursen.mybrews.api.crud.GenericCRUDResource;
import com.github.mlaursen.mybrews.api.crud.beer.BeerResource;
import com.github.mlaursen.mybrews.api.crud.lookup.EventTypeResource;
import com.github.mlaursen.mybrews.api.crud.lookup.GrainResource;
import com.github.mlaursen.mybrews.api.crud.lookup.HopsResource;
import com.github.mlaursen.mybrews.api.crud.lookup.YeastResource;
import com.github.mlaursen.mybrews.entity.beer.BrewedBeer;
import com.github.mlaursen.mybrews.entity.beer.Event;
import com.github.mlaursen.mybrews.entity.lookup.EventType;
import com.github.mlaursen.mybrews.entity.recipe.Recipe;
import com.github.mlaursen.mybrews.entity.recipe.RecipeGrain;
import com.github.mlaursen.mybrews.entity.recipe.RecipeHops;

@Path("/events")
@Stateless
public class EventResource extends GenericCRUDResource<Event> {
  @Inject
  private YeastResource yeastResource;
  @Inject
  private HopsResource hopsResource;
  @Inject
  private GrainResource grainResource;
  @Inject
  private BeerResource beerResource;
  @Inject
  private EventTypeResource eventTypeResource;
  

  public EventResource() {
    super(Event.class);
  }

  @GET
  @Path("/{year}/{month}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Event> retrieveEvents(@PathParam("year") Integer year, @PathParam("month") Integer month) {
    List<Event> events = new ArrayList<>();
    
    if(month == 2) {
      Date march = DateUtils.setMonths(new Date(), 2);
      Date march14 = DateUtils.setDays(march, 14);
      Date march28 = DateUtils.setDays(march, 28);
      
      Event brew = new Event();
      brew.setId(1L);
      brew.setEventDate(march14);
      brew.setEventType(eventTypeResource.findById(1L));
      
      BrewedBeer truHefe = new BrewedBeer();
      truHefe.setId(1L);
//      truHefe.setOg(1.045);
//      
//      Recipe truHefeRecipe = new Recipe();
//      truHefeRecipe.setId(1L);
//      truHefeRecipe.setYeast(yeastResource.findById(1L));
//      truHefeRecipe.setHops(hopsResource.retrieveAll().stream().map(h -> new RecipeHops(h, 60)).collect(Collectors.toList()));
//      truHefeRecipe.setGrains(grainResource.retrieveAll().stream().map(g -> new RecipeGrain(g, 5.5)).collect(Collectors.toList()));
//      
//      truHefe.setRecipe(truHefeRecipe);
      truHefe.setBeer(beerResource.findById(5L));
      
      brew.setBrewedBeer(truHefe);
      
      Event moveToSecondary = new Event();
      moveToSecondary.setId(2L);
      moveToSecondary.setEventDate(march28);
      moveToSecondary.setEventType(eventTypeResource.findById(2L));
      
//      truHefe.setFg(1.010);
//      
      moveToSecondary.setBrewedBeer(truHefe);
      
      
      events.add(brew);
      events.add(moveToSecondary);
    }
    
    return events;
  }
}
