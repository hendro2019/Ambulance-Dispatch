package edu.metrostate.ics240.p4;

import java.time.LocalTime;

public interface Event {
	/**
	 * Priority of event from TEN-3 (high) to TEN-1 (low)
	 */
	public enum Priority {
		T3, T2, T1;
	}
	
	/**
	 * Returns the request time of this Event
	 * @return event request time
	 */
	LocalTime getRequestTime();
	
	/**
	 * Returns the dispatch time of this Event
	 * @return event dispatch time
	 */
	LocalTime getDispatchTime();
	
	/**
	 * Returns the request ID string of this Event
	 * @return event request ID
	 */
	String getRequestID();
	
	/**
	 * Returns the priority of this Event
	 * @return event priority
	 */
	Priority getPriority();
	
	/**
	 * Returns the duration of this Event
	 * @return event duration
	 */
	int getDuration();
	
	/**
	 * Returns the Ambulance ID that this Event was assigned to
	 * @return event AmbulanceID
	 */
	int getAssignedAmbulanceID();
}

