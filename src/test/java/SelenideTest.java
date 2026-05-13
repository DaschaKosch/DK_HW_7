import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $("button.header-search-button").click();
        $("#query-builder-test").setValue("DaschaKosch/DK_HW_3");
        $("#query-builder-test").submit();

        $(linkText("DaschaKosch/DK_HW_3")).click();
        $("[data-content='Issues']").shouldBe(Condition.visible).click();
        $(withText("Issue for autotest 1")).should(Condition.exist);

    }
}
