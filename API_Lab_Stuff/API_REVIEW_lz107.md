# Part 1
## What about your API/design is intended to be flexible?
### Frontend:
The frontend API and design must be able to accept data from the backend to update the GUI accordingly. For example, the Animate class that calls the update function which updates the coordinates of the turtle. The frontend will then update the GUI accordingly to the new coordinates. The frontend API must also be able to communicate with the backend for a few things: calling the update method, setting the turtle’s original coordinates, etc.
## How is your API/design encapsulating your implementation decisions?
Beyond what was listed above, the frontend API will encapsulate all graphic elements such as creating the console, the main turtle grid, the buttons, and other visible features on the GUI. On the other hand, the backend will encapsulate all of the logic behind executing SLogo commands. The only communication between the two should be that of updated coordinates to modify the GUI.
## What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?
One error case to handle is if the coordinates are outside of the visible grid in the GUI. If this happens, an error will be thrown. Another error case is if the input in the console is not valid Slogo code. If this happens, the GUI should display an error to the user saying so. On the backend, if a slogo method inputted is not located in the library of methods that we are using, an error message should be displayed on the GUI indicating that the method is not valid.
## Why do you think your API/design is good (also define what your measure of good is)?
The frontend and backend are very separate. Frontend methods only call specific functions within its domain and rarely touch the backend. Specific functions are encapsulated, such as the creation of javafx visual objects (ie. textareas, buttons, etc.). When backend methods are called, only methods from the parser are called as the functionality is required after inputting commands into the console. From there, the backend handles the commands that it parses.
 

# Part 2
## Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).
*Frontend sends user input of slogo commands to the parser after a “submit” type of button is clicked.
* Backend parses the submitted command, getting an array of the separate commands.
* Backend translates these commands using its library of methods and goes through the command to execute the method.
* Backend calls the methods that correspond with the commands by searching them in a library that maps to the required method.
* Backend updates coordinates of visual objects to be rendered on the GUI.
* Frontend gets the information from the backend and processes it in the update function, which is called in an Animate class that constantly updates the GUI and checks for changes. 

## How do you think at least one of the "advanced" Java features will help you implement your design?

Reflections will be used in order to pass the Strings names of methods as parameters into other methods. This will be useful for implementing the methods for the Repeat command in slogo. 

## What feature/design problem are you most excited to work on?

I am excited to work on aspects of the backend and the integration of getting frontend commands and translating that to executable slogo functions. 

# What feature/design problem are you most worried about working on?

I am worried about the front end animation and how we will go about visualizing that, especially based on whatever information the backend sends to the frontend. 
