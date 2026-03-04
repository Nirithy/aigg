package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;

class kd implements DialogInterface.OnClickListener {
    final kc a;
    private final int b;
    private final Intent[] c;

    kd(kc kc0, int v, Intent[] arr_intent) {
        this.a = kc0;
        this.b = v;
        this.c = arr_intent;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        int v1 = -1;
        switch(v) {
            case -2: {
                jp.g.g &= ~this.b;
                break;
            }
            case -1: {
                int v2 = this.b == 1 ? jp.l % this.c.length : 0;
                Intent[] arr_intent = this.c;
                for(int v3 = 0; v3 < arr_intent.length; ++v3) {
                    Intent intent0 = arr_intent[v3];
                    ++v1;
                    if(v1 >= v2) {
                        try {
                            if(this.b == 1) {
                                ++jp.l;
                            }
                            ar.d.startActivityForResult(intent0, this.b);
                            break;
                        }
                        catch(Throwable throwable0) {
                            la.c("intent fail", throwable0);
                        }
                    }
                }
            }
        }
        jp.e.f = null;
    }
}

