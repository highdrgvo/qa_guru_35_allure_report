import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LabelsTest {

    @Test
    @Feature("Issue in a repository")
    @Story("Creating an issue")
    @Owner("plechkos")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub testing", url = "https://github.com/")
    @DisplayName("Creating Issue for authorized user")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Creating Issue for authorized user"));

        Allure.feature("Issue in a repository");
        Allure.story("Creating an issue");
        Allure.label("owner", "plechkos");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("GitHub testing", "https://github.com/");
    }
}

