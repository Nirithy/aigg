package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.view.View;

public class be implements DialogInterface.OnClickListener, View.OnClickListener {
    private String a;

    public be(String s) {
        if(s == null) {
            s = "kwws=22jdphjxdugldq1qhw2grzqordg";
        }
        this.a = s;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            Tools.e().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Tools.removeNewLinesChars(this.a))));
            i.d();
        }
        catch(Throwable throwable0) {
            la.b("Failed call activity", throwable0);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        this.onClick(null, 0);
    }
}

