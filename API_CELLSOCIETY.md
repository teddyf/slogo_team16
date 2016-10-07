Lucy Zhang
Teddy Franceschi
Aninda Manocha
Jordan Frazier

Categories:
the method should not be part of the API (i.e., it should not be public)
public BorderPane createBorderPane(Group root, int width, int height) 
public String readFileForTag(String tagName)
the method should be part of the External API because it helps other people on the team write their code
public void randomInitialize(Map<Integer, Color> colorMapping) 
public void initStaticGui(Group root, Timeline animation, String language, Simulation sim)
the method should be part of the Internal API because it helps future coders extend this component
setupNewScene(Stage stage, String title, double width, double height) 
public void updateView(Group root, int width, int height, Map<Integer, Color> stateColors, boolean needBorder)

Once you have classified the primary methods in the project, try to write a simplified (i.e., less than one page) description of the six APIs in the project (internal and external for each sub-part: simulation, configuration, and visualization).


Simulation
Overall, well organized.  Some vestigial code was there but all methods seemed to be appropriately encapsulated.  Most methods were valid to be public.  The ones not are listed above.

Configuration
Similar to above, well organized.  API looked extendible but not too detailed.  Allowed a lot of functionality but simple enough where there aren’t too many methods.  The ones that are not necessary are listed above.

Visualization
Extendible, well organized but not too detailed.  Allowed functionality but not too complicated.  The ones that are not are listed above.

 
______________________
SLogo: http://www.calormen.com/jslogo/

Classes: (Aninda & Teddy & later Lucy hopefully)
Movement
Syntax Package
Translator: 
Parser: Parse line by line
Turtle
UpdateTurtle
Translation/Mapping 

FrontEnd: (Lucy) (Jordan)
DisplayTurtle
TurtleInterface
Animate
Listener

Introduction

The goal of the project is to create a compiler and graphical interface for the SLogo language. The project must be capable of accepting user input nad displaying the graphical result of an algorithm coded in SLogo.

Design Overview

Classes: (Aninda & Teddy & later Lucy hopefully)
Syntax Package: Translation/Mapping class, maps commands to another command that is comprehensible by our project
Translator: Translates parsed input into 
Parser: Parses the user input line by line and returns an array of the words
Turtle - stores information about the turtle (position, orientation, color, etc.)
UpdateTurtle - master class: updates properties of the turtle
MoveTurtle - extends UpdateTurtle and contains methods to update the position and orientation of a turtle 
SLogoLanguage - Creates the object that represents the language (handles strings, ints, and special characters) 

FrontEnd: (Lucy) (Jordan)
DisplayTurtle - displays turtle image in UI
TurtleInterface - contract to define turtle behavior
Animate - move the turtle graphically
Listener

APIs:
public void updateTurtle(String command): Updates the turtle based on command
public String[] parseCommand(String command): Parses the command into a HashMap of the lines
Ie. 
{1: [“To”, “RandomColor”],
2: [“repeat”, “4”, “[“, “fd”, “:length”, “rt”, “90” ]]}

public void translateCommand(String[] command) : translates the command

Front end:
animateTurtle(): Updates the turtle on  the grid


This section serves as a map of your design for other programmers to gain a general understanding of how and why the program was divided up, and how the individual parts work together to provide the desired functionality. Describe the four APIs you intend to create (their purpose with regards to the program's functionality, and how they collaborate with each other) focusing specifically on the behavior, not the internal state. Include a picture of how the components are related (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a UML design program). Discuss specific classes, methods, and data structures, but not individual lines of code.
User Interface
This section describes how the user will interact with your program (keep it simple to start). Describe the overall appearance of program's user interface components and how users interact with these components (especially those specific to your program, i.e., means of input other than menus or toolbars). Include one or more pictures of the user interface (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a dummy program that serves as a exemplar). Describe any erroneous situations that are reported to the user (i.e., bad input data, empty data, etc.).
API Details 
This section describes each API introduced in the Overview in detail. Describe how each API supports specific features given in the assignment specification, what resources it might use, how it is intended to be used, and how it could be extended to include additional requirements (from the assignment specification or discussed by your team). Finally, justify the decision to create each class introduced with respect to the design's key goals, principles, and abstractions. Your APIs should be written as Java interfaces, types that cannot contain instance variables or private methods, in appropriate packages. These should be Java code files that compile and contain extensive comments to explain the purpose of each interface and each method within the interface (note this code can be generated directly from a UML diagram). Include any Exceptions you plan to throwbecause of errors that might occur within your methods. Note, this does not require that all of these types will remain as interfaces in the final implementation, just that the goal is for you to focus on each type's behavior and purpose.
API Example Code
It is especially important in helping others understand how to use your APIs to provide example code. It should be clear from this code which objects are responsible for completing each part of the task, but you do not have to implement the called functions.
Show actual "sequence of code" that implements the following use case: 
The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.
Note, clearly show the flow of calls to public methods needed to complete this example, indicating which class contains each method called. It is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command will be.
Additionally, each member of the team should create one use case of their own (and example code) for the part of the project for which they intend to take responsibility. These can still be done as a group, but should represent a variety of areas of the overall project.
Design Considerations 
This section describes any issues which need to be addressed or resolved before attempting to devise a complete design solution. Include any design decisions that the group discussed at length (include pros and cons from all sides of the discussion) as well as any ambiguities, assumptions, or dependencies regarding the program that impact the overall design.
Team Responsibilities
This section describes the program components each team member plans to take primary and secondary responsibility for and a high-level plan of how the team will complete the program.
