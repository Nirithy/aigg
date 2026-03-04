package luaj;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.ext.Tools;
import android.ext.be;
import android.ext.i;
import android.ext.qk;

class g implements Runnable {
    final f a;
    private final j b;

    g(f f0, j j0) {
        this.a = f0;
        this.b = j0;
        super();
    }

    @Override
    public void run() {
        AlertDialog.Builder alertDialog$Builder0 = i.a(Tools.e()).setMessage(this.a.f + "\n\n" + Tools.a(qk.a(0x7F07007E), new Object[]{this.b.a})).setNeutralButton(qk.a(0x7F070164), new be("kwws=22jdphjxdugldq1qhw2iruxp2wrslf2594440elqdu|0vfulswv0zlwk0fruuxswhg0ru0lqydolg0khdghuv2"));  // string:invalid_header "__invalid_header_1__\n\n__s__\n\n__invalid_header_3__\n\n__invalid_header_2__"
        h h0 = new h(this, this.b);
        if(Tools.a.nextBoolean()) {
            alertDialog$Builder0.setPositiveButton(qk.a(0x7F07009B), h0).setNegativeButton(qk.a(0x7F07009C), null);  // string:yes "Yes"
        }
        else {
            alertDialog$Builder0.setNegativeButton(qk.a(0x7F07009B), h0).setPositiveButton(qk.a(0x7F07009C), null);  // string:yes "Yes"
        }
        AlertDialog alertDialog0 = alertDialog$Builder0.create();
        i.a(alertDialog0, new luaj.i(this, this.b));
        i.c(alertDialog0);
    }
}

