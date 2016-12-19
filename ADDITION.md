# Estimation: before looking at the old code:
1. How long do you think it will take you to complete this new feature?
Around 2-3 hours
2. How many files will you need to add or update? Why?
Probably around 3. The AnimalPane, AnimalPaneGUI, and something related to the backend that I don't remember.

# Review: after completing the feature:
1. How long did it take you to complete this new feature?
2 hours
2. How many files did you need to add or update? Why?
3 files: AnimalClick and AnimalPaneGUI and Workspace.
The AnimalClick changed image on click, but did not prompt for the filechooser. Because it updates the turtle, the AnimalPaneGUI needs to be updated. Workspace initializes AnimalClick and AnimalPaneGUI and needed to be minimally altered.
3. Did you get it completely right on the first try?
No
# Analysis: what do you feel this exercise reveals about your project's design and documentation?
1. Was it as good (or bad) as you remembered?
It is worse than I remembered due to the number of dependencies that were not immediately clear. For example, in the following code we need an animal click to create the animalpanegui, but we need the animalPaneGUI to create a realAnimalClick. 
```java
animalClick = new AnimalClick();
createAnimalPaneGUI();
animalClick = new AnimalClick(myAnimalPaneGUI);
```

On the other hand, the pre-existing AnimalClick class was fairly flexible to modify. It simply required changing the implementation of what happens on a click from changing the image directly to prompting for the file chooser to change the image. 
2. What could be improved?
There are a lot of dependencies that I had forgotten about, making it very difficult to figure out what to modify. 
3. What would it have been like if you were not familiar with the code at all?
I would have struggled signficantly to figure out where the animal click was happening and how to get the available animals.