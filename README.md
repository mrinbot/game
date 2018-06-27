# Game of Cards

Tech Stack : Java 8 + Spring Boot + Embedded Tomcat

# Building the program

1. Clone or Download the repository to a folder 
: git clone https://github.com/mrinbot/game.git

2. Go to the specified folder and under game/game-master folder

3. Execute the following command under game/game-master folder to build and generate executable jar
: mvn clean install

   The executable jar : game-1.0.0-SNAPSHOT.jar, is built under the target directory

# Running the program

1.Go to the target directory and execute the following command
: java -jar game-1.0.0-SNAPSHOT.jar

                 OR

2. Execute the following command under game/game-master folder to run the program
: mvn spring-boot:run

3. Hit the link : http://localhost:8080/game/
