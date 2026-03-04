package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import java.io.File;

class ew implements DialogInterface.OnClickListener {
    final ev a;
    private final File b;

    ew(ev ev0, File file0) {
        this.a = ev0;
        this.b = file0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Intent[] arr_intent = jp.a(this.b);
        int v1 = 0;
        while(v1 < arr_intent.length) {
            Intent intent0 = arr_intent[v1];
            try {
                Tools.e().startActivity(intent0);
                return;
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
                ++v1;
            }
        }
    }
}

