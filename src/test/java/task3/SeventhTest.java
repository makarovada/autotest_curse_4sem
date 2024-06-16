package task3;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import task1.FirstTest;

public class SeventhTest extends BaseTests{
    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            takeScreenshot(testName.getMethodName());
        }
    };
    @Test
    public void test() throws InterruptedException {
        pageManager.getFirstPage3()
                .clickOnLaptops()
                .infoToLogs()
                .selectResale();


    }
}
