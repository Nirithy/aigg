package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ne implements DialogInterface.OnClickListener {
    final nd a;
    private final String b;

    ne(nd nd0, String s) {
        this.a = nd0;
        this.b = s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        switch(v) {
            case -3: {
                Tools.a(this.b);
                return;
            }
            case -1: {
                MainService mainService0 = MainService.instance;
                String s = Tools.c(0x7F0702DC);  // string:allocated "Allocated memory page:"
                mainService0.a(null, this.b, s);
            }
        }
    }
}

