package ru.appline.framework.managers;

import ru.appline.utils.PropConst;

import java.util.concurrent.TimeUnit;

import static ru.appline.utils.PropConst.PAGE_LOAD_TIMEOUT;


public class InitManager {
    private static final TestPropManager props = TestPropManager.getInstance();
    private static final DriverManager driverManager = DriverManager.getInstance();
    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(PropConst.IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }
    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
