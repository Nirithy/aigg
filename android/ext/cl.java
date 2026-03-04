package android.ext;

import android.content.DialogInterface;

class cl extends cz {
    cl(int v, int v1, int[] arr_v, int v2, String s, boolean z, int v3) {
        super(v, v1, arr_v, v2, s, z, v3);
    }

    @Override  // android.ext.cz
    public boolean a(DialogInterface dialogInterface0, int v) {
        boolean z = super.a(dialogInterface0, v);
        if(z && this.d == 3) {
            i.a(i.a(Tools.e()).setMessage(qk.a(0x7F070330)).setNegativeButton(0x7F07009D, null));  // string:help_faq_33_a "Using the third level \"__prevent_unload__\" on some firmware 
                                                                                                   // leads to the fact that text messages (toasts) remain on the screen, or a dark circle 
                                                                                                   // is visible (empty message). If this happens, do not use the third level."
        }
        return z;
    }
}

