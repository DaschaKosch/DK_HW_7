import com.google.gson.Gson;
import models.Cat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

public class JsonParsingTest {
    private static final Gson gson = new Gson();
    private final ClassLoader cl = JsonParsingTest.class.getClassLoader();

    @Test
    void jsonFileParsingImprovedTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                Objects.requireNonNull(cl.getResourceAsStream("сat.json"))
        )) {
            Cat actual = gson.fromJson(reader, Cat.class);


            Assertions.assertEquals("cat_001", actual.id);
            Assertions.assertEquals("Муся", actual.name);
            Assertions.assertEquals("Русская голубая", actual.breed);
            Assertions.assertEquals(1, actual.age.years);
            Assertions.assertEquals(7, actual.age.months);
            Assertions.assertEquals("серый", actual.color.primary);
            Assertions.assertEquals("белый", actual.color.secondary);
            Assertions.assertEquals(5.2, actual.weight.kg);
            Assertions.assertEquals("2026-05-01", actual.weight.lastMeasured);
            Assertions.assertEquals(3, actual.character.temperament.size());
            Assertions.assertEquals("дружелюбный", actual.character.temperament.get(0));
            Assertions.assertEquals("игривый", actual.character.temperament.get(1));
            Assertions.assertEquals("независимый", actual.character.temperament.get(2));
            Assertions.assertEquals("MEDIUM", actual.character.energyLevel);
            Assertions.assertEquals(8, actual.character.affectionLevel);
            Assertions.assertTrue(actual.character.childFriendly);
            Assertions.assertFalse(actual.character.dogFriendly);
            Assertions.assertEquals("CAUTIOUS", actual.character.strangerFriendly);
            Assertions.assertEquals(2, actual.preferences.favoriteFood.size());
            Assertions.assertEquals("влажный корм с курицей", actual.preferences.favoriteFood.get(0));
            Assertions.assertEquals(3, actual.preferences.favoriteToys.size());
            Assertions.assertEquals("картонная коробка", actual.preferences.favoriteToys.get(2));
            Assertions.assertEquals(3, actual.preferences.dislikes.size());
            Assertions.assertEquals("пылесос", actual.preferences.dislikes.get(0));
            Assertions.assertEquals(2, actual.achievements.size());
            Assertions.assertEquals("Мастер прыжков", actual.achievements.get(0).title);
            Assertions.assertEquals("Запрыгивает на шкаф с первого раза", actual.achievements.get(0).description);
            Assertions.assertEquals("2025-08-12", actual.achievements.get(0).unlockedAt);
            Assertions.assertEquals("Охотник на лазер", actual.achievements.get(1).title);
            Assertions.assertEquals("Поймал красную точку (по его мнению)", actual.achievements.get(1).description);
            Assertions.assertEquals("2022-10-05T10:30:00Z", actual.metadata.createdAt);
            Assertions.assertEquals("Домашний питомец", actual.metadata.source);
            Assertions.assertTrue(actual.metadata.verified);
        }
    }
}



