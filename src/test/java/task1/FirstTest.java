package task1;

import org.junit.*;

import java.util.logging.Logger;





public class FirstTest extends BaseTests {
    //private static final Logger logger = LogManager.getLogger(FirstTest.class);
    //@Rule
    //public TestName testName = new TestName();


    @Test
    public void test() {
        pageManager.getFirstPage().getUpText()
                .getSpanClass(0)
                .isCheckboxSelected(0)
                .clickCheckbox(0)
                .clickAllCheckboxes()
                .addNewElement();
    }
}

