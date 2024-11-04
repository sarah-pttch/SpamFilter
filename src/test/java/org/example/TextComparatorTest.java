package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextComparatorTest {

    //calling compareTexts method with identical texts should result in scores of 1.0
    @Test
    public void test_compareTexts_withIdenticalTexts() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"Spam", "Spam"};
        assertArrayEquals(new double[]{1.0, 1.0}, textComparator.compareTexts(texts));
    }

    //calling compareTexts method with a null text should result in score of 0.0 for null text,
    //exception should be caught
    @Test
    public void test_compareTexts_withNullText() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {null, "Spam"};
        assertArrayEquals(new double[]{0.0, 0.0}, textComparator.compareTexts(texts));
    }

    //calling compareTexts method with texts with 0% similarities should result in scores of 0.0
    @Test
    public void test_compareTexts_withCompletelyDifferentTexts() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"house", "warm"};
        assertArrayEquals(new double[]{0.0, 0.0}, textComparator.compareTexts(texts));
    }

    //calling compareTexts method with texts with few similarities (<50%) should result in scores of 0.0
    //as all similarities below 50% are excluded
    @Test
    public void test_compareTexts_withTextsWithMinimalSimilarities() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"house", "mountain"};
        assertArrayEquals(new double[] {0.0, 0.0}, textComparator.compareTexts(texts));
    }

    //calling compareTexts method with texts with 50% similarity should result in scores of 0.5
    //as similarities starting from 50% should be included
    @Test
    public void test_compareTexts_withHalfSimilarTexts() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"warm", "hard"};
        assertArrayEquals(new double[] {0.5, 0.5}, textComparator.compareTexts(texts));
    }

    //calling compareTexts method with more than 2 texts
    @Test
    public void test_compareTexts_withMoreThanTwoTexts() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"spam", "Spam", "ham", "house"};
        assertArrayEquals(new double[] {1.5, 1.5, 1.0, 0.0}, textComparator.compareTexts(texts));
    }

    //calling calculateSpamProbabilities method with identical texts should result in 100% spam probability
    @Test
    public void test_calculateSpamProbabilities_withIdenticalTexts() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"spam", "Spam"};
        assertArrayEquals(new int[]{100, 100}, textComparator.calculateSpamProbabilities(texts));
    }

    //calling calculateSpamProbabilities method with more than 2 texts
    @Test
    public void test_calculateSpamProbabilities_withMoreThanTwoTexts() {
        TextComparator textComparator = new TextComparator();
        String[] texts = new String[] {"spam", "Spam", "ham", "house"};
        assertArrayEquals(new int[]{50, 50, 33, 0}, textComparator.calculateSpamProbabilities(texts));
    }

}