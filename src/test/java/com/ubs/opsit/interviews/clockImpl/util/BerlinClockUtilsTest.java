package com.ubs.opsit.interviews.clockImpl.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.clockImpl.util.BerlinClockUtils.TimeUnit;

/**
 * Test class for utility methods
 * 
 * @author maria.thomas
 *
 */
public class BerlinClockUtilsTest {

	BerlinClockUtils clockUtil;
	
	@Before
	public void setUp(){
		clockUtil = new BerlinClockUtils();
	}
	
	@Test
	public void testPositiveMinuteSpecColour(){
		String resp = clockUtil.getMinuteSpecColour("YYYYY", 5);
		assertThat(resp, is("YYRYY"));
	}
	
	@Test
	public void testNegativeMinuteSpecColour(){
		String resp = clockUtil.getMinuteSpecColour("YYYYY", -5);
		assertThat(resp, is("YYYYY"));
	}
	
	@Test
	public void testZeroMinuteSpecColour(){
		String resp = clockUtil.getMinuteSpecColour("YYYYY", 0);
		assertThat(resp, is("YYYYY"));
	}
	
	@Test
	public void testHighOnLampColourONState(){
		String resp = clockUtil.getLampColour(5, "Y", 10);
		assertThat(resp, is("YYYYYOOOOO\r\n"));
	}
	
	@Test
	public void testLowOnLampColourONState(){
		String resp = clockUtil.getLampColour(10, "Y", 5);
		assertThat(resp, is("ERROR"));
	}
	
	@Test
	public void getZeroOnLampColourONState(){
		String resp = clockUtil.getLampColour(0, "Y", 5);
		assertThat(resp, is("OOOOO\r\n"));
	}
	
	@Test
	public void testPositiveValOnGetSequence(){
		String resp = clockUtil.getSequenceByUnit(4, TimeUnit.HR);
		assertThat(resp, is("OOOO\r\nRRRR\r\n"));
	}
	
	@Test
	public void testNegativeValOnGetSequence(){
		String resp = clockUtil.getSequenceByUnit(-5, TimeUnit.MIN);
		assertThat(resp, is("ERROR"));
	}
	
	@Test
	public void testZeroOnGetSequence(){
		String resp = clockUtil.getSequenceByUnit(0, TimeUnit.HR);
		assertThat(resp, is("OOOO\r\nOOOO\r\n"));
	}
}
