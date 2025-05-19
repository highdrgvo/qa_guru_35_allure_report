import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

 public class PureSelenideWithListenerTest {

     @Test
     public void searchIssueTabTest() {

         SelenideLogger.addListener("allure", new AllureSelenide());

         open("https://github.com/");
         $("div.search-input-container").click();
         $("#query-builder-test").setValue("qa_guru_35_allure_report").pressEnter();
         $("[href='/highdrgvo/qa_guru_35_allure_report']").click();
         $("#issues-tab").should(exist);
     }
 }
