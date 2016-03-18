package com.betomorow.codingdojos.exercices;

public enum MedalId {
    MATCH_LETTERS("id1"),
    MATCH_NUMBERS("id2"),
    MATCH_SIMPLE_WORDS("id3"),
    MATCH_DOUBLE_LETTER_OCCURENCE("id4"),
    MATCH_WITHOUT_LETTER("id5"),
    MATCH_DOESNT_CONTAIN_WORD("id6"),
    MATCH_WORD_NOT_FOLLOWED("id7"),
    MATCH_ASTRONAUT("id8");

    private String value;

    MedalId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
