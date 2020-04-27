# RMI

1.	Download and extract the code from github to a local directory.
2.	Open the command terminal and go to the same directory where you have extracted the code.
3.	Compile the source files using ‘ javac *.java ’ command.
4.	Generate the server stub using  ‘ rmic Mathserver ’the command
5.	Start the rmiregistry using the command ‘start rmiregistry’.
6.	Open another command terminal and go to the same directory to run the server using ‘ java -Djava.security.policy=allowall.policy MathServer ’ 
7.	Open another command terminal and run the client using ‘ java -Djava.security.policy=allowall.policy MathClient ’. Observer how the server and client operates. You may run multiple clients. 
