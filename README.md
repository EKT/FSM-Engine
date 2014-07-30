FSM-Engine
==========

Easily define Finite State Machines in your Java applications, using Spring.

#Introduction

FSM Engine makes it easy to define and execute simple [finite state machines](http://en.wikipedia.org/wiki/Finite-state_machine), and thus workflows, in your Java applications. It really helps in cases where the behaviour of an object needs to be changed automatically, at runtime, depending on its state.

This library was originally inspired by [Harel Statecharts](http://www.wisdom.weizmann.ac.il/~dharel/papers/Statecharts.pdf) and the [State Design Pattern](http://en.wikipedia.org/wiki/State_pattern) and is implemented by the [National Documentation Centre](http://www.ekt.gr/en/) of Greece. Also, it is successfully incorporated in a few production applications, including the [National Archive of PhD Theses](http://www.didaktorika.gr/eadd/?locale=en) and the [National Interloaning System of Scientific and Technological Libraries](http://eskep.ekt.gr).

#Features

* Basic FSM elements: States, Events, Transitions.
* Advanced FSM blocks: Actions, Guard conditions, Branches.
* Define your Finite State Machine in a plain Spring context XML.
* Use standard Spring annotations for working with the workflow engine.

#Quick Start

The recommended way to get started using FSM Engine in your project is with a dependency management system. Specifically, FSM Engine uses [Apache Maven](http://maven.apache.org/) for project management.

Clone this git repository, and add the artifact your local maven repository:
```sh
git clone https://github.com/EKT/FSM-Engine.git
cd FSM-Engine
mvn clean install
```
Finally, include the dependency in pom.xml of your project:
```xml
<dependency>
  <groupId>gr.ekt</groupId>
  <artifactId>fsm-engine</artifactId>
  <version>0.9.0</version>
</dependency>
```
Examine the tests, under src/test/java, for a lot of practical examples. 

As always, our [Wiki](https://github.com/EKT/FSM-Engine/wiki) provides complimentary information on using the library.


#3 minute demo

Suppose a simple Switch that can be either OFF or ON.

![The state diagram of a simple switch](https://cloud.githubusercontent.com/assets/5664469/3731138/0db9e530-16e5-11e4-8678-87e9e0c36ad8.png)

At first, our domain object should implement the interface gr.ekt.fsmengine.api.StateContext.

```java
public class Switch implements StateContext {
	// actual implementation
}
```

Then, we should declare the basic elements in out Spring context.

```xml
    <!-- Event -->
    <bean id="eventPress" class="gr.ekt.fsmengine.api.DefaultEvent">
        <property name="name" value="EVENT_PRESS"/>
    </bean>

    <!-- States -->
    <bean id="stateOff" class="gr.ekt.fsmengine.api.DefaultState">
        <property name="stateName" value="STATE_OFF"/>
        <property name="eventTransitionsMap">
            <map>
                <entry key-ref="eventPress" value-ref="transition"/>
            </map>
        </property>
    </bean>
    
    <bean id="stateOn" class="gr.ekt.fsmengine.api.DefaultState">
        <property name="stateName" value="STATE_ON"/>
    </bean>

    <!-- Transition -->
    <bean id="transition" class="gr.ekt.fsmengine.api.DefaultTransition">
        <property name="fromState" ref="stateOff" />
        <property name="toState" ref="stateOn" />
    </bean>
```

So, we have one event, two states and one transition. The "press" event moves the switch from OFF to ON.

Back to our Java code, we just need a reference to the FSM engine and the event.

```java
@Autowired
private SpringFsm engine;

@Autowired
private Event press;
```

Let's fire the event!

```java
void press(Switch switch) {
	System.out.format("Status: %s\n", switch.getStateName()); // OFF
	engine.processEvent(press, switch);
	System.out.format("Status: %s\n", switch.getStateName()); // ON
}
```

![Executing example 1](https://cloud.githubusercontent.com/assets/5664469/3731205/ab66c306-16e6-11e4-95cc-276b08de6611.png)

