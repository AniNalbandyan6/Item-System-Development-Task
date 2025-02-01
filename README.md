# Item-System-Development

## Overview
This is a program for Item Upgrade System written in Java for a game where items have rarity and upgrade mechanics.

## Features
You are able to 

1. Add items to the collection with different rarities(Common, Great, Rare, Epic, Epic 1, Epic 2, and Legendary)
2. Upgrade items by combining them with other items of the same rarity.
3. Display the current collection

## Run the program

This repository only includes the source files of the program.
To start the program, you should run the Main.java file and interact through the command line.
The program will display a menu of option and you will be able to choose an option based on its number key (1, 2, 3, 4).
The program already includes sample items, but all instructions to display, upgrade or add an item will be displayed on command line.

## Error Handling
1. If you try to upgrade an item that doesn't exist in the collection, the program will display "No such item in your collection."
2. If you don't have enough items of the same rarity to upgrade, the program will display a message indicating that more items are needed.

## Design choices 
1. I created class Item for the item properties(name, rarity, upgrade count) and class Inventory to handle addition, display and upgrades of items.
2. To store items in a collection, I used ArrayList data structure to iterate through the items and add new ones.
3. In the ```displayCollection()``` method of Inventory class I used HashSets to display items based on their rarity in an organized way.
4. I used ```switch``` statement to handle different cases of rarities and add another case if needed.

I assumed that the user is already able to interact with the program through the command line.
