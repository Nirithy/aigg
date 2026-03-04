package android.ext;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.fix.d;

class nb implements ComponentCallbacks {
    @Override  // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration0) {
        la.a(("ComponentCallbacks onConfigurationChanged: " + configuration0));
        MainService.a(d.a(configuration0));
    }

    @Override  // android.content.ComponentCallbacks
    public void onLowMemory() {
        la.a("ComponentCallbacks onLowMemory");
        MainService.b(-1);
    }
}

