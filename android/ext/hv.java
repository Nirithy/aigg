package android.ext;

import android.os.Looper;
import android.widget.Toast;

class hv extends Thread {
    final ho a;
    private final String b;

    hv(ho ho0, String s, String s1) {
        this.a = ho0;
        this.b = s1;
        super(s);
    }

    @Override
    public void run() {
        try {
            Looper.prepare();
            sf.a(Toast.makeText(sf.b(), this.b, 1));
            Looper.loop();
        }
        catch(Throwable unused_ex) {
        }
    }
}

