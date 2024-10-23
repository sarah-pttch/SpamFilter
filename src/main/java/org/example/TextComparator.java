package org.example;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class TextComparator {

    public TextComparator() { }

    public double[] compareTexts(String[] texts) {

        // scores stores similarity scores to other texts per text
        double[] scores = new double[texts.length];
        LevenshteinDistance distance = new LevenshteinDistance();

        // comparing each text to each of the remaining texts in the array
        for(int i = 0; i < (texts.length - 1); i++) {
            for(int j = i+1; j < texts.length; j++) {
                try {
                    // checking if texts are equal to avoid having to run more complex algorithm
                    if(texts[i].equals(texts[j])) {
                        scores[i]++;
                        scores[j]++;
                    } else {
                        // calculating Levenshtein distance: number of changes required to turn one text into the other
                        int changes = distance.apply(texts[i], texts[j]);
                        // converting number of changes into a score from 0 to 1 by putting it into relation to length of longer text
                        double score = 1.0 - ((double)changes / Math.max(texts[i].length(), texts[j].length()));
                        // only considering scores above 0.5 relevant for overall score
                        if(score >= 0.5) {
                            scores[i] += score;
                            scores[j] += score;
                        }
                    }
                } catch(NullPointerException | IllegalArgumentException e) {
                    System.out.println("At least one of the texts you entered seems to be null. Please check your input.");
                }
            }
        }

        return scores;
    }

    public int[] calculateSpamProbabilities(String[] texts) {
        double[] scores = this.compareTexts(texts);
        // number of texts that each text was compared to
        int numberTexts = scores.length - 1;
        int[] probabilities = new int[scores.length];
        for(int i = 0; i < scores.length; i++) {
            // setting score in relation to number of texts and turning it into rounded percentage
            int probability = (int) Math.round(scores[i] * 100 / numberTexts);
            probabilities[i] = probability;
            System.out.println("The spam probability of text " + (i+1) + " is " + probability + " %.");
        }
        // returning probabilities for potential further processing by caller
        return probabilities;
    }
}
