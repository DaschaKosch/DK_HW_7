import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "DaschaKosch/DK_HW_3";
    private static final int ISSUE_NAME = 2;


    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("DaschaKosch")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.githab.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
        public void testLambdaStep() {
            SelenideLogger.addListener("allure", new AllureSelenide());

           step("Открываем главную страницу", () -> {
               open("https://github.com");
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
        @Feature("Issue в репозитории")
        @Story("Создание Issue")
        @Owner("DaschaKosch")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Testing", url = "https://testing.githab.com")
        @DisplayName("Создание Issue для авторизованного пользователя способ 2")
    public  void testAnnotatedStep() {
            SelenideLogger.addListener("allure", new AllureSelenide());
            WebSteps steps = new WebSteps();

            steps.openMainPage();
            steps.searchForRepository(REPOSITORY);
            steps.clickOnRepositoryLink(REPOSITORY);
            steps.openIssuesTab();
            steps.shouldSeeIssueWithNumber(ISSUE_NAME);

        }
    }


