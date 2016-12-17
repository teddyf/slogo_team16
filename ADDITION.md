## Estimation: 

# Before looking at the old code:
How long do you think it will take you to complete this new feature?
 - The front end extension does not seem too difficult, so I would say around two or three hours.

How many files will you need to add or update? Why?
 - I will add a few for the image chooser, and update one. I will probably have to update the main animalPane window to reflect an update
  when the imageview is changed.

# Review: after completing the feature:
How long did it take you to complete this new feature?
 - About two / two and a half hours.

How many files did you need to add or update? Why?
 - Added two files, one to create the button and give it the functionality, and one a helper for a FileChooser. 
 - Updated one file, in order to have the view create the button that will allow the user to open the new stage.
 The merge request shows a few changes in other classes as well, but they are whitespace changes or a change that does nothing functionally. 
I was pleasantly surprised that I could get this to work without changing any prexisting code, even if this new feature is not well designed.

Did you get it completely right on the first try?
 - Absolutely not. I had forgotten what is listening to what and who's observing who, and it is difficult to see in the code where that is 
 taking place. 

Analysis: what do you feel this exercise reveals about your project's design and documentation?
 - I think that is reveals more about our documentation than design. While our design had serious flaws, if I had the documentation that told me when
 and where the turtle's animation was being updated, I would have been able to implement it quicker I believe. 

Was it as good (or bad) as you remembered?
 - It was worse than I remembered, by far. Every project I say this, which I suppose is a good thing, but also not that great, since it hurts to look
 at how bad our code was compared to how much I have improved. 

What could be improved?
 - Organization, documentation, overall design. Specifically, there must be documentation on listeners / observables. Also, we should have
 created many more subpackages to organize our classes. This would have helped me remember which classes depend on each either. 
 - Our turtle class was not consistent at all. It seemed like we had an observable on it, but the update really didn't do anything useful. 
 Or maybe it did, and I just don't remember (documentation!) , (but in reality it actually did nothing). So that tripped me up for a little bit
until I decided to just pass in the Controller and work from there. A huge change between Slogo and Vooga is that in Vooga, we passed
around the Controller to almost every class, whereas in SLogo we did not utilize that aspect nearly well enough, which is why we have our terrible
global Data class.

What would it have been like if you were not familiar with the code at all?
 - I would have thrown my computer out of the window and jumped out after it. 