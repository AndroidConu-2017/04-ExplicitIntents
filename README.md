# week06-ExplicitIntents-DataExchange
* Explicit Intents are used when you 
explicitly name the intended Activity
* Implicit Intents are used when you let Android discover
the intended Activity or app

*These are separate repos, may be easier to import them separately.*

Data exchange using intents and results.

# ExplicitIntentsMultiActivity  (app name Activity 1)
Multiple Implicit and Explicit intents in one app
# IntentData1
MainActivity sends data to Activity2
# IntentData2
MainActivity sends data to Activity2<br>
Activity2 sends a result code and data back to MainActivity
# IntentData2
MainActivity sends data to Activity2 & Activity3<br>
Activity2 sends a result code and data back to MainActivity<br>
Activity3 sends a result code and data back to MainActivity

Both return an Intent so to determine origin (is it from Activity2 or Activity3) we check the request code.



