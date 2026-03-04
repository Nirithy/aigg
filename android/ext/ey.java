package android.ext;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

class ey extends gr {
    final ex a;

    ey(ex ex0, String s) {
        this.a = ex0;
        super(s);
    }

    private void a(byte[] arr_b) {
        try {
            Exchanger exchanger0 = this.a.f;
            while(true) {
                if(ey.interrupted()) {
                    return;
                }
                try {
                    exchanger0.exchange(arr_b, 500L, TimeUnit.MILLISECONDS);
                    return;
                }
                catch(InterruptedException unused_ex) {
                }
            }
        }
        catch(Throwable throwable0) {
            la.c("handleMemoryItem failed", throwable0);
        }
    }

    private void b(byte[] arr_b) {
        if(arr_b[0] == 20 && arr_b[1] == 0) {
            this.a(arr_b);
            return;
        }
        rx.a().post(new ez(this, arr_b));
    }

    @Override
    public void run() {
        InOut inOut0 = this.a.e;
        try {
            while(true) {
                if(ey.interrupted()) {
                    return;
                }
                byte[] arr_b = inOut0.a();
                ex.k = null;
                if(arr_b != null) {
                    this.b(arr_b);
                }
            }
        }
        catch(Throwable throwable0) {
            la.c("Read error", throwable0);
            ex.k = throwable0.toString();
            rx.a().post(new fa(this));
        }
    }
}

