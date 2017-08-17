/*
 * Copyright (c) 2017. Experitest
 *
 */

package frameword;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.net.MalformedURLException;

/**
 * Created by tom.ben-simhon on 12/26/2016.
 * Test Base Class holds all members required to run a test, and details general capabilities
 */

public class TestBase {


    @BeforeTest
    public void setUpTest(final ITestContext context) throws MalformedURLException {
        ChromeDriverManager.getInstance().setup();
    }

    @AfterTest

    public void tearDown(final ITestContext context) throws MalformedURLException {

    }
}

