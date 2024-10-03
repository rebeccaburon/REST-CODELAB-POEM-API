package dat.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {
    HAIKO, LIMERICK, SENRYU,TANKA, SONNET, VILLANELLE,
    ACROSTIC, ELEGY, ODE, GHAZAL, SESTINA, PANTOUM,
    TERZA_RIMA, TRIOLET, RONDEL, RONDEAU, BALLAD, EPIC, FREE_VERSE,LYRIC,
    NARRATIVE, PROSE, RHYMEDVERSE,BLANK,VERSE, CONCRETE, FOUND, LIGTH, VISUAL;


    @JsonCreator
    public static Type changeString (String value){
        return Type.valueOf(value.toUpperCase());
    }
}
