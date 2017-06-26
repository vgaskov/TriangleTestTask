Synopsis
This is a maven based project for a console application implementing solution
for Triangle challenge test task written by Vladimir Gaskov.
The program asks a user to insert the lengths of the triangle's 
three sides as input and respond if the given lengths correspond to
equilateral, isosceles or scalene triangle or the input lengths cannot
correspond to any triangle. If an improper value is inserted, the program
responds the value is non-numeric and asks to insert a value again.
To exit the program you might want to type 'quit' at any time the
program asks you for an input value.
The project contains JUnit test cases and logging its state.

Installation and run
To install the program you need to download the github program's repository,
e.g. using the followin git command:
'git clone https://github.com/vgaskov/TriangleTestTask'
You will also need to have istalled JDK 1.8 (the proper installation instruction 
could be found by the following link: 
https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) 
and Maven (the installation manual: https://maven.apache.org/install.html).
Then go to the project's directory and execute the command:
'mvn package'
After the command is done, you will find the new directory 'target'which 
contains TriangleTestTask-0.0.1-SNAPSHOT-jar-with-dependencies.jar and 
TriangleTestTask-0.0.1-SNAPSHOT.jar.
To run the program execute 
'java -jar TriangleTestTask-0.0.1-SNAPSHOT-jar-with-dependencies.jar'
The program reports its state and errors to the program_log.log which could be
found in the target folder.