# embed-jruby-test
Test project showing that [Red Bridge interface implementation example](https://github.com/jruby/jruby/wiki/RedBridgeExamples#interface-implementation) does not work with JRuby 9000 series.

run example (requires java and maven):
```make
make run
```
using the JRuby `9.1.8.0` to run the example throws such an error: 
```
org.jruby.exceptions.RaiseException: (TypeError) can't define singleton
	at org.jruby.RubyModule.extend_object(org/jruby/RubyModule.java:2578)
```

JRuby `1.7.26` works fine. 


### Maven/java version used
```
mvn -v
Apache Maven 3.3.9
Maven home: /usr/share/maven
Java version: 1.8.0_121, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-openjdk-amd64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.8.0-46-generic", arch: "amd64", family: "unix"

```
