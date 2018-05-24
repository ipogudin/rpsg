# Rock, paper, scissors game

A command line application with interactive mode. 

## Building

To build the app, execute:

`./mvnw clean package`

## Running

To run it, just use the following command:

`java -jar target/rock-paper-scissors-game-0.0.1-SNAPSHOT.jar`

## Algorithms

There are 3 implementation of game strategy:

- RandomShapeStrategy
- PsycologicalStrategy
- ProbabilityStrategy

You can configure the application with any strategy just look at GameConfiguration class.