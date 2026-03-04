package android.ext;

import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;

class jb implements DialogInterface.OnShowListener {
    final iy a;
    private final EditText b;

    jb(iy iy0, EditText editText0) {
        this.a = iy0;
        this.b = editText0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(this.b);
        this.b.requestFocus();
    }
}

