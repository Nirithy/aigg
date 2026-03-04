package android.ext;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.fix.d;

class na implements ComponentCallbacks2 {
    @Override  // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration0) {
        la.a(("ComponentCallbacks2 onConfigurationChanged: " + configuration0));
        MainService.a(d.a(configuration0));
    }

    @Override  // android.content.ComponentCallbacks
    public void onLowMemory() {
        la.a("ComponentCallbacks2 onLowMemory");
        MainService.b(-1);
    }

    @Override  // android.content.ComponentCallbacks2
    public void onTrimMemory(int v) {
        la.a(("ComponentCallbacks2 onTrimMemory: " + v));
        MainService.b(v);
    }
}

