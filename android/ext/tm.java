package android.ext;

import android.os.Handler;
import android.os.Message;

public class tm extends Handler {
    final Handler a;

    public tm(Handler handler0) {
        super(handler0.getLooper());
        this.a = handler0;
    }

    public static Handler a(Handler handler0) {
        return !(handler0 instanceof tm) ? new tm(handler0) : handler0;
    }

    @Override  // android.os.Handler
    public void handleMessage(Message message0) {
        try {
            this.a.handleMessage(message0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

