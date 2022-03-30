# Vera Android SDK 

Official repo for Vera Android SDK.

## Installation
- latest_version = 0.0.3

### Gradle

To integrate VeraSDK into your android project using gradle, build.gradle of app module:

```groovy
implementation 'com.resonai.vera:app:${latest_version}'


repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/resonai/vera-android-ibraheem")
        credentials {
            username = "${user_name}"
            password = "${github_token}"
        }

    }
}


```

Then,sync project:


## Usage 
  Create a configuration object and start sdk  for both case 


With Login :
    To track user information you can  pass user data.

```groovy

        VeraConfiguration.Builder()
               .setClientAppID("vera_client_app")
               .setLanguage(Languages.EN)
               .startWithLogin(this, "userName", "userId", "token");
```
Without login as :

```groovy
     VeraConfiguration.Builder()
                  .setClientAppID("vera_client_app")
                  .setLanguage(Languages.EN)
                  .startWithoutLogin(this);
```

## Manifest: 

#Permissions: 

```xml
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"
        tools:ignore="ScopedStorage" />

```
* "App needs access to the camera in order to render AR."
* "App needs location access to provide accurate AR experiences."
* "App needs storage access to save cache"

## Handle  Vera deeplink 
 Put the following code to Main Activity 

```xml   
    <intent-filter android:autoVerify="true">
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data android:scheme="http" />
                <data android:scheme="https" />
                <data android:host="vera.resonai.com" />
            </intent-filter>
```
