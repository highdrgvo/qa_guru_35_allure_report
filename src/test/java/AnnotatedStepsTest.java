import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest {

    @Test
    public void searchIssueTabAnnotatedStepsTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        WebStepsHomeWorkTest steps = new WebStepsHomeWorkTest();

        steps.openMainPage();
        steps.lookingForRepository();
        steps.clickOnRepositoryLink();
        steps.checkIssuesTab();
    }
}