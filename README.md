FSM-Engine
==========

Easily define Finite State Machines in your Java applications, using Spring.

#Introduction

FSM Engine makes it easy to define and execute simple [finite state machines](http://en.wikipedia.org/wiki/Finite-state_machine), and thus workflows, in your Java applications. It really helps in cases where the behaviour of an object needs to be changed automatically, at runtime, depending on its state.

This library was originally inspired by [Harel Statecharts](http://www.wisdom.weizmann.ac.il/~dharel/papers/Statecharts.pdf) and the [State Design Pattern](http://en.wikipedia.org/wiki/State_pattern) and is implemented by the [National Documentation Centre](http://www.ekt.gr/en/) of Greece. Also, it is successfully incorporated in a few production applications, including the [National Archive of PhD Theses](http://www.didaktorika.gr/eadd/?locale=en) and the [National Interloaning System of Scientific and Technological Libraries](http://eskep.ekt.gr).

#Features

* Basic FSM elements: States, Events, Transitions.
* Advanced FSM blocks: Actions, Guard conditions, Branches.
* Define your Finite State Machine in a Spring context XML.
* Use standard Spring annotation for getting the workflow engine.

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
Examine the tests, under src/test/java, for a lot of practical examples. Moreover, [Wiki](https://github.com/EKT/FSM-Engine/wiki) provides complimentary information on using the library.
