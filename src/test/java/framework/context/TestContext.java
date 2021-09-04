package framework.context;

import framework.utils.DriverManager;

public class TestContext {
    protected DriverManager driverManager;

    public TestContext(){
        driverManager = new DriverManager();
    }

    public DriverManager getWebDriverManager(){
        return driverManager;
    }
}
