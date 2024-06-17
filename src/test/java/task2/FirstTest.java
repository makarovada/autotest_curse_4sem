package task2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class FirstTest extends BaseTests {
    private static final Logger logger = LogManager.getLogger(task1.FirstTest.class);
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
    public void test() {
        pageManager.getFirstPage2()
                .clickOnSchedule()
                .clickOnLookOnWeb()
                .selectGroup();


    }
}



