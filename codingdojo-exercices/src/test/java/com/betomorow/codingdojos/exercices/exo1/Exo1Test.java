package com.betomorow.codingdojos.exercices.exo1;

import com.betomorow.codingdojos.exercices.MedalId;
import org.junit.Test;

import static com.betomorow.codingdojos.exercices.exo1.GamificationHelper.validateMedal;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class Exo1Test {
    @Test
    public void matchLetters() throws Exception {
        String regex = new Exo1().matchLetters();
        assertTrue("abcdef".matches(regex));
        assertTrue("abcde".matches(regex));
        assertTrue("abc".matches(regex));

        assertFalse("123".matches(regex));
        assertFalse("aaa".matches(regex));

        validateMedal(MedalId.MATCH_LETTERS, true);
    }

    @Test
    public void matchWithoutLetter() throws Exception {
        String regex = new Exo1().matchWithoutLetter();
        assertTrue("abde".matches(regex));
        assertTrue("12op".matches(regex));

        assertFalse("abcde".matches(regex));
        assertFalse("Cdb".matches(regex));

        validateMedal(MedalId.MATCH_WITHOUT_LETTER, true);
    }

    @Test
    public void matchNumbers() throws Exception {
        String regex = new Exo1().matchNumbers();

        assertTrue("123".matches(regex));
        assertTrue("35".matches(regex));
        assertTrue("67.89".matches(regex));

        assertFalse("67.89.67".matches(regex));
        assertFalse("abc".matches(regex));

        validateMedal(MedalId.MATCH_NUMBERS, true);
    }

    @Test
    public void matchWords() throws Exception {
        String regex = new Exo1().matchWords();
        assertTrue("a quick brown fox".matches(regex));
        assertTrue("Something went wrong".matches(regex));
        assertTrue("hello".matches(regex));

        assertFalse("My idententification is a201".matches(regex));
        assertFalse("I have 10 pennies".matches(regex));
        assertFalse("Something went wrong ".matches(regex));
        assertFalse("".matches(regex));

        validateMedal(MedalId.MATCH_SIMPLE_WORDS, true);
    }

    @Test
    public void matchDoubleLetterOccurence() throws Exception {
        String regex = new Exo1().matchDoubleLetterOccurence();
        assertTrue("bb".matches(regex));
        assertTrue("abdbc".matches(regex));

        assertFalse("abc".matches(regex));
        assertFalse("Cdbc".matches(regex));
        assertFalse("11".matches(regex));

        validateMedal(MedalId.MATCH_DOUBLE_LETTER_OCCURENCE, true);
    }

    @Test
    public void matchDoesntContainWord() throws Exception {
        String regex = new Exo1().matchDoesntContainWord();
        assertTrue("the forbidden word isn't here".matches(regex));
        assertTrue("nor here".matches(regex));

        assertFalse("this is the forbidden word".matches(regex));
        assertFalse("can't touch this".matches(regex));

        validateMedal(MedalId.MATCH_DOESNT_CONTAIN_WORD, true);
    }

    @Test
    public void wordCannotBeFollowedByAnother() throws Exception {
        String regex = new Exo1().wordCannotBeFollowedByAnother();
        assertTrue("hello can come before this".matches(regex));
        assertTrue("hello this is dog".matches(regex));
        assertTrue("this is fine".matches(regex));

        assertFalse("this cannot come before hello".matches(regex));

        validateMedal(MedalId.MATCH_WORD_NOT_FOLLOWED, true);
    }

    @Test
    public void hasSpecialWordSurroundedBySpace() throws Exception {
        String regex = new Exo1().hasSpecialWordSurroundedBySpace();
        assertTrue("therefezffzeu space  efghghghireh".matches(regex));
        assertTrue("therefezffzeu sPacE  efghghghireh afafa fa fze  ".matches(regex));
        assertTrue("                  	SPACe   ".matches(regex));

        assertFalse("space gruhreiguh rhigueh g".matches(regex));
        assertFalse("grehigeh uzhgireugh eSPACEezgr".matches(regex));

        validateMedal(MedalId.MATCH_ASTRONAUT, true);
    }

}