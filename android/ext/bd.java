package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

class bd implements DialogInterface.OnClickListener {
    final bc a;

    bd(bc bc0) {
        this.a = bc0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            ar.f.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://gameguardian.net/forum/topic/19421-virtual-spaces-to-run-gameguardian-without-root/")));
        }
        catch(Throwable throwable0) {
            la.b("Failed call activity", throwable0);
        }
        new ib(1400).onClick(null, 0);
    }
}

