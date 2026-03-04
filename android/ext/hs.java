package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class hs implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        String s;
        try {
            s = Tools.e().getFilesDir().getAbsolutePath();
        }
        catch(Throwable throwable0) {
            s = "error";
            la.b("Failed get files dir", throwable0);
        }
        ConfigListAdapter.a(s);
    }
}

