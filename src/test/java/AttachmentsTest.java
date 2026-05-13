import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest {
    private static final String REPOSITORY = "DaschaKosch/DK_HW_3";
    private static final int ISSUE_NAME = 2;

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("button.header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY);
            $("#query-builder-test").submit();});
        step("Кликаем по ссылке репозитория" + REPOSITORY,() -> {
            $(linkText("DaschaKosch/DK_HW_3")).click();});
        step("Открываем таб Issues", () -> {
            $("[data-content='Issues']").shouldBe(Condition.visible).click();
        });
        step("Проверяем наличие Issue с номером" + ISSUE_NAME,() -> {
            $(withText("#" + ISSUE_NAME)).should(Condition.exist);
        });

    }

   @Test
    public  void testAnnotatedAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NAME);

    }
}
