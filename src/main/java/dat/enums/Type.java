package dat.enums;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {
    HAIKU, LIMERICK, SENRYU, TANKA, SONNET, VILLANELLE,
    ACROSTIC, ELEGY, ODE, GHAZAL, SESTINA, PANTOUM, TERZA_RIMA,
    TRIOLET, RONDEL, RONDEAU, BALLAD, EPIC, FREE_VERSE, LYRIC, NARRATIVE,
    PROSE, RHYMED_VERSE,BLANK,VERSE, CONCRETE, FOUND, LIGTH, VISUAL;

    @JsonCreator
    public static Type fromString(String value) {
        return Type.valueOf(value.toUpperCase());  // Convert the input to uppercase and match with the enum
    }
}
