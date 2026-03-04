package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

class bv implements DialogInterface.OnClickListener {
    final bq a;

    bv(bq bq0) {
        this.a = bq0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Intent intent0 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent0.setData(Uri.parse(("package:" + Tools.g())));
        this.a.a.startActivity(intent0);
    }
}

