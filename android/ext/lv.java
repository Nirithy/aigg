package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class lv implements DialogInterface.OnClickListener {
    private final Runnable a;

    lv(Runnable runnable0) {
        this.a = runnable0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        switch(v) {
            case 1: {
                jp.a = 1;
                break;
            }
            case 2: {
                jp.a = 2;
            }
        }
        this.a.run();
    }
}

