 import com.codeborne.selenide.logevents.SelenideLogger;
 import io.qameta.allure.selenide.AllureSelenide;
 import org.junit.jupiter.api.Test;

 import static com.codeborne.selenide.Condition.*;
 import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test
    public void testIssueSearch() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $("div.search-input-container").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").pressEnter();
        $("[href='/eroshenkoam/allure-example']").click();
        $("#code-tab").shouldBe(visible);
    }
}
