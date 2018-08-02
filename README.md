# Build it bigger with Gradle for Android & Java!

A joke-telling app with multiple flavors, that uses multiple libraries and Google Cloud Endpoints (GCE). There are four modules: A Java library that provides jokes, a GCE project to serve them, an Android Library with an activity to display the jokes, and an Android app that fetches jokes from the GCE and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## Skills Employed

Explored the role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. Skills employed included:

* Adding free and paid flavors to an app, and setting up the build to share code between them
* Factoring reusable functionality into a Java library
* Factoring reusable Android functionality into an Android library
* Configuring a multi project build to compile the libraries and app
* Using the Gradle App Engine plugin to deploy a backend
* Configuring an integration test suite that runs against the local App Engine development server

## How Did I Complete this Project?

### Step 1: Create a Java library

My first task was to create a Java library that provides jokes. I created a new
Gradle Java project either using the Android Studio wizard. Then
introduced a project dependency between the app and the new Java Library.

I then made the button display a toast showing a joke retrieved from my Java joke
telling library.

### Step 2: Create an Android Library

I created an Android Library containing an Activity that would display a joke
passed to it as an intent extra. I wired up the project dependencies so that the
button could pass the joke from the Java Library to the Android Library.

### Step 3: Setup GCE

The next task was pretty tricky. Instead of pulling jokes directly from
the Java library, I set up a Google Cloud Endpoints development server,
and pulled the jokes from there. The starting code already included the GCE module 
in a folder called backend.

Before going ahead I needed to be able to run a local instance of the GCE 
server. In order to do that I had to install the Cloud SDK:

https://cloud.google.com/sdk/docs/

Once installed, I followed the instructions in the Setup Cloud SDK section at:

https://cloud.google.com/endpoints/docs/frameworks/java/migrating-android

Note: i did not need to follow the rest of steps in the migration guide, only
the Setup Cloud SDK.

I could then start or stop the local server by using the gradle tasks as shown in the following
screenshot:

<img src="/FinalProject/GCE-server-gradle-tasks.png" height="500">

Once my local GCE server was started I could see the following at 
[localhost:8080](http://localhost:8080)

<img src="https://raw.githubusercontent.com/GoogleCloudPlatform/gradle-appengine-templates/77e9910911d5412e5efede5fa681ec105a0f02ad/doc/img/devappserver-endpoints.png">

I was finally ready to continue! 

I introduced a project dependency between the Java library and the GCE module, and modified 
the GCE starter code to pull jokes from the Java library. 
I created an AsyncTask to retrieve jokes using the template included in these 
[instructions](https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend). 
I then made the button kick off a task to retrieve a joke, 
and then launch the activity from the Android Library to display it.


### Step 4: Add Functional Tests

I added code to test that the Async task successfully retrieved a non-empty
string.

### Step 5: Add a Paid Flavor

I added free and paid product flavors to the app. Removed the ad (and any
dependencies I could) from the paid flavor.

### Add Interstitial Ad

I follow these instructions to add an interstitial ad to the free version.
The ad displays after the user hits the button, but before the joke is shown.

https://developers.google.com/mobile-ads-sdk/docs/admob/android/interstitial

### Add Loading Indicator

Added a loading indicator that is shown while the joke is being retrieved and
disappears when the joke is ready. The following tutorial was where I started:

http://www.tutorialspoint.com/android/android_loading_spinner.htm
