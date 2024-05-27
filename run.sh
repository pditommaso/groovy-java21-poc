[ ! -e .classpath ] && ./gradlew saveRuntimeClasspath
java -cp $(cat .classpath) org.example.App
