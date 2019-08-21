package com.semler.challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Processes string containing single digit numbers, letters, and question marks, and checks if there
 * are exactly 3 question marks between every pair of two numbers that add up to 10. 
 *
 * @version 1.0
 * @author shekhar
 */
public class QuestionMarksMatcher {
	private static final Pattern VALIDPATTERN = Pattern.compile("([0-9]\\?{3}[0-9])");
	private static final Pattern POSSIBLEINVALIDPATTERN1  = Pattern.compile("[0-9]\\?{1,2}[0-9]");
	private static final Pattern POSSIBLEINVALIDPATTERN2 = Pattern.compile("[0-9]\\?{4,}[0-9]");
	private static final int REQUIREDSUMMATION = 10;
	private String statement;
	private QuestionMarksMatcher(String statement) {
		this.statement = filterOutLetters(statement);
	}
	
	public static QuestionMarksMatcher getQuestionMarksMatcher(String statement) {
		return new QuestionMarksMatcher(filterOutLetters(statement));
	}
	
	private static String filterOutLetters(String statement) {
		return statement.replaceAll("[a-zA-Z]+","");
	}
	
	/**
	 * 
	 * @return true if all patterns in a statement matches ([0-9]\\?{1,2}[0-9] and 
	 * numbers around question marks, sums up to 10
	 */
	
	public boolean hasMatch() {
        if (hasInvalidMatches()) {
            return false;
        }
        return hasValidMatchedPatterns();
	}
	
	private boolean hasInvalidMatches() {
		Matcher possibleInvalidMatcher1  = POSSIBLEINVALIDPATTERN1.matcher(statement);
        Matcher possibleInvalidMatcher2 = POSSIBLEINVALIDPATTERN2.matcher(statement);
		if (possibleInvalidMatcher1.find() || possibleInvalidMatcher2.find()) {
            return true;
        }
		return false;
	}
	
	private boolean hasValidMatchedPatterns() {
		Matcher validMatcher = VALIDPATTERN.matcher(statement);
		boolean flag = false;
		while (validMatcher.find()) {
			flag = true;
            if(!hasRequiredSummation(validMatcher.group())) {
            	flag = false;
            	break;
            }
        }
        return flag;
	}
	
	private static boolean hasRequiredSummation(String s) {
        if (Character.getNumericValue(s.charAt(0)) +
                Character.getNumericValue(s.charAt(s.length() - 1)) == REQUIREDSUMMATION) {
            return true;
        };
        return false;
    }
}
