#### API REVIEW

Front End

## Part 1
1. The front end is flexible for commands because the view should just take in the user input, then send it off to the controller / parser.
This way, any new commands that the backend supports would work without any additional changes to the front end. The front end should also be flexible enough
to change the visualization features of the image, pen, background color, etc, without affecting the back end calculations. 
2. The model only cares what the user inputs. The view encapsulates how the turtle is drawn, animated, and any stylistic changes. 
3. Incorrect user input should display errors in a new window, alerting user that the the command was invalid. Invalid math operations
such as divide by 0 may have to be handled as well. For the editable variables, if the user attempts to change an integer to a string, that would
be an invalid type. This can be handled by displaying an error message that tells the user that they input an invalid type. 
A case to watch out for is if the turtle is actively drawing a user's command, and the user inputs another command. The view will either handle this by
throwing an error, or wait and send the command off to the parser/controller after the turtle's drawing is complete.
4. It is flexible and well encapsulated. The model knows little of the view, and vice versa. Theoretically, any backend with the correct parser could
attach to the proposed front end and still work. This would be very good. 

## Part 2
1. 
 - User changes the color of the pen using a displayed combobox or button
 - User changes the background color of the grid using a displayed combobox or button
 - User changes the number of images on the grid
 - User enters the command in a different language before changing the resource file with the language button
 - Enter the help page while a command is currently running
2. The Bindings feature will help the View automatically update when the backend is updated
3. Learning about Bindings. I have not used them before, and they seem very powerful, useful, and interesting to learn about. 
4. Reflections seems difficult and prone to misuse by inexperienced developers (me). Recursively checking the inputs worries me, because
recursion is terrible. 