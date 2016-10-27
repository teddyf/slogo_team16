Aninda Manocha, Lucy Zhang, Jordan Frazier, Teddy Franceschi


On the frontend, in order to accommodate the animal grid functionality, an AnimalPaneGUI class was created. This method consists of the following new APIs:
One significant change was the inclusion of a ```getMyAnimalList``` method in order to allow for multiple turtles. It is an external API meant to communicate the number of animals between front-end and backend.   

```java 
public void styleScrollPane() 
public void styleMyContainer() 
public void addAnimal(Animal animal) 
public AnimalPane getAnimalPane() 
public ScrollPane getScrollPane() 
public void setAnimalPane(AnimalPane animalPane) 
public void setScrollPane(ScrollPane pane) 
public List<Animal> getMyAnimalList() 
public void setMyAnimalList(List<Animal> myAnimalList) 
public Pane getMyContainer() 
public void setMyContainer(Pane myContainer) 
public void update(Observable o, Object arg) 
```
