import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class WebStepsTest {

    @Test
    public void testIssueSearch() {

    }

    @Step("Open the home page")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Looking for a repository")
    public void searchForRepository() {
        $("div.search-input-container").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();
    }

    @Step("Click to repository")
    public void clickOnRepositoryLink() {
        $("[href='/eroshenkoam/allure-example']").click();
    }

    @Step("Check that Code button is on the page")
    public void checkCodeButton() {
        $("#code-tab").shouldBe(visible);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
//        SelenideLogger.addListener("allure", new AllureSelenide());
//
//        open("https://github.com/");
//        $("div.search-input-container").click();
//        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();
//        $("[href='/eroshenkoam/allure-example']").click();
//        $("#code-tab").shouldBe(visible);

