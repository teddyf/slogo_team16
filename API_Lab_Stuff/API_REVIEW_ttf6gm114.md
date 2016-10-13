Teddy Franceschi 
Guhan Muruganandam

Part 1: 
1. What about your API/design is intended to be flexible? 
I am handling Internal Handling. I want all type of method calls to be possible thus my method handling must be flexible along with general user input. 
2. How is your API/design encapsulating your implementation decisions? 
Methods that external back end may call are obviously public and other helpers are private. Quite a bit will be hidden (internal) because I really only need to show the methods to be called etc (as of now). This is really up for change though. 
3. What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)? 
Errors that can occur include invalid input (invalid method, invalid parameters, etc). As of now I will be throwing the errors but eventually I may instead try to underline these errors so the user can see these issues instead of just throwing an error. 
4. Why do you think your API/design is good (also define what your measure of good is)? 
I think my API/Design is good because it is limited but will be able to complete the necessary tasks. API should be both limited but still able to complete the tasks at hand.

Part 2: 
1. Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams). 
fd fd 50, fd right 50, pen up, pen down, repeat 5 fd 50 
2. How do you think at least one of the “advanced” Java features will help you implement your design? 
Definitely the expression tree will come in handy. Commands can have numerous parameters, some of which may also have additional parameters so it makes sense to use a tree structure in lieu of any List data type. 
3. What feature/design problem are you most excited to work on? 
I am most excited to work on the tree I think. It will be somewhat challenging but I think it will be a cool problem to tackle. 
4. What feature/design problem are you most worried about working on? 
I am most worried about working on the tree as well because it is rather abstract as of now.