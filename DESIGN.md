## Introduction
The goal of the project is to create a compiler and graphical interface for the SLogo language. The project must be capable of accepting user input and displaying the graphical result of an algorithm coded in SLogo.


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
Listener - binds parameters so view updates with model updates

## API Details 
Back-end Internal: As of now, this API will encompass parsing, parsing String values into classes and methods (reflection)
and pushing these line calls into an expression tree.  I will need to possibly create the methods (may move to external) so
the mapping is fine.  I will also handle the Stack which will store user stored variables.  The Parser and Tree will be 
heavily based on the code provided, but I will build a platform which will store these individual bits into the tree and 
also right the data structure that stores all of these variables. More specifc API details will be available in the sample.

Back-end External: As of now, this API will handle turtle positioning.  There is a superclass for animals just in case we need
to make other animals, but more importantly, this type will encompass positioning, drawing, etc.  A lot of this will be closely 
tied with the front end via a handler.  Also may handle the controller because this is also connected with the front end (MVC)

Front-end External: Handles the control interface with backend. Handles binding with the model parameters so that the view will update.
This API will encompass the 'controller', which exists as an intermediate between the front and back end. It is to be determined if the controller
will exist more as a back or front end application. A console class will act as the text input area that sends the user's command to the 
controller or parser, and then to the specific back end method. 

Front-end Internal: Handles GUI and the View part of the MVC:<br />
There is a 'tab' package, that houses the available tabs for the tab pane. Extra tabs will easily be added by inheriting from a generic tab. 
Internally, the tabs will be created and instantiated, with public methods to get their contained ListViews, Groups, etc. 
Separate graphics and animate classes will be available with public methods to create any necessary Node for the view. The animate class will
handle rendering the turtle's movement, pen, etc. <br/>
```public void updateTurtle(String command)```: Updates the turtle based on command  <br/>
```public String[] parseCommand(String command)```: Parses the command into a HashMap of the lines  <br/>
```public void translateCommand(String[] command)``` : translates the command


## API Example Code
```java
//Example code for turtle movement 
/**
	 * Moves the animal forward in its current heading by a specified number of pixels
	 * @param pixels - the specified number of pixels
	 * @return the number of pixels
	 */
	public double forward(double pixels) {
		double angle = 90 - heading;
		this.x += Math.cos(angle)*pixels;
		this.y -= Math.sin(angle)*pixels;
		return pixels;
	}

```

**Backend Internal**
* Math 
    * public double sum(double expression1, double expression2) 
    * public double difference(double expression1, double expression2) 
    * public double product(double expression1, double expression2) 
    * public double quotient(double expression1, double expression2) 
    * public double remainder(double expression1, double expression2) 
    * public double minus(double expression) 
    * public double random(double max) 
    * public double sin(double degrees) 
    * public double cos(double degrees) 
    * public double tan(double degrees) 
    * public double atan(double degrees)
    * public double log(double expression) 
    * public double pow(double base, double exponent) 
    * public double pi() 
* Boolean 
    * public int less(double expression1, double expression2) 
    * public int greater(double expression1, double expression2) 
    * public int equal(double expression1, double expression2) 
    * public int notEqual(double expression1, double expression2) 
    * public int and(int test1, int test2)	
    * public int or(int test1, int test2)
    * public int not(int test)
* Library
    * public void appendToClassSet(Class c)
    * public Method getMethod(String className, String methodName)
    * public HashMap<String, ArrayList<Class>> populateMethodToClass(HashSet<Class> classes)
* Command (Make/Set, Repeat, DoTimes, For, If, If/Else, To)
    * public void logic(String[] params)
    * public int toInt(String a)
    * public double toDouble(String a)
    * public void setName(String name)
    *public boolean isNumber(String a)
* Parser <br/>

**Backend External** 
* Animal
    * public double forward(double pixels) 
    * public double back(double pixels) 
    * public double right(double degrees) 
    * public double left(double degrees) 
    * public double setHeading(double heading) 
    * public double setXY(double x, double y) 
    * public int penDown() 
    * public int penUp() 
    * public int showTurtle() 
    * public int hideTurtle() 
    * public double home() 
    * public double clearScreen() 
    * public double getWidth() 
    * public double getHeight() 
    * public double getX() 
    * public double getY() 
    * public double getHeading() 
    * public int getPenDown() 
    * public int getShowing() 
    * public void setX(double x) 
    * public void setY(double y) 
    * public void setHeight(double height) 
    * public void setWidth(double width) 
    * public void setPen(int pen) 
    * public void setShowing(int showing) 
    *public abstract void update()

### Design Considerations 
* The format/data structure of the method mappings
* How the slogo code will be parsed into commands that correspond with the mapping
* How the user will set the turtle in the front end, and how this will be communicated to the backend

## Team Responsibilities
Aninda: Back-End External<br/>
Teddy: Back-End Internal/Back end integration  <br/>
Jordan: Front-End<br/>
Lucy: Front-End/Front End integration