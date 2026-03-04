package android.ext;

import java.io.IOException;

class lc implements Runnable {
    @Override
    public void run() {
        la.a = true;
        if(la.b == null) {
            return;
        }
        try {
            la.b.flush();
            la.b.close();
            la.b = null;
        }
        catch(IOException iOException0) {
            lg.a("AndroidService", "Log close: I/O", iOException0);
        }
    }
}

