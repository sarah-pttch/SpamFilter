package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextComparatorTest {

    @Test
    public void test_compareTexts_withCorrectInput() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"Spam", "Spam"};
        assertArrayEquals(new double[]{1.0, 1.0}, textComparator.compareTexts(texts));
    }

    @Test
    public void test_compareTexts_withNullText() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {null, "Spam"};
        assertArrayEquals(new double[]{0.0, 0.0}, textComparator.compareTexts(texts));
    }

    @Test
    public void test_calculateSpamProbabilities_withCorrectInput() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"Spam", "Spam"};
        assertArrayEquals(new int[]{100, 100}, textComparator.calculateSpamProbabilities(texts));
    }
}