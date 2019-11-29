package edu.metrostate.ics240.p4.jph142;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import java.util.concurrent.PriorityBlockingQueue;

import org.junit.jupiter.api.Test;

class AmbulanceTest {

	@Test
	void test() {
		Ambulance am1 = new Ambulance(1);
		am1.setFinishTime(LocalTime.parse("00:05"));
		int i; 
		Ambulance am2 = new Ambulance(2);
		i = am1.compareTo(am2);
		assertEquals(1, i);
		PriorityBlockingQueue<Ambulance> ambulances = new PriorityBlockingQueue<Ambulance>();
		ambulances.add(am2);
		ambulances.add(am1);
		//System.out.println(ambulances.remove().getFinishTime());
		//System.out.println(ambulances.remove().getFinishTime());
		am1.setFinishTime(LocalTime.parse("00:04"));
		am2.setFinishTime(LocalTime.parse("00:06"));
		
		System.out.println(ambulances.remove().getFinishTime());
		System.out.println(ambulances.remove().getFinishTime());
		
	}

}
