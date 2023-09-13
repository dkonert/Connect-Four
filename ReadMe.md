# Connect Four

Two player game. Ends when one player gets four positions in a row, or when neither player is able to accomplish this task.

## Description

There are 3 classes to develop this text-based game. A Board class that is responsible for managing the board. TextUI class that is responsible for interacting with the user. Finally, a ConnectFour class which acts as the main, calling both Board and TextUI methods.

## Getting Started

### Dependencies

* checkstyle-10.3.4-all.jar
* java.io.File
* java.io.FileNotFoundException
* java.io.FileWriter 
* java.io.IOException
* java.util.Scanner



### Executing program

* Checkstyle Errors
```
java -jar checkstyle-10.3.4-all.jar -c config/checkstyle/checkstyle.xml src/main/java/connectfour/*
```
* Grade Build
```
./gradlew build
```
* Grade Run
```
./gradlew run
```
* Run Program
```
java -cp build/classes/java/main connectfour.ConnectFour
```

* Expected output

**************MAIN MENU**************
1. Start a new game
2. Load game from file
3. EXIT

**************************************
Please enter your option:  

## Author Information

NAME: Daniella Konert 

EMAIL: daniella.konert@gmail.com

PHONE: (647) 967-9915



## Development History

* 0.4
  * Final release 
  * ReadMe.md update 
  * Java Docs added 
  * Comments 
* 0.3
  * Various bug fixes and optimizations 
  * Save/Load Function Added to Board 
  * Checkstyle errors fixed 
* 0.2
    * Various bug fixes and optimizations
    * Most Functions created for all classes 
* 0.1
    * Initial Release


