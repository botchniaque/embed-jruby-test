# embed-jruby-test
Test project showing that [Red Bridge interface implementation example](https://github.com/jruby/jruby/wiki/RedBridgeExamples#interface-implementation) does not work with JRuby 9000 series.

run example:
```make
make run
```
using the JRuby `9.1.8.0` to run the example throws such an error: 
```
org.jruby.exceptions.RaiseException: (TypeError) can't define singleton
	at org.jruby.RubyModule.extend_object(org/jruby/RubyModule.java:2578)
```

JRuby `1.7.26` works fine. 
