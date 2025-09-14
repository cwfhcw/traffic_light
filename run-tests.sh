#!/bin/bash
# Compile all Java files including tests
javac -cp "lib/*:src/main/java" src/main/java/trafficlight/states/*.java src/main/java/trafficlight/ctrl/*.java src/main/java/trafficlight/gui/*.java

# Run all JUnit 5 tests
java -jar lib/junit-platform-console-standalone-1.10.0.jar --class-path src/main/java:lib/* --scan-class-path
