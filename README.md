# Java-Game-Dev-Projects
Older game dev projects I have worked on. Most are small proof of concepts of mechanics. Each has a small description and preview of what I worked on.

# Lovecraft Crossing

My first attempt at a complex game mechanics. I envisioned a game with mechanics as a cross between Animal Crossing and Rim World. For this project, I specifically looked at recreating Rim World-like mechanics.

You can't directly control  your player, but you can select where you want to move. You can only move to a tile that is not occupied by another player. You can also give direct commands to your player like "cut trees' or "build" and the player will automatically execute those commands.

For this proof of concept, you are able to:
* Tell the player where to move
* Tell the player to cut trees
* Set buildings and tell the player to build them (given a certain amount of resources)

Mechanics:
* Pathfinding - A* algorithm
* Prioritized Queue - Priority queue for pathfinding
* Automatic Execution - Automatically execute commands until unable or finished
* Build buildings - The user can set up structures then implement a build command where the player will collect the resources needed for the building and go build it.
* Cut trees - The user can set up a cut tree command and collect resources
* Resource Management - The user can set buildings, but the player will only build if he has enough resources.
* Random Enviroment - The trees are randomly seeded.


Directions
* Right Mouse - Select place to move
* Left Mouse - Select place to build
* 'c' - Cut trees Command
* 'b' - Build Command


![Diagram](Lovecraft_Crossing/lovecraft-ss-diagram.png)
## Movement
![Movement](Lovecraft_Crossing/lovecraft-ss-movement.gif)
## Cut Trees
![Cut Tree](Lovecraft_Crossing/lovecraft-ss-cuttingwood.gif)
## Building
![Building](Lovecraft_Crossing/lovecraft-ss-building.gif)


# Mistborn Proof of Concept

This is a small proof of concept with several mechanics from the fantasy series Mistborn.

Small 2-D Platformer built in pure java. 

Mechanics:
* Collision
* Gravity
* Jumping/Movement

![Gif](Mistborn/screenshot2.gif)
![Screenshot](Mistborn/ss1.png)

# Checkers - Incomplete

I was attempting to creating a small checkers game in order to explore game ai. 
Unfortunately, I ended up abandoning the project pretty early.