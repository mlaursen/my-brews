package com.github.mlaursen.mybrews.api;

import java.util.Arrays;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.mlaursen.mybrews.entity.beer.Beer;
import com.github.mlaursen.mybrews.entity.lookup.BeerColor;
import com.github.mlaursen.mybrews.entity.lookup.BeerStyle;
import com.github.mlaursen.mybrews.entity.lookup.RegionalStyle;

/**
 * Abstract class for testing a Generic CRUD Resource. Since all the GenericCRUDResources
 * use an injected entity manager, this class takes in the generic CRUD Resource and injects
 * a mocked EntityManager. To get specific results for testing, implement the {@link #initializeMocking()}
 * method with the specific expected results.
 * 
 * @author mlaursen
 *
 * @param <R> The GenericCRUDResource to test
 */
public abstract class AbstractGenericCRUDResourceUTest<R> {
  
  @InjectMocks
  protected R resource;
  @Mock
  protected EntityManager em;
  
  public AbstractGenericCRUDResourceUTest(R resource) {
    this.resource = resource;
  }
  
  protected Dispatcher dispatcher;
  
  public abstract void initializeMocking() throws Exception;
  
  @Before
  public void setUpMocking() throws Exception {
    MockitoAnnotations.initMocks(this);
    
    dispatcher = MockDispatcherFactory.createDispatcher();
    dispatcher.getRegistry().addSingletonResource(resource);
    
    initializeCommonMocks();
    initializeMocking();
  }
  
  public void initializeCommonMocks() {
  }
}
