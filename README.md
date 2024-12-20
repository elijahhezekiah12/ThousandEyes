# ThousandEyes 


# Project Overview
The application reads an API with a list of web URLs, pings each host five times and renders the average latency for each host

Using retrofit, we read the JSON API, and using runtime executors, we ping each host.

The app allows to check the state of a particular URL and if the host can accept requests. 


## Configuration Needed

To run the build,
You will need the latest version of Android Studio

An Android phone that has a Minimum SDK  31

Java JDK Version – 21+ 




## Task Approach

•	I set the dependency injection using Dagger Hilt
•	I made sure I used a good architecture using MVVM
•	Created data models so I can access the JSON from the API
•	I wrote the module that contains the Ping function
•	I have used the ping function of runtime in the past so I parsed the host into a function that uses a runtime executor to ping a host
•	I could read the average latency from the console output when the ping is completed.
•	 I ensured I could access my ping module library in the Android app by adding the library to the app as a dependency in Gradle
•	I injected the ping module into the respective viewModels and I called the function in a coroutine.
•	I tested the output on compose UI, ensuring that the data from the Json renders the Image and the average latency renders on the UI even though it is not in line with the best UI experience. 




## What I would have done differently :

I would have loved to create a screen specifically for the average latency;

Creating a screen for the average latency will allow me to render the average latency in a different screen;
allowing for a different UI scope for the average latency.  
This will allow me to create a better user experience and also manage threading better for the average latency on a different viewmodelscope.


I would have love to use a progress bar when it is needed as I am running a long running task 
(I couldn’t because I just recovered from being sick and I had to rush this technical test).

I would have written some unit test as that is very important


I would have spent more time on my Multi-threading approach as I did alright on the test but I still feel there is a bit more work to be done.


I would have provided sorting options and also added a button to retest individual host.


I am proud of being able to Modularize the library and Pinghost. 
I like my approach towards thread management from an intuitive position even though I could do more.

I will write unit test with the team in the next stage. 






