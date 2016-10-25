# cs477-lab_2
Link to instructions: https://mymasonportal.gmu.edu/bbcswebdav/pid-5852201-dt-content-rid-83474325_1/courses/73768.201670/Lab%20%232%20-%20Activities.pdf

CS 477 Lab #2
Due September 27 at classtime
Remember to RUN your app between the various steps – I promise this will actually save you time overall!
Part I – Starting new activities explicitly
 Create a new android project. The main activity should look like the screenshot to
the right, which has three TextView widgets (“Input1:”, “Input2:” and “Result=”),
two EditText widgets (both with hint “Enter a number” and 3 buttons. Each of
these buttons is going to start a new activity in different ways.
 Add another activity class to this app. The screen for this will be very simple, just
a TextView widget that will be generated from the two inputs (part of an intent)
that it gets from the activity that created it. The second screenshot shown here
assumes that the two input values were 32 and 2.
 Add code to the main activity so that when the first button is pressed, the value of
the two inputs (0 if null fields) is put into an intent and this intent is used to create
the activity from the previous step. Use startActivity() for this button. As with
every step of this process, test this before moving on to the next step. You should
be able to move between the two activities.
 The last step of part 1 is to implement the second button. Here, the information
flowing to the newly created activity is the same. The difference is that you are
going to use startActivityForResult() to create the new activity. The new
activity will implement a onBackPressed() function to package the result (64 for
the example here) and send this result to the main activity. In the main activity,
you need to implement onActivityResult() to get this returned information and
display it in the TextView widget for this purpose. Now, if you move between the
activities using the second button, the last field will change every time.

Part 2 – Starting Activities implicitly
 Go back to your lab from last week and add the XML below as a second intent-filter to the activity in the
AndroidManifest.xml for this app. Re-install/run this app on the device where you are running your lab3.
 <intent-filter>
 <action android:name="android.intent.action.VIEW" />
 <data android:mimeType="text/plain" />
<category android:name="android.intent.category.DEFAULT" />
 </intent-filter>
 Now, you are going to add code for the third button above:
Intent intent = new Intent();
intent.setAction("android.intent.action.VIEW");
intent.setType("text/plain");
intent.addCategory("android.intent.category.DEFAULT");
startActivity(intent);
Depending on what else is installed on your device, you may be given several choices but you should be
able to choose lab2 and it will start.

Part 3 – Saving state
The last thing you are going to do is save/restore some simple state. The goal here is to build a counter that will
starts at 0 and increments every time your device changes orientation. (On a virtual device, you can change
orientation with CTRL-F4). Go back and look at the slides and see how to save a counter integer. When the app
starts, modify the test that is printed to give the current counter value.
