# slogo
A development environment that helps users write SLogo programs.

Team: Aninda Manocha, Teddy Franceschi, Jordan Frazier, Lucy Zhang

Date started: 10/4/16

Date finished: 11/1/16

Hours: 100+

Frontend: Jordan, Lucy
Backend: Aninda, Teddy

## Start/Test Program:
Use Main.java to begin SLogo
Use Tester.java to test the parser

## Resources:
Stack Overflow

## Resource files:
Our SLogo is initialized by an XML file. These examples are contained in the Data folder of our project. When prompted, run "example1.xml"
to begin a basic SLogo interface.

example1.xml: File used to create the IDE according to its settings <br/>
myInput.slogo: File used to write slogo commands to and read commands from<br/>
slogoMethods.properties: A list of all of the slogo commands<br/>
SLOGO_help.html: The html help page<br/>
Language properties files: All of the available languages<br/>
methodMapping.properties: All of the methods and their file locations<br/>

## Extra features
* Multiple turtles
* Multiple workspaces
* Animated turtles
* Implemented extension commands that modify GUI
* Save, load and set workspace preferences 

## Bugs
* Reset screen does not link newly created turtle to animation
* Multiple workspaces share same graphical properties

## Impressions
This project proved to be an interesting step up from Cell Society. The integration of the front and back end proved to be a complex problem,
necesitating the use of the Observer/Observable pattern, which allowed for us to bind elements together and have them automatically update and do things when
the other is updated. It was not too complicated to where we got lost and had no hope, but just enough to push our design to its limits and ensure
that we needed at least a hint of good design practices in order to produce a functional program. 

