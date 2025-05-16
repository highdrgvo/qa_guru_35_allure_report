import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    @Test
    public void testLambdaAttachments() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        // Лямбда степ - это название подхода. Почитать про лямбда функцию.
        step("Open the home page", () -> {
            open("https://github.com/");
            attachment("Source", webdriver().driver().source());
        });
        step("Looking for a repository", () -> {
            $("div.search-input-container").click();
            $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();
        });
        step("Click to repository", () -> {
            $("[href='/eroshenkoam/allure-example']").click();
        });
        step("Check that Code button is on the page", () -> {
            $("#code-tab").shouldBe(visible);
        });

    }

    @Test
    public void testAnnotatedStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        WebStepsTest steps = new WebStepsTest();

        steps.openMainPage();
        steps.takeScreenshot();
    }
}