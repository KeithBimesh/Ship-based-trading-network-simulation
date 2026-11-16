### OOSE Assignment 2



##### 

#### Overview



The main task of this assignment is moving ships between ports, carrying cargo, and face

to environmental problems such as storms. And in this assignment mainly focus on

Object-oriented programming and design patterns, like Observer pattern, Factory pattern,

State Pattern.

##### 

##### How to run



go to the file directory and type this in terminal - bash gradlew run (I used ubuntu)

If you want see details run - tail -f journal.txt



##### Observer Pattern



Observer pattern was used to handle event reporting in each simulation part. I did it

thorugh the notifyObserver(). Observer pattern is implemented using a Subject.java as

interface, Observer.java as interface and manageEvents.java and JournalObserver.java as

concrete classes.

Whenever important event happens in the simulation, as examples, ship movement, ship

arrivals, impact of storms, cargo assignment, or repair actions, controllers send event

messages to ManageEvents class. And it forwards them to all observers. The

JournalObserver class implements the Observer interface and is responsible for writing

these events to journal.txt file.

Overall, I used observer pattern to handle event reporting in a flexible and modular way.

And this shows proper use of polymorphism with observer interface.



##### State Pattern



The state pattern is used to make the different behaviors of a ship according to its current

condition. Each ship keeps a reference to a ShipState Object. And ShipState is the

interface. Every concrete class such as IdleState, LoadState, MoveState, ShipRepairState,

UnloadState implements that interface and provides its own version of the update method.

IdleState class represents a ship that is not performing any action currently and waiting for

a task. MoveState class controls movement toward a target position. LoadState class and

UnloadState class represent cargo operation. ShipRepairState class does the repair

process for damaged ships. When certain conditions are met such as reaching a particular

sea worthiness, this ship transitions to a different state. As a example a ship hit by a storm

and decrease sea worthiness to 3 or below 3, it goes to ShipRepairState.

This also demonstrates polymorphism, because all states implement the ShipState

interface.





##### Design Choices



###### I divided all implementations into some packages.



• **model** – represent core entities. These classes only do storing data and providing

basic behavior. It’s include, Ship.java, Cargo.java, Lake.java, Port.java,

Position.java, Storm.java.



• **controller** – represent the simulation logic, like movement updates, storm

effects, and repair handling. It’s include, ManageShips.java, Movement.java,

RepairController.java, Simulation.java, StormController.java.



• **State** – represent how a ship behaves according to its current condition. It’s

include, IdleState.java, LoadState.java, MoveState.java, ShipRepairState.java,

ShipState.java, UnloadState.java.



• **Factory** – This is used to create objects in a controlled way. It’s include,

CargoFactory.java, PortFactory.java, ShipFactory.java, StormFactory.java

&#x20;

• **Observer** – This represent event reporting and logging. It’s include, Observer.java,

Subject.java, ManageEvents.java, JournalObserver.java.



• **View** – This display gird of the simulation empty water with “\~\~” and storm with “!”.

It’s include DisplayGrid.java.

