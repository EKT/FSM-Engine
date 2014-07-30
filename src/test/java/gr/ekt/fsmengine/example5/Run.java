package gr.ekt.fsmengine.example5;

import gr.ekt.fsmengine.api.Event;
import gr.ekt.fsmengine.api.SpringFsm;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Tests the finite state machine of an Order.
 * 
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class Run {

	/**
	 * The finite state machine.
	 */
	private SpringFsm machine;
	
	/**
	 * The order.
	 */
	private Order order;
	
	/**
	 * The event "read".
	 */
	private Event read;
	
	/**
	 * The event "timeout".
	 */
	private Event timeout;
	
	/**
	 * The event "cancel".
	 */
	private Event cancel;
	
	/**
	 * The event "reject".
	 */
	private Event reject;
	
	/**
	 * The event "dispatch".
	 */
	private Event dispatch;
	
	/**
	 * Initialization.
	 */
	@Before
	public void initialize() {
		// context
		final ApplicationContext context = new FileSystemXmlApplicationContext("conf/context-example5.xml");
		machine = new SpringFsm();
		machine.setApplicationContext(context);

		// events
		read = (Event)context.getBean("eventRead"); 
		cancel = (Event)context.getBean("eventCancel");
		reject = (Event)context.getBean("eventReject");
		timeout = (Event)context.getBean("eventTimeout");
		dispatch = (Event)context.getBean("eventDispatch");
		
		// order
		order = new Order();
		order.setAmount(12.50);
		order.setName("Telephone");
	}
	
	/**
	 * Tests a successful dispatch.
	 */
	@Test
	public void testRoute1() {
		System.out.println("Διαδρομή 1: \"Επιτυχημένη παραγγελία\"");
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [read] has arrived.");
		machine.processEvent(read, order);
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [dispatch] has arrived.");
		machine.processEvent(dispatch, order);
		System.out.format("Status: %s\n", order.getStateName());
	}
	
	/**
	 * Tests an order that times out after the supplier reads it.
	 */
	@Test
	public void testRoute2() {
		System.out.println("Διαδρομή 2: \"Παραγγελία η οποία εκπνέει πριν τη διαβάσει ο προμηθευτής\"");
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [read] has arrived.");
		machine.processEvent(read, order);
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [timeout] has arrived.");
		machine.processEvent(timeout, order);
		System.out.format("Status: %s\n", order.getStateName());
	}
	
	/**
	 * Tests an order that is rejected by the supplier.
	 */
	@Test
	public void testRoute3() {
		System.out.println("Διαδρομή 3: \"Παραγγελία την οποία απορρίπτει ο προμηθευτής\"");
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [read] has arrived.");
		machine.processEvent(read, order);
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [reject] has arrived.");
		machine.processEvent(reject, order);
		System.out.format("Status: %s\n", order.getStateName());
	}
	
	/**
	 * Tests an order that times out before it is read by the supplier.
	 */
	@Test
	public void testRoute4() {
		System.out.println("Διαδρομή 4: \"Παραγγελία η οποία εκπνέει πριν την ανοίξει ο προμηθευτής\"");
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [timeout] has arrived.");
		machine.processEvent(timeout, order);
		System.out.format("Status: %s\n", order.getStateName());
	}
	
	/**
	 * Tests an order that is cancelled and then timed out.
	 */
	@Test
	public void testRoute5() {
		System.out.println("Διαδρομή 5: \"Παραγγελία η οποία ακυρώνεται από τον πελάτη και απορρίπτεται από το σύστημα\"");
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [cancel] has arrived.");
		machine.processEvent(cancel, order);
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [timeout] has arrived.");
		machine.processEvent(timeout, order);
		System.out.format("Status: %s\n", order.getStateName());
	}
	
	/**
	 * Tests an order that is cancelled and then rejected.
	 */
	@Test
	public void testRoute6() {
		System.out.println("Διαδρομή 6: \"Παραγγελία η οποία ακυρώνεται από τον πελάτη και στη συνέχεια εκπνέει\"");
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [cancel] has arrived.");
		machine.processEvent(cancel, order);
		System.out.format("Status: %s\n", order.getStateName());
		System.out.println("Event [reject] has arrived.");
		machine.processEvent(reject, order);
		System.out.format("Status: %s\n", order.getStateName());
	}

}
