package task2;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.appline.framework.managers.DriverManager;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PageManager;



public class BaseTests {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    // private static final Logger logger = LogManager.getLogger(BaseTests.class);

    @BeforeClass
    public static void beforeClass() {
        InitManager.initFramework();
        //logger.info("Тест начат");
    }

    @Before
    public void setUp() {
        driverManager.getDriver();
        //logger.info("Driver initialized");
    }

    @After
    public void tearDown() {
        InitManager.quitFramework();
        //logger.info("Framework quit");
    }
    /*
    protected void takeScreenshot(String testName) {
        File scrFile = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            FileHandler.copy(scrFile, new File("src/test/screenshots/" + testName + "_" + timestamp + ".png"));
            logger.info("Скриншот сохранён: " + testName + "_" + timestamp + ".png");
        } catch (IOException e) {
            logger.error("Ошибка при сохранении скриншота: " + e.getMessage());
        }
    }

     */

}
