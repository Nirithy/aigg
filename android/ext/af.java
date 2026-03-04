package android.ext;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class af implements Application.ActivityLifecycleCallbacks {
    final ae a;

    af(ae ae0) {
        this.a = ae0;
        super();
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity0, Bundle bundle0) {
        la.a(("onActivityCreated: " + activity0 + "; " + bundle0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity0) {
        la.a(("onActivityDestroyed: " + activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity0) {
        la.a(("onActivityPaused: " + activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity0) {
        la.a(("onActivityResumed: " + activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        la.a(("onActivitySaveInstanceState: " + activity0 + "; " + bundle0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity0) {
        la.a(("onActivityStarted: " + activity0));
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity0) {
        la.a(("onActivityStopped: " + activity0));
    }
}

