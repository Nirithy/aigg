package android.ext;

import android.widget.Toast;

class sm implements Runnable {
    private final String a;
    private final int b;

    sm(String s, int v) {
        this.a = s;
        this.b = v;
        super();
    }

    @Override
    public void run() {
        try {
            sf.a(Toast.makeText(sf.b(), qk.a((this.a == null ? "null" : this.a)), this.b));
        }
        catch(Throwable throwable0) {
            la.b("Toast fail", throwable0);
        }
    }
}

