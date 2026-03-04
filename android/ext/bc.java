package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class bc implements DialogInterface.OnClickListener {
    final ar a;
    private final Runnable b;

    bc(ar ar0, Runnable runnable0) {
        this.a = ar0;
        this.b = runnable0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        switch(v) {
            case 0: {
                this.b.run();
                return;
            }
            case 1: {
                i.a(i.a(ar.f).setMessage(qk.a(0x7F0702AB)).setCancelable(false).setPositiveButton(qk.a(0x7F07009D), new bd(this)));  // string:how_no_root "You need to install the virtual space application. Such as: 
                                                                                                                                     // __vspace_list__.\n\nIt is recommended to install optimized versions from the official 
                                                                                                                                     // __app_name__ site.\n\nThen you must add __app_name__ and your game to this virtual 
                                                                                                                                     // space.\n\nAfter that you must run the game and __app_name__ in the virtual space."
                ar.r();
                return;
            }
            default: {
                new ib(1500).onClick(null, 0);
            }
        }
    }
}

