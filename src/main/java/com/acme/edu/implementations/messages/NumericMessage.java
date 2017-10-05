package com.acme.edu.implementations.messages;

import com.acme.edu.implementations.exceptions.OverMaxFlowException;
import com.acme.edu.implementations.exceptions.OverMinFlowException;
import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public abstract class NumericMessage extends MegaMessage {
	
	
	protected NumericMessage(String message, Formatter formatter, Saver saver) {
		
		super ( message, formatter, saver );
	}
	
	protected long isSumOverflow(int value, long sum, long maxValue, long minValue) {
		long guardian = 0;
		try {
			if ( value > 0 & sum >= 0 ) {
				if ( guardian - sum <= value ) throw new OverMaxFlowException ();
			} else if ( value < 0 & sum <= 0 ) {
				if ( guardian - sum >= value ) throw new OverMinFlowException ();
			}
		} catch (OverMaxFlowException e) {
			guardian = maxValue;
			if ( overFlow < 0 ) {
				sum -= 1;
			}
			overFlow++;
		} catch (OverMinFlowException e) {
			guardian = minValue;
			if ( overFlow > 0 ) {
				sum -= 1;
			}
			overFlow--;
		}
		
		sum += value - guardian;
		if ( sum > 0 & overFlow < 0 )
		
		{
			sum = minValue + sum;
			overFlow++;
		} else if ( sum < 0 & overFlow > 0 )
		
		{
			sum = maxValue + sum;
			overFlow--;
		}
		return sum;
	}
	
	public int getGuardianValue(int maxValue, int minValue) {
		if ( overFlow < 0 ) return minValue;
		else return maxValue;
	}
}
