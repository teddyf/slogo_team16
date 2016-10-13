## Introduction
The goal of the project is to create a compiler and graphical interface for the SLogo language. The project must be capable of accepting user input nad displaying the graphical result of an algorithm coded in SLogo.


## Design Overview
Syntax Package: Translation/Mapping class, maps commands to another command that is comprehensible by our project  
Translator: Translates parsed input into   
Parser: Parses the user input line by line and returns an array of the words  
Turtle - stores information about the turtle (position, orientation, color, etc.)  
UpdateTurtle - master class: updates properties of the turtle  
MoveTurtle - extends UpdateTurtle and contains methods to update the position and orientation of a turtle   
SLogoLanguage - Creates the object that represents the language (handles strings, ints, and special characters) 
ExpressionTree -Takes in data from parser and stuffs it into a tree so we can perform a BFS to call a complete line command(s)
Stack - Stores variable values which user declares/stores.  
Memory - Stores prior positions, animations, etc so we can go back steps if this is an extension
Library - Stores a list of all classes and all methods so there is easy interaction between external and internal back end
## User Interface
DisplayTurtle - displays turtle image in UI  
TurtleInterface - contract to define turtle behavior  
Animate - move the turtle graphically  
Listener  

## API Details 
Back-end Internal: As of now, this API will encompass parsing, parsing String values into classes and methods (reflection)
and pushing these line calls into an expression tree.  I will need to possibly create the methods (may move to external) so
the mapping is fine.  I will also handle the Stack which will store user stored variables.  The Parser and Tree will be 
heavily based on the code provided, but I will build a platform which will store these individual bits into the tree and 
also right the data structure that stores all of these variables. More specifc API details will be available in the sample.

Back-end External: As of now, this API will handle turtle positioning.  There is a superclass for animals just in case we need
to make other animals, but more importantly, this type will encompass positioning, drawing, etc.  A lot of this will be closely 
tied with the front end via a handler.  Also may handle the controller because this is also connected with the front end (MVC)
(remove or add to this if you want.  I really don't know much on this...)

Front-end External: Handles the controll interface with backend (def add to this)

Front-end Internal: Handles GUI and the View part of the MVC (def add to this)
```public void updateTurtle(String command)```: Updates the turtle based on command  
```public String[] parseCommand(String command)```: Parses the command into a HashMap of the lines  
Ie. 
{1: [“To”, “RandomColor”],
2: [“repeat”, “4”, “[“, “fd”, “:length”, “rt”, “90” ]]}

```public void translateCommand(String[] command)``` : translates the command


## API Example Code
It is especially important in helping others understand how to use your APIs to provide example code. It should be clear from this code which objects are responsible for completing each part of the task, but you do not have to implement the called functions.
Show actual "sequence of code" that implements the following use case: 
The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.
Note, clearly show the flow of calls to public methods needed to complete this example, indicating which class contains each method called. It is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command will be.
Additionally, each member of the team should create one use case of their own (and example code) for the part of the project for which they intend to take responsibility. These can still be done as a group, but should represent a variety of areas of the overall project.
Design Considerations 
This section describes any issues which need to be addressed or resolved before attempting to devise a complete design solution. Include any design decisions that the group discussed at length (include pros and cons from all sides of the discussion) as well as any ambiguities, assumptions, or dependencies regarding the program that impact the overall design.

## Team Responsibilities
Aninda: Back-End External
Teddy: Back-End Internal  
Jordan: Front-End 
Lucy: Front-End