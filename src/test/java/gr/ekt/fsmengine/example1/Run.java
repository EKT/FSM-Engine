package gr.ekt.fsmengine.example1;

import gr.ekt.fsmengine.api.Event;
import gr.ekt.fsmengine.api.SpringFsm;
import gr.ekt.fsmengine.api.StateContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Tests the finite state machine of an on/off switch.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class Run {

	/**
	 * The finite state machine.
	 */
	private SpringFsm machine;
	
	/**
	 * The object to monitor.
	 */
	private StateContext object;
	
	/**
	 * The event "Process".
	 */
	private Event press;
	
	/**
	 * Initialization.
	 */
	@Before
	public void initialize() {
		// context
		final ApplicationContext context = new FileSystemXmlApplicationContext("conf/context-example1.xml");
		machine = new SpringFsm();
		machine.setApplicationContext(context);

		// events
		press = (Event)context.getBean("eventPress");
		
		// object to monitor
		object = new Switch();
	}
	
	/**
	 * Tests the following route:
	 * START -> END
	 */
	@Test
	public void test() {
		System.out.format("Status: %s\n", object.getStateName());
		System.out.format("Event [%s] has arrived.\n", press.getName());
		machine.processEvent(press, object);
		System.out.format("Status: %s\n", object.getStateName());
	}

}
