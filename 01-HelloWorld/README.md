

# Getting started with Android


## Introduction

We will be making a hello world app so you can learn the very basics of creating an app in Android. The app will consist of two pages. On the first page there will be an input to type your name and a button. Clicking the button will take you to the second page where you will see a greeting on the screen with the name you typed. To accomplish this, you will learn about activities, resources, intents, and click listeners. The first step will be to create a view for the first page with the input field and submit button. In the second step we will add the functionality to show the second view when the button is clicked. And in the third step, we will create the second view.

## Step 1 - Edit main screen

We will begin by creating our first view. First, download android studio if you do not already have it:

```
https://developer.android.com/studio
```

Open the app and select the option to start a new project. Select empty activity and click next.  In the name section enter Hello World. The package name is a unique identifier for your app. It is typically a domain name that you own. For now, you can keep the package name as the default. The save location is the directory where you project files will be stored. You can change this or keep the default. Next, make sure the language is set to Java and the minimum API level is 19. The minimum API level is the lowest API your app is compatible with. Last, click finish. 

Navigate to the res folder then layout and open the activity_main.xml file. Delete the code after `<?xml version="1.0" encoding="utf-8"?>`. We will use XML to create our view. XML is a markup language like HTML. Layouts are XML files that arrange views on the screen. A view is created using tag that consists of attributes we set. View groups contain child views. They will will have an opening and closing tag. We will use a `<LinearLayout></LinearLayout>` view group. This arranges child views in horizontal columns or vertical rows. Child views have self-enclosing tags. We will use the `<EditText />` and `<Button />` views within our linear layout.  This is what you will paste into the file:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
   android:layout_height="match_parent"
   android:layout_width="match_parent"
   android:orientation="vertical"
   android:padding="16dp">
   <EditText
       android:id="@+id/name_edit_text"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:hint="@string/name_hint"/>
   <Button
       android:id="@+id/submit_button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="@string/submit" />
</LinearLayout>
```

The `layout_width` and `layout_height` are mandatory for the linear layout. The value `match_parent` means the view should fill the entire width or height of it’s parent. The value `wrap_content` means the view should only take up as much space as it’s content.  The hint in the EditText and the Button text use string resources. The general format for accessing resources in the XML is `@resourceType/resourceName`.  String resources are kept in res-->values-->strings.  To add a new string you add a `<string></string>` tag and give it a name using the name attribute and give it a value by putting the text in between the tag. The string resource for our hint is `<string name="name_hint">Enter your name</string>`.  The EditText and Button also have an `id` attribute so they can referenced in our code later.  The id attribute begins `@+id` because it is being created not accessed. 

## Step 2 - Create a link to hello screen


Next, we will add a click listener to our button that will take the text entered into our input field and send it to the second screen. Open the MainActivity.java file located in app-->java-->com.example.android.helloworld. This is the activity for our view. Activities display the UI and act as a controller for our app. First we will get a reference to the button view. The general form to access a resource in code is `R.resourceType.resourceName`. The resource type we will use to get our button is the id. The resource name is submit_button. Here is the code:

``` java
Button submitButton = findViewById(R.id.submit_button);
```

Next, we add an on click listener to the submit button. We could have done this in the XML using the onClick attribute. 

```java
submitButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
     ...
   }
});
```

Inside the `onClick` method  we will get a reference to the input field that we entered our name in and get the text.

```java
EditText nameEditText= findViewById(R.id.name_edit_text);
String name = nameEditText.getText().toString();
```

Next we will create a new intent. Intents allow us to start a new activity. This is how we will open the hello screen.  To create a new intent we instantiate an Intent object. The first argument is the context, where the activity can be found. The second argument is the activity class to start. This is our new intent:

```java
Intent intent = new Intent(MainActivity.this, HelloActivity.class);
```

We will create HelloActivity later. Next we put the text in the intent and start the new activity.

```java
intent.putExtra("username", name);
startActivity(intent);
```

The `putExtra` method allows us to pass information between activities. The first argument is a key which you will use to retrieve the data and the second argument is the value. This is what our code for the MainActivity class looks like:

```java
package com.example.android.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       Button submitButton = findViewById(R.id.submit_button);
       submitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               EditText nameEditText= findViewById(R.id.name_edit_text);
               String name = nameEditText.getText().toString();

               Intent intent = new Intent(MainActivity.this, HelloActivity.class);
               intent.putExtra("username", name);
               startActivity(intent);
           }
       });

   }


}
```

## Step 3 -  Create the hello view


In this last step we will create the new activity and populate our view with the text we entered. To create a new activity right click on the package name and choose new-->activity-->empty activity. Give it the name HelloActivity. This action creates a layout file named activity_hello.xml. and registers the activity in the Android manifest. Replace the contents of the layout file with the following:

```xml
<?xml version="1.0" encoding="utf-8"?>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
   android:id="@+id/name_text_view"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:layout_gravity="center" />
```

We’ve added a new attribute, layout_gravity to center the view horizontally and vertically. Next we will get the name from the intent.

```java
String name = getIntent().getStringExtra("username");
```

Then will get a reference to the text view and set the text of the view to be Hello +  name.

```java
TextView nameTextView = findViewById(R.id.name_text_view);
nameTextView.setText("Hello, " + name);
```

Here is the full code for the HelloActivity class:

```java
package com.example.android.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_hello);

       String name = getIntent().getStringExtra("username");
       TextView nameTextView = findViewById(R.id.name_text_view);
       nameTextView.setText("Hello, " + name);

   }
}
```


## Summary


To review, first we created a screen in our MainActivity class with a Button and EditText view. An activity is where the app draws its UI. We added an onClickListener to the button which extracted the name for the EditText and created an intent to send the name to the HelloActivity. An intent starts a new activity. In the next tutorial we will see how to create a todo app that displays a list of items using and array adapter.

## Resources


- [Udacity Android Basics: User Interface](https://www.udacity.com/course/android-basics-user-interface--ud834)
- [Udacity Android Basics: User Input](https://www.udacity.com/course/android-basics-user-input--ud836)
- [Udacity Android Basics: Multiscreen Apps](https://www.udacity.com/course/android-basics-multiscreen-apps--ud839)

