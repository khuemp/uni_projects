# Project Description: Group Phase

It is the winter of 2021. Thanks to the numerous vaccinations, COVID-19 finally seems to have been defeated and normal everyday life is slowly becoming conceivable again. The universities in the country are all switching back to face-to-face operation one after the other. Everyone is lulled in safety, the students in the lecture halls and the professors at their chairs, when things suddenly get much worse than expected...

A new, much more dangerous virus had quietly crept in and turned large parts of society into zombies.

Two weeks later...

Survivors of the apocalypse have barricaded themselves together at the university and founded a society. The survivors' headquarters, called the colony, is the refectory building. There is enough room there for everyone, including the kindergarten children who cannot can look after themselves or defend themselves. They also need to be protected, given medical care and fed. Each and every survivor must contribute with his or her respective skills to ensure the survival of all. They have to fight the zombies, provide food and find other materials in the area.

And as if that wasn't enough, you also have to repeatedly fight against crises that plague the colony...

## Organizational Matters

In this group phase, you will work together with your fellow students in a team of 5-7 people to design, implement and test a game.

You will use the first approximately one and a half weeks of the group phase for the draft, the following approximately two and a half weeks for implementation (incl. testing). The planning of the game includes the development of rough and detailed designs. The implementation includes the game server with the game logic. You will also have to develop an extensive test suite that tests as many special cases as possible.

## Draft
In the design, your group must fulfill the following tasks:

1. You must create a [UML class diagram of your system](/SoftwareEngineeringLab_SS21/GroupPhase/classdiagram.svg). The class diagram must contain all relevant classes of your implementation, as well as their important fields and methods. This should make it clear which data and which functionality you encapsulate in the respective class. The relationships between the classes among each other must be modeled correctly. In the class diagram, all classes and all non-trivial methods including their parameters must be listed in the class diagram. The trivial methods include, in particular, standard getter and setter methods, as well as `hashCode`, `equals` and `toString`.

2. You must demonstrate the interaction of your classes using UML sequence diagrams for the following 2 scenarios:

- [Initializing the game](/SoftwareEngineeringLab_SS21/GroupPhase/initialisationSequence.svg).

- [Searching a location with random encounter where 1 child also comes into the game](/SoftwareEngineeringLab_SS21/GroupPhase/searchSequence.svg). 

- Just like customers in real life, the chair is also very changeable in its requirements for the game to be implemented. Therefore, after the design review there will be a change to the rules of the game. Your design must be flexible enough to be able to take into account the changes in the task without major effort. The specific changes will then be announced in a separate document [(original version](/SoftwareEngineeringLab_SS21/GroupPhase/Anforderungsaenderung.pdf), [English translation)](/SoftwareEngineeringLab_SS21/GroupPhase/Requirements_change.pdf), for which you can visualize the interaction of your classes using a [further UML sequence diagram](/SoftwareEngineeringLab_SS21/GroupPhase/searchPassiveAbility.svg).

## The Game
SoPra of the Dead is a cooperative board game in which the players try to achieve a jointly set goal before time runs out or the colony's nerves are frayed.

Similar to a physical board game, there is a world (the game board, so to speak) in which the **colony** and various **locations** exist.

The players control various **characters** (the *survivors* of the crisis) who can perform **actions** each round. For example, they can search for food and materials in the area, attack zombies and barricade entrances.

Whenever a character encounters a zombie, there is a certain probability of contracting an **infection** or being wounded.

There are various **cards** in the game, e.g. food cards, which add food tokens to the food supply, or crisis cards, which are drawn from the crisis card deck.

Cards played by players end up in the *waste pile*. This garbage must be disposed of by the colony so that **morale** does not drop.

Which actions a character can perform depends on their **abilities** and, if applicable, on how much the action costs. In this case, the player must use an *action die* to roll a number that is high enough for the character to be able to perform this action.

Each round of the game consists of **two consecutive phases**:
- The *player phase*, in which all players can carry out their actions and a new **crisis** is revealed.
- The *colony phase*, in which certain points must be resolved for the entire colony at the end of each round. 

The game ends as soon as the common goal has been achieved, the rounds have expired or the colony's morale drops to 0.

For detailed information about the gameplay and its technical details, refer to the full specification [(original version](/SoftwareEngineeringLab_SS21/GroupPhase//Spezifikation.pdf), [English translation)](/SoftwareEngineeringLab_SS21/GroupPhase/Specification.pdf).