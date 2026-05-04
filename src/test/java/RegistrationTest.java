import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    @ParameterizedTest(name = "Text Box: {0} | {1}")
    @Tag("SMOKE")
    @MethodSource("provideFormData")
    void submitTextBoxForm(
            String userName,
            String email,
            String currentAddress,
            String permanentAddress) {

        open("https://demoqa.com/text-box");
        $("#userName").shouldBe(visible);
        $("#userName").setValue(userName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").scrollTo().click();
        $("#output").shouldBe(visible);
        $("#output").shouldHave(text(userName));
        $("#output").shouldHave(text(email));
        $("#output").shouldHave(text(currentAddress));
        $("#output").shouldHave(text(permanentAddress));

        System.out.println("✅ Text Box: " + userName + " → данные сохранены");
    }

    static Stream<Arguments> provideFormData() {
        return Stream.of(
                Arguments.of(
                        "Alex Black",
                        "alex@test.com",
                        "123 Main St, New York",
                        "456 Oak Ave, Boston"
                ),
                Arguments.of(
                        "Иван Петров",
                        "ivan@example.ru",
                        "ул. Ленина, д. 10, Москва",
                        "пр. Мира, д. 25, Санкт-Петербург"
                ),
                Arguments.of(
                        "Maria Garcia Lopez Rodriguez",
                        "maria.garcia@very-long-domain-name.example.com",
                        "Avenida de la Constitución, número 123, piso 4, puerta B, Sevilla, España",
                        "Calle del Comercio, edificio central, oficina 301, Madrid, España"
                )
        );
    }
}