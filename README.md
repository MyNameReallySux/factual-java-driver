This is the Factual-supported Java driver for [Factual's public API](http://developer.factual.com) on Android.
    
# Usage

For a description of all the features available in the driver, please refer to the 
[Non-Android Java driver](https://github.com/Factual/factual-java-driver) documentation.  For a sample Android project using the Java driver, refer to [Factual Android SDK Demo](https://github.com/Factual/factual-android-sdk-demo)
Note if using Maven that the version for Android is as follows:

    <dependency>
      <groupId>com.factual</groupId>
      <artifactId>factual-java-driver</artifactId>
      <version>1.8.1-android</version>
    </dependency>

* [Query Filters](https://github.com/Factual/factual-java-driver/wiki/Query-Filters)
* [Field Selection](https://github.com/Factual/factual-java-driver/wiki/Field-Selection)
* [Row Filters](https://github.com/Factual/factual-java-driver/wiki/Row-Filters)
* [Geo Filters](https://github.com/Factual/factual-java-driver/wiki/Geo-Filters)
* [Paging: Limit and Offset](https://github.com/Factual/factual-java-driver/wiki/Paging)
* [Sorting Results](https://github.com/Factual/factual-java-driver/wiki/Sorting-Results)

* Ensure your application's AndroidManifest.xml has Internet access enabled: 

	<uses-permission android:name="android.permission.INTERNET" />

* Perform Factual requests using the Android AsyncTask to prevent errors related to blocking of the main thread.

# Where to Get Help

If you think you've identified a specific bug in this driver, please file an issue in the github repo. Please be as specific as you can, including:

  * What you did to surface the bug
  * What you expected to happen
  * What actually happened
  * Detailed stack trace and/or line numbers

If you are having any other kind of issue, such as unexpected data or strange behaviour from Factual's API (or you're just not sure WHAT'S going on), please contact us through [GetSatisfaction](http://support.factual.com/factual).
