package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

class at implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            ar.f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://support.google.com/android/answer/6088895")));
        }
        catch(Throwable throwable0) {
            la.b("Failed call activity", throwable0);
        }
    }
}

