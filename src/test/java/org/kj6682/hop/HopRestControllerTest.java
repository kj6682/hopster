package org.kj6682.hop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;


public class HopRestControllerTest {

    private static final Logger logger =
            LoggerFactory.getLogger(HopRestControllerTest.class);
    @Mock HopService hopService;


    @Before public void setup(){
        logger.info(">>> setup");
    }
    @After public void teardowun(){
        logger.info("<<< shutdown");
    }

    @Test public void test(){
        logger.info("test test test");
    }


}
