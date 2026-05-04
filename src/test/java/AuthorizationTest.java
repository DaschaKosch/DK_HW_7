
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class AuthorizationTest {

    @ParameterizedTest (name = "Логин: {0} | Результат: {2}")
    @Tag("SMOKE")
    @CsvSource(value = {
            "admin, 'Tr7$mK9pL2@xQw5', /profile",
            "invalidUserName, 123456, Invalid username or password!",
            "admin, wrongPass, Invalid username or password!"
    })
    void loginWithDifferentCredentials(
            String username,
            String password,
            String expectedResult) {


        open("https://demoqa.com/login");
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
        $("#userName").shouldBe(visible);
        $("#userName").setValue(username);
        $("#password").setValue(password);
        $("#login").click();
        if ("/profile".equals(expectedResult)) {
            webdriver().shouldHave(urlContaining("/profile"));
            $("body").shouldHave(text("Profile"));
        } else {
            $$("#output, .alert, .text-danger").find(visible)
                    .shouldHave(text(expectedResult));
            webdriver().shouldNotHave(urlContaining("/profile"));
        }


        System.out.println("✅ Тест: " + username + " → " + expectedResult);
    }
}




