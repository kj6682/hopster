package org.kj6682.hop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;


public class RestControllerTest {

    private static final Logger logger =
            LoggerFactory.getLogger(RestControllerTest.class);

    @Mock
    HopService hopService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void teardown() {

    }

    @Test
    public void findById_OK() {

        when(hopService.findById(anyString())).thenReturn(getHop());
        HopRestController controller = new HopRestController(hopService);

        assertNotNull(controller.findById("id"));
        logger.info("findById_OK");
    }

    @Test
    public void findById_NO_RESULTS() {

        when(hopService.findById(anyString())).thenReturn(null);
        HopRestController controller = new HopRestController(hopService);

        assertNull(controller.findById("id"));
        logger.info("findById_NO_RESULTS");

    }

    @Test
    public void find_OK() {

        when(hopService.find("search4me")).thenReturn(listHops());
        when(hopService.findAll()).thenReturn(listHops());

        HopRestController controller = new HopRestController(hopService);

        assertNotNull(controller.find(""));
        verify(hopService, only()).findAll();
        verify(hopService, never()).find(anyString());

        logger.info("find_OK");
    }

    @Test
    public void find_search4me_OK() {

        when(hopService.find("search4me")).thenReturn(listHops());
        when(hopService.findAll()).thenReturn(listHops());

        HopRestController controller = new HopRestController(hopService);

        assertNotNull(controller.find("search4me"));
        verify(hopService, only()).find(anyString());
        verify(hopService, never()).findAll();

        logger.info("find_search4me_OK");
    }


    @Test
    public void insert(){
        HopRestController controller = new HopRestController(hopService);

        controller.create("title", "author", "book", "nowhere");
        verify(hopService, only()).insertOne(anyString(), anyString(), anyString(), anyString());
        logger.info("insert_OK");

    }

    @Test
    public void update(){
        HopRestController controller = new HopRestController(hopService);

        controller.update("id", "title", "author", "book", "nowhere");
        verify(hopService, only()).replaceOne(anyString(), anyString(), anyString(), anyString(), anyString());
        logger.info("update_OK");

    }

    @Test
    public void delete(){
        HopRestController controller = new HopRestController(hopService);

        controller.delete("id");
        verify(hopService, only()).delete(anyString());
        logger.info("delete_OK");

    }

    private List<Hop>  listHops(){
        List<Hop> hops = new LinkedList<>();
        for(int i = 0; i <10; i++){
            hops.add(getHop());
        }
        return hops;
    }
    private Hop getHop() {
        Hop hop = new Hop();
        hop.setTitle("title");
        hop.setAuthor("author");
        hop.setType("type");
        hop.setLocation("location");
        return hop;
    }


}
