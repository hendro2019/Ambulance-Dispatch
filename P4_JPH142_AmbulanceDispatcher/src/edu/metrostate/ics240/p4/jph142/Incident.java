package edu.metrostate.ics240.p4.jph142;

import java.time.LocalTime;

import edu.metrostate.ics240.p4.Event;


public class Incident implements Event, Comparable<Incident> {
	
	// request time for this ambulance
	private LocalTime requestTime;
	// the time this ambulance was dispatched
	private LocalTime dispatchTime;
	// the request id for this incident
	private String requestId;
	// the priority of this incident (ten-code priority system)
	private Priority priority;
	// the id number of the ambulance that that was dispatched to this call
	private int ambulanceId;
	// the number of minutes this call will take.
	private int duration;
	
	/**
	 * returns the incoming call time for this incident 
	 * @return requestTime the requestTime for this ambulance
	 */ 
	@Override
	public LocalTime getRequestTime() {
		return requestTime;
	}
	
	/**
	 * gets the time an ambulance was dispatched to this incident.
	 * @return dispatchTime the time an ambulance was dispatched to this incident. 
	 */
	@Override
	public LocalTime getDispatchTime() {
		return dispatchTime;
	}
	
	/**
	 * sets the incoming call time for this incident.
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(LocalTime requestTime) {
		this.requestTime = requestTime;
	}
	
	/**
	 * sets the request id for this incident.
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	/**
	 * sets the priority of this incident (ten-code system)
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	/**
	 * set the AmbulanceId the the id of the ambulance that was dispatched to this call
	 * @param ambulanceId the ambulanceId to set
	 */
	public void setAmbulanceId(int ambulanceId) {
		this.ambulanceId = ambulanceId;
	}
	
	/**
	 * sets duration to the number of minutes this incident will take (once dispatched)
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * sets dispatchTime to the time that an ambulance was dispatched to this call. 
	 * @param dispatchTime the dispatchTime to set
	 */
	public void setDispatchTime(LocalTime dispatchTime) {
		this.dispatchTime = dispatchTime;
	}
	
	/**
	 * gets the requestId of this ambulance
	 * @return requestId
	 */
	@Override
	public String getRequestID() {
		return requestId;
	}
	
	/**
	 * gets the priority of this incident.
	 * @return priority
	 */
	@Override
	public Priority getPriority() {
		return priority;
	}
	
	/**
	 * gets the duration of this incident
	 * @return duration
	 */
	@Override
	public int getDuration() {
		return duration;
	}
	
	/**
	 * gets the AssingedAmbulanceID of this incident
	 * @return ambulanceId
	 */
	@Override
	public int getAssignedAmbulanceID() {
		return ambulanceId;
	}
	
	/**
	 * compares this priority to o.priority based on the natural ordering of the enum.
	 */
	@Override
	public int compareTo(Incident o) {
		return priority.compareTo(o.getPriority());
	}
}
