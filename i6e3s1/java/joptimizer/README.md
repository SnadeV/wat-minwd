# JOptimizer library basic example

JOptimizer is an open source library implemented in pure java programming language for solving general convex optimization problems, like for example LP, QP, QCQP, SOCP, SDP, GP and many more.

JOptimizer is thread-safe and can be used in a standalone application as well as in a J2EE environment: in fact, one of its first goals is to fill the lack of a pure-java optimizer because many of the market libraries run in an external process and that's not always a choice (especially in the case it has to be deployed in a J2EE server environment).

The example application shows a way to solve a simple linear optimization problem using the JOptimizer library.

## Getting started:

To start the application from the command line, make sure you are inside the project with the solution. Prepare the jar using maven command:

```
mvn clean package
```

And then just simply run the command from the powershell/cmd: 
```
java -jar target/joptimizer-example-1.0.jar
```

Note that you should have to [install JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Maven](https://maven.apache.org/install.html) as prerequisite.

## Linear problem which it's solving: 

```
    Minimize: 10x + 7y
    While:
    x + 2y >= 8
    4x + 6y >= 12
    All factors are greater or equal zero.
```

I6E3S1
Patryk Kwaśniak,
Dominik Maciejewski