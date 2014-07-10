 README
========

## Requisites
- Java
- Gradle
- Preferred IDE/Text editor
- Internet connection

## Basic commands
- `$ ./gradlew test`: run tests
- `$ ./gradlew build`: builds the project
- `$ java -jar build/libs/horse-racing-0.1.0.jar`: runs the server

Point your browser to [http://localhost:8080/horse-racing](http://localhost:8080/horse-racing) to read the wording of the exercise.


Explanation


I've created two classes to represent a horse and a Lane. Every Lane is associated with a horse, and a horse is associated with a Lane.

The class Track process the input and create the horses and the lanes introduces with the input. Also process every throw introduce in the input sending the message throwBall against a Lane. The lane control if the throw is correct and in that case send a message to his horse in 
order to move it.

I've created a HorseComparator class to compare two horses based in the distence covered by the horses.

In the the project's folder, inside the doc folder, I've included a basic class diagram.

