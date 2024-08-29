# Project Description: Individual Phase
Four weeks have passed since we barricaded ourselves in at the university. Unfortunately, we have discovered that life in this post-apocalyptic world is not quite as linear as we originally thought...

## Organizational Matters
After you have successfully completed the [group phase](/SoftwareEngineeringLab_SS21/GroupPhase/) and designed, implemented and tested the game together with your group, you must now show in the individual phase that you have understood and can implement the concepts of the lecture. In the individual phase, you will design an extension of the game from the group phase, implement and test it.

## Draft

To pass the individual phase, you must:
1. Create a design for the game extension and submit an executable implementation that corresponds to your design. 

2. Create a [document that explains how the concepts from the lecture have been incorporated into your design](/SoftwareEngineeringLab_SS21/IndividualPhase/Desciption.pdf). 

3. Write and pass meaningful unit tests and system tests for your individual phase implementation. Simply passing all the tests is not enough, your code must also be well structured and follow the concepts of the lecture.

4. Create a [class diagram](/SoftwareEngineeringLab_SS21/IndividualPhase/ClassDiagram_Reference.svg) for your design. Your class diagram must contain all classes that you add in your own design, as well as all classes that you change or extend yourself. You do not need to include all other classes from the provided draft in your class diagram. However, when adding new classes, make sure that relationships between classes are included in the class diagram even if an unchanged class is affected. (For example, if you have a new class that inherits from an existing class that you leave unchanged, the class from which your new class inherits must be included in your diagram, even though it is unchanged, in order to maintain the inheritance relationship in the class diagram. inheritance relationship in the class diagram).

## The Game Extension: Fate cards
Each turn, a new **fate card** is drawn for each player. Depending on which actions are carried out in this round, fate is triggered and takes its course. For example, food may disappear, new survivors may appear or zombies may spawn, even though you have just felt so safe. Sometimes the players are also spoiled for choice when it comes to the fate of the group...

For detailed information about the game extension and its technical details, refer to the full specification [(original version](/SoftwareEngineeringLab_SS21/IndividualPhase/Spezifikation.pdf), [English translation)](/SoftwareEngineeringLab_SS21/IndividualPhase/Specification.pdf).