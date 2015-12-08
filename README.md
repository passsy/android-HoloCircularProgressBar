# HoloCircularProgressBar

### What is HoloCircularProgressBar

HoloCircularProgressBar is a Custom View implementation for Android you might know from the Android Clock App from Android 4.1


<div align="center">
  <img height="400px" src="https://raw.github.com/passsy/android-HoloCircularProgressBar/master/raw/screenshot1.png"/>
  <img height="400px" src="https://raw.github.com/passsy/android-HoloCircularProgressBar/master/raw/screenshot2.png"/>
</div>

## Usage

### Sample Project

You can see the ProgressBar working in the sample application. Just check out the library and create a new "Android Project form Existing Code"

### Use it in your own Code

Add the View in your Layout

    <com.pascalwelsch.holocircularprogressbar.HoloCircularProgressBar
        android:id="@+id/holoCircularProgressBar"
        android:layout_width="300dp"
        android:layout_height="300dp"/>
        
        
### Style

Don't forget to add a default style to your AppTheme

    <style name="AppTheme" parent="android:Theme.Holo">
        <item name="circularProgressBarStyle">@style/CircularProgressBar</item>
    </style>

I added two simple styles `@style/CircularProgressBar` and `@style/CircularProgressBarLight` to give you a quick start. You can see both styles in action in the sample Project

After you wrote your own style you have to rebuild your project in Android Studio (or restart your Eclipse. The ADT Plugin really has some troubles working with Android Libraries and Styles).

Of cause can you change the color at runtime. Here are some examples from the sample app:

<div align="center">
  <img height="400px" src="https://raw.github.com/passsy/android-HoloCircularProgressBar/master/raw/screenshot3.png"/>
  <img height="400px" src="https://raw.github.com/passsy/android-HoloCircularProgressBar/master/raw/screenshot4.png"/>
</div>
        
## Errors

There might be some error from your IDE. Most of them are simply solved after building the project.

### Got this error?

    The following classes could not be instantiated:
    - de.passsy.holocircularprogressbar.HoloCircularProgressBar (Open Class, Show Error Log)
    See the Error Log (Window > Show View) for more details.
    Tip: Use View.isInEditMode() in your custom views to skip code when shown in Eclipse

If your Layout Editor can't draw the view, you have to restart Eclipse. There is a bug in the ADT Plugin

#### Got the next error?

    Missing styles. Is the correct theme chosen for this layout?
    Use the Theme combo box above the layout to choose a different layout, or fix the theme style references.
    
    Failed to find style 'circularProgressBarStyle' in current theme

You have to add a style for this View. see the Style section

## Bugs

You found bugs? Report them or feel free to fix them by yourself and make a pull request. No one wants a buggy library

## What's new (Changelog)

##### version 1.3 `03.10.14`

	* new package name
	* visible in `ScrollView`
	* gradle and Android Studio support
	
##### version 1.2 `22.05.14`

	* bugfixes for orientationchange
	* layout bugs

##### version 1.1 `12.10.13`

	* change color at runtime
	* XML Attributes thumb_visible and marker_visible
	* minSdkVersion decreased to 8 for the library
	* avoid attr conflict with other library like HoloEverywhere
	* fixed no animation from progress 0 to progress 1
	* updated sample app with new test functions

##### version 1.0 `10.03.13`

	* initial version of a holo themend circular progress bar 


## License

    Copyright 2013 Pascal Welsch

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    

Author: [Pascal Welsch](https://plus.google.com/108162731626734859070?rel=author)
