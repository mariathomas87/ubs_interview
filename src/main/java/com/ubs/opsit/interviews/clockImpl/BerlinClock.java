package com.ubs.opsit.interviews.clockImpl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.clockImpl.util.BerlinClockUtils;
import com.ubs.opsit.interviews.clockImpl.util.BerlinClockUtils.TimeUnit;

/**
 * Clock that uses rectangular lamps to show the time
 * @author maria.thomas
 *
 */
public class BerlinClock implements TimeConverter{
			
	/**
	 * Time converted to Berlin clock format
	 * Split the input String by delimiter and do validations
	 * Get the number of lights to be ON for each row
	 * Append to response string and return
	 * 
	 * @param aTime String
	 * @return lampSequence String
	 */
	public String convertTime(String aTime){
		
		StringBuilder lampSequence = new StringBuilder("");
		BerlinClockUtils berlinClockUtil = new BerlinClockUtils();
		String[] token = aTime.split(":");
		
		if(token.length >= 3){
			for(TimeUnit timeUnit : TimeUnit.values()){
				int timeValue = Integer.parseInt(token[timeUnit.getValue()]);
				if(timeValue >= 0){
					lampSequence.append(berlinClockUtil.getSequenceByUnit(timeValue, timeUnit));
					if(lampSequence.indexOf("ERROR") != -1){
						lampSequence.setLength(0);
						return lampSequence.toString();	
					}
				}else{
					lampSequence.setLength(0);
					return lampSequence.toString();
				}
			}			
		}else{
			return lampSequence.toString();
		}
		
		return (lampSequence != null && lampSequence.length() > 3) 
				? lampSequence.substring(0, lampSequence.length() - 2).toString() : lampSequence.toString();				
	}	
}
