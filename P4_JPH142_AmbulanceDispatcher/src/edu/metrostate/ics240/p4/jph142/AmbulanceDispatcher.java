package edu.metrostate.ics240.p4.jph142;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import edu.metrostate.ics240.p4.Event;
import edu.metrostate.ics240.p4.Event.Priority;

/**
 * Class AmbulanceDispather simulates an the response time of an emergency call
 * service with calls answered in order of severity
 * 
 * @author John
 *
 */
public class AmbulanceDispatcher {

	private PriorityQueue<Ambulance> ambulances;

	/**
	 * Initializes this Dispatcher with the specified number of ambulances.
	 * 
	 * @param numAmbulances the specified number of ambulances.
	 */
	public AmbulanceDispatcher(int numAmbulances) {
		ambulances = new PriorityQueue<Ambulance>();
		// initializes ambulances and adds to ambulance list.
		for (int i = 0; i < numAmbulances; i++)
			ambulances.add(new Ambulance(i + 1));

	}

	/**
	 * processEvents processes a txt file containing emergency call information. It
	 * returns an array containing the dispatch time for each call, and other
	 * information.
	 * 
	 * @param fileName the file being passed in
	 * @return eventArry the events that have been processes
	 */
	public Event[] processEvents(String fileName) {
		Event[] eventArry;
		Queue<Incident> staticIncidents = new LinkedList<Incident>();
		PriorityQueue<Incident> incidents = new PriorityQueue<Incident>();
		List<Incident> events = new LinkedList<Incident>();
		Iterator<Incident> incidentIt;

		try (Scanner incidentScanner = new Scanner(new File(fileName))) {
			// reads this file into incidents list
			while (incidentScanner.hasNextLine()) {
				staticIncidents.add(readLine(incidentScanner));
			}
		} catch (FileNotFoundException e) {
			// insures path is correct
			throw new IllegalArgumentException(e);
		}
		// the requestTime of the most recent call to come in.
		LocalTime currentTime = LocalTime.parse("00:00");
		// main loop. processes incidents.
		while (!staticIncidents.isEmpty() || !incidents.isEmpty()) {
			if (!staticIncidents.isEmpty()) {
				currentTime = staticIncidents.peek().getRequestTime();
				while (nextAvailableAmbulanceTime() != null && nextAvailableAmbulanceTime().isBefore(currentTime)
						&& !incidents.isEmpty()) {
					incidents.peek().setDispatchTime(nextAvailableAmbulanceTime());
					dispatch(incidents, ambulances, events);
				}
				incidents.add(staticIncidents.remove());
			}

			// checks for multiple calls in a single minute. if so, adds to list.
			incidentIt = staticIncidents.iterator();
			while (incidentIt.hasNext()) {
				Incident next = incidentIt.next();
				if (next.getRequestTime().equals(nextRequestTime(incidents))) {
					incidents.add(next);
					incidentIt.remove();
				}
			}
			while (!ambulances.peek().isBusy(currentTime) && !incidents.isEmpty()) {
				if (nextAvailableAmbulanceTime() != null
						&& nextAvailableAmbulanceTime().isAfter(nextRequestTime(incidents)))
					incidents.peek().setDispatchTime(nextAvailableAmbulanceTime());
				else
					incidents.peek().setDispatchTime(nextRequestTime(incidents));
				dispatch(incidents, ambulances, events);
			}
			if (staticIncidents.isEmpty() && !incidents.isEmpty()) {
				if (nextAvailableAmbulanceTime() != null
						&& nextAvailableAmbulanceTime().isAfter(nextRequestTime(incidents)))
					incidents.peek().setDispatchTime(nextAvailableAmbulanceTime());
				else
					incidents.peek().setDispatchTime(nextRequestTime(incidents));
				dispatch(incidents, ambulances, events);
			}
		}
		eventArry = events.toArray(new Event[events.size()]);
		return eventArry;
	}

	/**
	 * Returns the time that the next ambulance will be available.
	 * 
	 * @return The time that the next ambulance will be available.
	 */
	private LocalTime nextAvailableAmbulanceTime() {
		return ambulances.peek().getFinishTime();
	}

	/**
	 * Gets the request time of the next call.
	 * 
	 * @param incidents The list of pending calls.
	 * @return The requestTime of the next call.
	 */
	private LocalTime nextRequestTime(PriorityQueue<Incident> incidents) {
		return incidents.peek().getRequestTime();
	}

	/**
	 * Simulates the dispatch of a call by reassigning ambulance finishTime and adds
	 * the completed incident to events.
	 * 
	 * @param incidents  PriorityQueue containing incidents waiting to be processed.
	 * @param ambulances PriorityQueue containing the specified number of ambulances
	 *                   for this ambumalceDispatcher.
	 * @param events     the list containing processed Events.
	 */
	private void dispatch(PriorityQueue<Incident> incidents, PriorityQueue<Ambulance> ambulances,
			List<Incident> events) {
		Ambulance nextAmbulance;
		incidents.peek().setAmbulanceId(ambulances.peek().getId());
		nextAmbulance = ambulances.remove();
		nextAmbulance.setFinishTime(callLength(incidents));
		ambulances.add(nextAmbulance);
		events.add(incidents.remove());
	}

	/**
	 * Gets the amount of time that the next call will take.
	 * 
	 * @param incidents A list of pending incidents.
	 * @return The amount of time that the next call will take.
	 */
	private LocalTime callLength(PriorityQueue<Incident> incidents) {
		return incidents.peek().getDispatchTime().plusMinutes(incidents.peek().getDuration());
	}

	/**
	 * initializes and returns a single incident.
	 * 
	 * @param incidentScanner The scanner used to read lines
	 * @return call the incident being processed
	 */
	private Incident readLine(Scanner incidentScanner) {
		Incident call;
		String line = incidentScanner.nextLine();
		String[] emergencyCall = line.split("\\|");
		call = new Incident();
		call.setRequestTime(LocalTime.parse(emergencyCall[0]));
		call.setRequestId(emergencyCall[1]);
		call.setPriority(Priority.valueOf(emergencyCall[2]));
		call.setDuration(Integer.parseInt(emergencyCall[3]));
		return call;
	}
}
