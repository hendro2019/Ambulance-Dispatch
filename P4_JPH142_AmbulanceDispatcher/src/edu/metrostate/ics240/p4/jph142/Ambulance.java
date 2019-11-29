package edu.metrostate.ics240.p4.jph142;

import java.time.LocalTime;
/**
 * class Ambulance creates Ambulance objects with id numbers and finish times.
 * @author John
 *
 */
public class Ambulance implements Comparable<Ambulance> {
	
	//id number for this ambulance
	private int id;
	//the time this ambulance will finish it's call.
	private LocalTime finishTime;
	
	/**
	 * initializes this ambulances id to id.
	 * @param id the id number of this ambulance
	 */
	public Ambulance(int id) {
		
		this.id = id;
	}
	
	/**
	 * if finishTime is null or before currentTime returns false.
	 * else returns true
	 * @param currentTime the requestTime of the incident requesting an ambulance.
	 * @return true if busy
	 */
	public boolean isBusy(LocalTime currentTime) {
		if (finishTime == null)
			return false;
		else
			return (currentTime.isBefore(finishTime) );
	}
	
	/**
	 * sets this finishTime to finishTime
	 * @param finishTime the time this ambulance will finish
	 */
	public void setFinishTime(LocalTime finishTime) {
		this.finishTime = finishTime;
	}
	/**
	 * Returns this ambulances id
	 * @return id the id of this ambulance
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the finishTime of this ambulance
	 * @return finishTime the finish time of this ambulance
	 */
	public LocalTime getFinishTime() {
		return finishTime;
	}
	
	/**
	 * Compares this finishTime to o.finishTime
	 * with null receiving highest priority, then compared by natural ordering of LocalTimes.
	 */
	@Override
	public int compareTo(Ambulance o) {
		if (finishTime == null && o.getFinishTime() == null)
			return 0;
		else if (finishTime == null)
			return -1;
		else if (o.getFinishTime() == null)
			return 1;
		else
			return finishTime.compareTo(o.getFinishTime());
	}
}
