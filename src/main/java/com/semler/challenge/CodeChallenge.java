package com.semler.challenge;

import java.util.Scanner;

public class CodeChallenge {
    public static void main(String[] args) {
    	System.out.println("Enter String with Question marks:");
        Scanner input = new Scanner(System.in);
        System.out.print(questionsMarks(input.nextLine()));
        input.close();
    }

    public static boolean questionsMarks(String statement) {
       return new StringValidator('?', 3).validate(statement);
    }


    /*public static boolean questionsMarks(String statement) {
    	QuestionMarksMatcher questionMarksMatcher = QuestionMarksMatcher.getQuestionMarksMatcher(statement);
    	return questionMarksMatcher.hasMatch(statement);
    }*/

}
