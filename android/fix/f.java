package android.fix;

import android.content.Context;
import android.content.Intent;
import android.ext.la;

class f implements Runnable {
    private final Context a;
    private final Intent b;

    f(Context context0, Intent intent0) {
        this.a = context0;
        this.b = intent0;
        super();
    }

    @Override
    public void run() {
        try {
            this.a.startActivity(this.b);
        }
        catch(Throwable throwable0) {
            la.b(("Failed startActivity from UI thread: " + this.b), throwable0);
        }
    }
}

