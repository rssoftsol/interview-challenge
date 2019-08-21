package com.semler.challenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CodeChallengeTest {

	@Test
    public void testQuestionMarks() {
		String strWithQuestionMarks = "arrb6???4xxbl5???eee5";
		assertTrue(CodeChallenge.questionsMarks(strWithQuestionMarks));
    }
	
	@Test
    public void testInvalidQuestionMarks() {
		String strWithInvalidQuestionMarks = "arrb6???4xxbl5????eee5";
		assertFalse(CodeChallenge.questionsMarks(strWithInvalidQuestionMarks));
    }
}
