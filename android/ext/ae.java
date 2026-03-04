package android.ext;

import android.app.Application;
import android.os.Build.VERSION;

public class ae extends Application {
    static {
        la.a("Application clinit");
        ho.b();
    }

    public ae() {
        la.a("Application init");
        ho.b();
    }

    @Override  // android.app.Application
    public void onCreate() {
        la.a("Application onCreate");
        super.onCreate();
        try {
            if(Build.VERSION.SDK_INT >= 14) {
                this.registerActivityLifecycleCallbacks(new af(this));
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.app.Application
    public void onLowMemory() {
        la.a("Application onLowMemory");
        super.onLowMemory();
        MainService.b(-1);
    }

    @Override  // android.app.Application
    public void onTerminate() {
        la.a("Application onTerminate");
        super.onTerminate();
    }

    @Override  // android.app.Application
    public void onTrimMemory(int v) {
        la.a(("Application onTrimMemory: " + v));
        super.onTrimMemory(v);
        MainService.b(v);
    }
}

