package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class hp implements DialogInterface.OnClickListener {
    private final String a;
    private final String[] b;
    private final int c;
    private final Runnable d;

    hp(String s, String[] arr_s, int v, Runnable runnable0) {
        this.a = s;
        this.b = arr_s;
        this.c = v;
        this.d = runnable0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            uk.a(this.a);
            Tools.a(0x7F0700BC);  // string:thank_you "Thank you!"
        }
        if(v == -3) {
            Tools.h(this.b[this.c + 1]);
        }
        this.d.run();
    }
}

