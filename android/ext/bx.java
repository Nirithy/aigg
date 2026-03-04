package android.ext;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

class bx implements DialogInterface.OnClickListener {
    private final Activity a;

    bx(Activity activity0) {
        this.a = activity0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            Intent intent0 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent0.setData(Uri.parse(("package:" + Tools.g())));
            this.a.startActivityForResult(intent0, 0);
        }
        catch(Throwable throwable0) {
            la.c("Failed call intent", throwable0);
        }
    }
}

