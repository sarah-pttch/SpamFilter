This module takes e-mail texts as input in the form of an array of Strings.
To each text it assigns a probability that the text is a Spam e-mail based on similarities between the input texts.
It calculates the similarity between the texts using Levenshtein distance.
For each pair of texts, the Levenshtein distance determines the number of changes (insertions, deletions, substitutions) needed to turn one of the texts into the other.
Based on the similarities, the probabilities are calculated.

An array of 10 texts is provided in the main method for testing.
