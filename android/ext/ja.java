package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ja implements DialogInterface.OnClickListener {
    final iy a;
    private final je b;
    private final EditText c;

    ja(iy iy0, je je0, EditText editText0) {
        this.a = iy0;
        this.b = je0;
        this.c = editText0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        String s = this.c.getText().toString();
        this.a.a(this.b, s, true);
    }
}

