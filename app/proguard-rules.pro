-optimizationpasses 5
-optimizations !code/simplification/arithmetic,!field/*,!class/merging*/
-allowaccessmodification
-repackageclasses ''

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application

-keep public class org.apache.commons.io.**myleadsanalytics
-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}


-keep class com.test.assignment.repositories.**{*;}
-keep class com.test.assignment.models.**{*;}

##---------------Begin: proguard configuration for Gson ----------
-keepattributes *Annotation*,Signature
-keep class com.test.assignment.ActivityMonitor.ClassMultiPoints.** { *; }
-keep public class com.test.assignment.ActivityMonitor$ClassMultiPoints     { public protected *; }
-keep public class com.test.assignment.ActivityMonitor$ClassMultiPoints$ClassPoints { public protected *; }
-keep public class com.test.assignment.ActivityMonitor$ClassMultiPoints$ClassPoints$ClassPoint { public protected *; }
# To support Enum type of class members
-keepclassmembers enum * { *; }
-keep class net.sqlcipher.** {
*;
}
-keep class net.sqlcipher.database.** {
*;
}


# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
     @retrofit2.https.* <methods>;
}

