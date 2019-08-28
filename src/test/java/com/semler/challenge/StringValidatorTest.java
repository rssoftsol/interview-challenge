package com.semler.challenge;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringValidatorTest {
	@Test
	public void testQuestionMarks() {
	    String strWithQuestionMarks = "arrb6???4xxbl5???eee5";
	    assertTrue(new StringValidator('?', 3).validate(strWithQuestionMarks));
	}

	@Test
	public void testInvalidQuestionMarks() {
	    String strWithInvalidQuestionMarks = "arrb6???4xxbl5????eee5";
	    assertFalse(new StringValidator('?', 3).validate(strWithInvalidQuestionMarks));
	}

	@Test
	public void testValidQuestionMarksWithInvalidSum() {
	    String strWithInvalidQuestionMarks = "arrb6???4xxbl7???eee5";
	    assertFalse(new StringValidator('?', 3).validate(strWithInvalidQuestionMarks));
	}

	@Test
	public void testValidQuestionMarksWithoutNumbersAround() {
	    String strWithInvalidQuestionMarks = "arrb6???4xxbl5????eee5???";
	    assertFalse(new StringValidator('?', 3).validate(strWithInvalidQuestionMarks));
	}
	
	@Test
	public void testValidQuestionMarksWithLastCharAsNumber() {
	    String strWithInvalidQuestionMarks = "arrb6???4xxbl5????eee5yy2???8";
	    assertTrue(new StringValidator('?', 3).validate(strWithInvalidQuestionMarks));
	}

	@Test
	public void testNoQuestionMarks() {
	    String strWithInvalidQuestionMarks = "arrb6eee5eeer5";
	    assertFalse(new StringValidator('?', 3).validate(strWithInvalidQuestionMarks));
	}}
