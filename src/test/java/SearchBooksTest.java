import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchBooksTest {

    @ParameterizedTest(name = "Поисковый запрос книг: {0}")
    @Tag("SMOKE")
    @ValueSource(strings = {"Design Patterns", "Git Pocket Guide", "Speaking JavaScript", "You Don't Know JS"})
    void searchBooksByKeyword(String searchQuery) {
        open("https://demoqa.com/books");
        $("#searchBox").setValue(searchQuery).pressEnter();
        $("body").shouldHave(text(searchQuery));
    }
}

