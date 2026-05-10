package models;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class Cat {
    @SerializedName("id")
    public String id;

    @SerializedName("name" )
    public String name;

    @SerializedName("breed")
    public String breed;

    @SerializedName("age")
    public Age age;

    @SerializedName("color")
    public Color color;

    @SerializedName("weight")
    public Weight weight;

    @SerializedName("character")
    public Character character;

    @SerializedName("preferences")
    public Preferences preferences;

    @SerializedName("achievements")
    public List<Achievement> achievements;

    @SerializedName("metadata")
    public Metadata metadata;

    public static class Age {
        @SerializedName("years") public int years;
        @SerializedName("months") public int months;
    }
    public static class Color {
        @SerializedName("primary") public String primary;
        @SerializedName("secondary") public String secondary;
    }
    public static class Weight {
        @SerializedName("kg") public double kg;
        @SerializedName("lastMeasured") public String lastMeasured;
    }
    public static class Character {
        @SerializedName("temperament") public List<String> temperament;
        @SerializedName("energyLevel") public String energyLevel;
        @SerializedName("affectionLevel") public int affectionLevel;
        @SerializedName("childFriendly") public boolean childFriendly;
        @SerializedName("dogFriendly") public boolean dogFriendly;
        @SerializedName("strangerFriendly") public String strangerFriendly;
    }
    public static class Preferences {
        @SerializedName("favoriteFood") public List<String> favoriteFood;
        @SerializedName("favoriteToys") public List<String> favoriteToys;
        @SerializedName("sleepingSpots") public List<String> sleepingSpots;
        @SerializedName("dislikes") public List<String> dislikes;
    }
    public static class Achievement {
        @SerializedName("title") public String title;
        @SerializedName("description") public String description;
        @SerializedName("unlockedAt") public String unlockedAt;
    }

    public static class Metadata {
        @SerializedName("createdAt") public String createdAt;
        @SerializedName("updatedAt") public String updatedAt;
        @SerializedName("source") public String source;
        @SerializedName("verified") public boolean verified;
    }

}

