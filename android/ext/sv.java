package android.ext;

import android.content.DialogInterface;

class sv implements Runnable {
    private final DialogInterface a;

    sv(DialogInterface dialogInterface0) {
        this.a = dialogInterface0;
        super();
    }

    @Override
    public void run() {
        try {
            this.a.dismiss();
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

