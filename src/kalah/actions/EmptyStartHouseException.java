package kalah.actions;

import kalah.CountAndCaptureException;
import kalah.Messages;

@SuppressWarnings("serial")
public class EmptyStartHouseException extends CountAndCaptureException {
	
	public EmptyStartHouseException() {
		super(Messages.EMPTY_HOUSE_MESSAGE);
	}
}
