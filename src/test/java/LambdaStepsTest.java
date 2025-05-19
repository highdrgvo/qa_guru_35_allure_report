import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest {

    @Test
    public void searchIssueTabLambdaStepsTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main github page", () -> {
            open("https://github.com/");
        });
        step("Looking for a repository", () -> {
            $("div.search-input-container").click();
            $("#query-builder-test").setValue("qa_guru_35_allure_report").pressEnter();
        });
        step("Click to repository", () -> {
            $("[href='/highdrgvo/qa_guru_35_allure_report']").click();
        });
        step("Check that Issue tab is on the page", () -> {
            $("#issues-tab").should(exist);
        });
    }
}