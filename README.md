# Groovy @Delegate issue with target compatibility Java 11

Context: Java 21 introduces a new interface [SequencedCollection](https://bugs.openjdk.org/browse/JDK-8266572)
as super-interface for `List` and other interfaces. 

This causes an issue in Groovy when the following conditions are met: 
1. Using a `@Delegate List someAttribute` in a class 
2. Compile with Java 21 
3. Run with Java 20 or earlier the resulting app. 



#### Replicate the issue  

1. Compile and run 
  ```
  ./gradlew run 
  ```


  Output: 

  ```
  Runtime: Groovy 4.0.21 on OpenJDK 64-Bit Server VM 21.0.3+9-LTS
  Plain list sub-class: [1, 2, 3]
  Delegate list class : [1, 2, 3]

  ```

2. Setup Java 11 

  ```
  sdk use java 11.0.14-zulu
  ```


3. Run the app with Java 11

  ```
  bash run.sh
  ```


  Output: 

  ```
  Runtime: Groovy 4.0.21 on OpenJDK 64-Bit Server VM 11.0.14+9-LTS
  Plain list sub-class: [1, 2, 3]
  Exception in thread "main" java.lang.NoClassDefFoundError: java/util/SequencedCollection
    at org.example.App.run(App.groovy:18)
    at org.example.App.main(App.groovy:22)
  Caused by: java.lang.ClassNotFoundException: java.util.SequencedCollection
    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
    at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
    at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
    ... 2 more
  ```