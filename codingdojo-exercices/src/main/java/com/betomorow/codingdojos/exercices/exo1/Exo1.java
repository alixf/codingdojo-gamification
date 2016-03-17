package com.betomorow.codingdojos.exercices.exo1;

public class Exo1 {

    /**
     * Match :
     * "abcdefg"
     * "abcde"
     * "abc"
     *
     * Do not match :
     * "123"
     * "aaa"
     */
    public String matchLetters() {
        return "abc.*";
    }

    /**
     * Match :
     * "abde"
     * "12op"
     *
     * Do not match :
     * "abcde"
     * "Cdb"
     */
    public String matchWithoutLetter() {
        return "[^cC]*";
    }

    /**
     * Match :
     * "123"
     * "35"
     * "67.89"
     *
     * Do not match :
     * "67.89.67"
     * "abc"
     */
    public String matchNumbers() {
        return "\\d+(.\\d+)?";
    }

    /**
     * Match :
     * "a quick brown fox"
     * "Something went wrong"
     * "hello"
     *
     * Do not match :
     * "My idententification is a201"
     * "Something went wrong "
     * "I have 10 pennies"
     * ""
     */
    public String matchWords() {
        return "[a-zA-Z]+( [a-zA-Z]+)*";
    }

    /**
     * Match :
     * "bb"
     * "abdbc"
     * "CdbC"
     *
     * Do not match :
     * "abc"
     * "Cdbc"
     * "11"
     */
    public String matchDoubleLetterOccurence() {
        return ".*([a-zA-Z]).*\\1.*";
    }

    /**
     * Match :
     * "the forbidden word isn't here"
     * "nor here"
     *
     * Do not match :
     * "this is the forbidden word"
     * "can't touch this"
     */
    public String matchDoesntContainWord() {
        return "(?!.*this).*";
    }

    /**
     * Match :
     * "hello can come before this"
     * "hello this is dog"
     * "this is fine"
     *
     * Do not match :
     * "this cannot come before hello"
     */
    public String wordCannotBeFollowedByAnother() {
        return "(?!.*this.*hello).*";
    }

    /**
     * Match :
     * "therefezffzeu space  efghghghireh"
     * "therefezffzeu sPacE  efghghghireh afafa fa fze  "
     * "                  	SPACe   "
     *
     * Do not match :
     * "space gruhreiguh rhigueh g"
     * "grehigeh uzhgireugh eSPACEezgr"
     *
     */
    public String hasSpecialWordSurroundedBySpace() {
        return "(?i).*(?<=\\s)space(?=\\s).*";
    }
}
