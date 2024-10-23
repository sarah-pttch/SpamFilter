package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] testTexts = new String[10];
        testTexts[0] = "Hi Jack, unfortunately, your bank account has been hacked. To avoid further damage, please immediately change your online banking password by clicking on the link below. Kind regards Albert Albertson Fraud Detection at X-Bank";
        testTexts[1] = "Hi Lisa, unfortunately, your bank account has been hacked. To avoid further damage, please immediately change your online banking password by clicking on the link below. Kind regards Richard Richardson Fraud Detection at X-Bank";
        testTexts[2] = "Hi Karen, we are sorry to inform you that your bank account has been hacked. To avoid further damage, please immediately change your online banking password by clicking on the link below. Kind regards Steve Stevenson Fraud Detection at X-Bank";
        testTexts[3] = "Hi William, we are sorry to inform you that your bank account has been hacked. To avoid further damage, please immediately change your online banking password by clicking on the link below. Kind regards Albert Albertson Fraud Detection at X-Bank";
        testTexts[4] = "Hi Bert, unfortunately, your bank account has been hacked. To avoid further damage, please immediately change your online banking password by clicking on the link below. Kind regards Richard Richardson Fraud Detection at X-Bank";
        testTexts[5] = "Hi Jack, unfortunately, your bank account has been hacked. To avoid further damage, please immediately change your online banking password by clicking on the link below. Kind regards Albert Albertson Fraud Detection at X-Bank";
        testTexts[6] = "Dear Sam, unfortunately, we have to inform you that your bank account has been hacked. To avoid further damage, please immediately change your online banking password by clicking on the link below. Kind regards Richard Richardson Fraud Detection at X-Bank";
        testTexts[7] = "Dear Tim, I would like to formally invite you to my birthday party on November 12th at 8pm. Please RSVP using the link below. Looking forward to seeing you! Sandra";
        testTexts[8] = "Dear Susi, I would like to formally invite you to my birthday party on November 12th at 8pm. Please RSVP using the link below. Looking forward to seeing you! Sandra";
        testTexts[9] = "Dear Mr. Harris, unfortunately, I cannot attend the meeting in the office today because I am sick. Please find the doctor's note attached. Kind regards Sandra";

        TextComparator comparator = new TextComparator();
        int[] result = comparator.calculateSpamProbabilities(testTexts);
        System.out.println(Arrays.toString(result));
    }
}