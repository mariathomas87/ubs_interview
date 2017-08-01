package com.ubs.opsit.interviews.clockImpl.util;

/**
 * Utility class to get specific lamp sequence based on time unit and value
 * 
 * @author maria.thomas
 *
 */
public class BerlinClockUtils {
	
	public static final Integer LAMP_VAL = 5;
	
	public enum TimeUnit{
		SEC(2), HR(0), MIN(1);
		
		int value;
		public int getValue(){
			return this.value;
		}
		TimeUnit(int val){
			this.value = val;
		}
	}
	
	/**
	 * This returns the sequence of colours for the particular timeUnit as per the
	 * value passed
	 * @param timeValue int - the value corresponding to the unit
	 * @param timeUnit int - determines which unit(hr, sec or min) is to be calculated
	 * @return respColor String - resulting string for the particular timeUnit
	 */
	public String getSequenceByUnit(int timeValue, TimeUnit timeUnit){
		
		String resColour = "";
		if(timeValue < 0){
			return "ERROR";
		}
		int firstRow = timeValue/LAMP_VAL;
		int secondRow = timeValue%LAMP_VAL;
				
		switch(timeUnit){
			case HR:
				resColour = getLampColour(firstRow, "R", 4) + 
								getLampColour(secondRow, "R", 4);
				break;
			case MIN:
				resColour = getMinuteSpecColour((getLampColour(firstRow, "Y", 11) + 
								getLampColour(secondRow, "Y", 4)), firstRow);
				break;
			case SEC:
				if(timeValue%2 == 0){
					resColour = "Y\r\n";
				}else{
					resColour = "O\r\n";
				}
				break;				
		}		
		return resColour;
	}
	
	/**
	 * Get the string with the lamp colour sequence based on the count 
	 * to be in ON state
	 * 
	 * @param onCount int
	 * @param colour String
	 * @param totalCount int
	 * @return
	 */
	public String getLampColour(int onCount, String colour, int totalCount){
		
		StringBuilder lampColour = new StringBuilder("");
		
		if(totalCount >= onCount){
			for(int i = 0; i < onCount; i++)
				lampColour.append(colour);
			for(int i = onCount; i < totalCount; i++)
				lampColour.append("O");
			lampColour.append("\r\n");	
		}else{
			lampColour.append("ERROR");
		}
		
		return lampColour.toString();
	}
	
	/**
	 * Minute specific colour to show quarter mark
	 * 
	 * @param colourString String
	 * @param lampCount int
	 * @return
	 */
	public String getMinuteSpecColour(String colourString, int lampCount){
		
		StringBuilder str = new StringBuilder(colourString);
		
		if(lampCount > 0){
			for(int index = 2; lampCount > 0 && lampCount/3 > 0; index = index + 3){
				str.setCharAt(index, 'R');
				lampCount = lampCount - 3;
			}	
		}
		
		return str.toString();
	}

}
