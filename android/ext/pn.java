package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

class pn implements DialogInterface.OnClickListener {
    final pl a;

    pn(pl pl0) {
        this.a = pl0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=0Xxj7Kz7WjQ"));
            this.a.a.startActivity(intent0);
        }
        catch(Throwable throwable0) {
            la.b("Failed call activity", throwable0);
        }
    }
}

