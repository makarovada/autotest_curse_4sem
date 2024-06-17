package task4;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class FirstTest extends BaseTests {
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
    public void test1() {
        pageManager.getFirstPage4()
                .moveToRatings()
                .moveToRatingsScore()
                .assertFilter();


    }

    @Test
    public void test2() {
        pageManager.getFirstPage4()
                .moveToSchoolClass9()
                .filterOge()
                .filterPrice()
                .clickSubmitButton();


    }

    @Test
    public void test3() {
        ;pageManager.getFirstPage4()
                .moveToReviews()
                .selectSortByAuthor()
                .inputAuthor()
                .sortByAuthor();


    }
}

