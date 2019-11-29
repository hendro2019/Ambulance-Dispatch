package edu.metrostate.ics240.p4.jph142;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import edu.metrostate.ics240.p4.Event;

class AmbulanceDispatcherTest {

	@Test
	void testReadSim() {
		String fileName = "C:\\Ambulance\\testSim.txt";
		AmbulanceDispatcher sim = new AmbulanceDispatcher(1);
		Event[] events = sim.processEvents(fileName);
		assertEquals(1, events.length);
		System.out.println(Arrays.toString(events));
	}

	@Test
	void testSim_0() {
		String fileName = "C:\\Ambulance\\testSim.txt";
		String[][] expResults = { { "E0001", "00:00" } };
		checkResults(fileName, 1, expResults);
	}

	@Test
	void testSim_1() {
		String fileName = "C:\\Ambulance\\testSim1.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0002", "00:15" } };
		checkResults(fileName, 1, expResults);
	}

	@Test
	void testSim_2() {
		String fileName = "C:\\Ambulance\\testSim2.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0002", "00:15" }, { "E0003", "00:25" } };
		checkResults(fileName, 1, expResults);
	}

	@Test
	void testSim_3() {
		String fileName = "C:\\Ambulance\\testSim3.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0002", "00:10" } };
		checkResults(fileName, 2, expResults);
	}

	@Test
	void testSim_4() {
		String fileName = "C:\\Ambulance\\testSim4.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0003", "00:10" }, { "E0002", "00:15" } };
		checkResults(fileName, 2, expResults);
	}

	@Test
	void testSim_5() {
		String fileName = "C:\\Ambulance\\testSim5.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0003", "00:10" }, { "E0002", "00:15" },
				{ "E0004", "00:20" } };
		checkResults(fileName, 2, expResults);
	}

	@Test
	void testSim_6() {
		String fileName = "C:\\Ambulance\\testSim6.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0003", "00:15" }, { "E0002", "00:25" } };
		checkResults(fileName, 1, expResults);
	}

	@Test
	void testSim_7() {
		String fileName = "C:\\Ambulance\\testSim7.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0002", "00:15" }, { "E0003", "00:25" } };
		checkResults(fileName, 1, expResults);
	}

	@Test
	void testSim_8() {
		String fileName = "C:\\Ambulance\\testSim8.txt";
		String[][] expResults = { { "E0001", "00:00" }, { "E0011", "00:30" }, { "E0012", "00:50" },
				{ "E0022", "02:00" }, { "E0021", "02:15" } };
		checkResults(fileName, 1, expResults);
	}

	@Test
	void testSim_9() {
		String fileName = "C:\\Ambulance\\testSim9.txt";
		String[][] expResults = { { "E0001", "08:00" }, { "E0002", "08:30" }, { "E0005", "10:00" },
				{ "E0004", "10:30" }, { "E0003", "10:45" } };
		checkResults(fileName, 2, expResults);
	}

	@Test
	void testSim_10() {
		String fileName = "C:\\Ambulance\\testSim10.txt";
		String[][] expResults = { { "E0001", "08:00" }, { "E0002", "08:30" }, { "E0003", "09:00" } };
		checkResults(fileName, 2, expResults);
	}

	@Test
	void testSim_11() {
		String fileName = "C:\\Ambulance\\testSim11.txt";
		String[][] expResults = { { "E0001", "08:00" }, { "E0002", "08:05" }, { "E0003", "08:15" },
				{ "E0005", "08:45" }, { "E0004", "09:05" }, { "E0006", "09:05" } };
		checkResults(fileName, 3, expResults);
	}

	@Test
	void testSim_12() {
		String fileName = "C:\\Ambulance\\testSim12.txt";
		String[][] expResults = { { "E0001", "08:00" }, { "E0002", "08:31" }, { "E0005", "08:50" },
				{ "E0003", "08:50" }, { "E0004", "09:10" } };
		checkResults(fileName, 2, expResults);
	}

	@Test
	void testSim_13() {
		String fileName = "C:\\Ambulance\\testSim13.txt";
		String[][] expResults = { { "E0003", "08:50" }, { "E0001", "08:50" }, { "E0002", "08:50" },
				{ "E0004", "09:10" } };
		checkResults(fileName, 3, expResults);
	}

	@Test
	void testSim_14() {
		String fileName = "C:\\Ambulance\\testSim14.txt";
		String[][] expResults = { { "E0001", "11:00" }, { "E0002", "11:05" }, { "E0003", "11:05" },
				{ "E0004", "11:10" }, { "E0005", "11:15" }, { "E0007", "11:25" }, { "E0006", "11:25" },
				{ "E0008", "11:25" }, {"E0009", "11:34"}, {"E0010", "11:40"}, {"E0011", "11:45"},
				{"E0012", "11:50"}, {"E0014", "11:55"}, {"E0013", "12:00"}, {"E0015", "12:35"}};
		checkResults(fileName, 3, expResults);
	}
	
	@Test
	void testSim_15() {
		String fileName = "C:\\Ambulance\\testSim15.txt";
		String[][] expResults = { { "E0001", "09:00" }, { "E0002", "09:15" }, { "E0003", "10:10" },
				{ "E0004", "10:15" }, { "E0005", "10:15" }, { "E0007", "11:30" }, { "E0006", "10:30" },
				{ "E0008", "11:45" }, {"E0009", "12:00"}, {"E0010", "12:30"}, {"E0011", "14:30"},
				{"E0012", "14:30"}, {"E0014", "15:20"}, {"E0013", "15:00"}, {"E0015", "15:20"}};
		checkResults(fileName, 3, expResults);
	}
	
	@Test
	void testSim_16() {
		String fileName = "C:\\Ambulance\\testSim16.txt";
		String[][] expResults = { { "E0001", "09:00" }, { "E0002", "09:05" }, { "E0003", "09:10" },
				{ "E0004", "09:15" }, { "E0005", "11:05" }, { "E0007", "10:40" }, { "E0006", "10:45" },
				{ "E0008", "11:00" }, {"E0009", "13:20"}, {"E0010", "14:20"} };
		checkResults(fileName, 4, expResults);
	}
	

	private void checkResults(String fileName, int numAmbulances, String[][] expResults) {
		Map<String, Event> eventsMap = new HashMap<>();
		AmbulanceDispatcher sim = new AmbulanceDispatcher(numAmbulances);
		Event[] events = sim.processEvents(fileName);

		final int KEY_IDX = 0;
		final int TIME_IDX = 1;
		for (Event e : events) {
			eventsMap.put(e.getRequestID(), e);
		}

		assertEquals(expResults.length, events.length);
		for (String[] result : expResults) {
			Event event = eventsMap.get(result[KEY_IDX]);
			assertEquals(LocalTime.parse(result[TIME_IDX]), event.getDispatchTime(), toString(event));
		}
	}

	private static String toString(Event e) {
		return String.format("%s|%s|%s|%s|%s", e.getRequestTime(), e.getDispatchTime(), e.getRequestID(),
				e.getPriority(), e.getDuration());
	}

}
