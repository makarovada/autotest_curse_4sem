package task2;

import org.junit.Test;

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


/*
1.	Перейти по ссылке: https://mospolytech.ru/
        2. Нажать на кнопку Расписания
3. В разделе “Расписания занятий” нажать “Смотрите на сайте”
        4. Ввести номер группы в поле поиска
5. Нажать на найденную группу в результатах поиска

 */
