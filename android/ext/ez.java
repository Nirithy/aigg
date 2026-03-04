package android.ext;

import java.io.IOException;

class ez implements Runnable {
    final ey a;
    private final byte[] b;

    ez(ey ey0, byte[] arr_b) {
        this.a = ey0;
        this.b = arr_b;
        super();
    }

    @Override
    public void run() {
        try {
            this.a.a.a(this.b);
        }
        catch(IOException iOException0) {
            la.c(("Failed process message: " + ((int)this.b[0]) + ' ' + this.b.length), iOException0);
        }
    }
}

