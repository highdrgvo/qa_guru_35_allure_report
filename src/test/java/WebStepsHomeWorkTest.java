import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsHomeWorkTest {

    @Test
    public void testIssueSearch() {

    }

    @Step("Open the main github page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Looking for a repository")
    public void lookingForRepository() {
        $("div.search-input-container").click();
        $("#query-builder-test").setValue("qa_guru_35_allure_report").pressEnter();
    }

    @Step("Click to repository")
    public void clickOnRepositoryLink() {
        $("[href='/highdrgvo/qa_guru_35_allure_report']").click();
    }

    @Step("Check that Issues tab is on the page")
    public void checkIssuesTab() {
        $("#issues-tab").should(exist);
    }
}

