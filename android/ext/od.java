package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class od implements DialogInterface.OnClickListener {
    final ob a;
    private final String[] b;

    od(ob ob0, String[] arr_s) {
        this.a = ob0;
        this.b = arr_s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Tools.a(this.b[v]);
        Tools.a(dialogInterface0);
    }
}

