package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.SharedPreferences;

class lt implements DialogInterface.OnClickListener {
    final lr a;
    private final SharedPreferences b;
    private final String c;

    lt(lr lr0, SharedPreferences sharedPreferences0, String s) {
        this.a = lr0;
        this.b = sharedPreferences0;
        this.c = s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            new be("kwws=22jdphjxdugldq1qhw2iruxp2wrslf2:8770li0|rx0zdqw0wr0dgg0d0qhz0wudqvodwlrq0ru0lpsuryh0dq0h{lvwlqj2").onClick(dialogInterface0, -1);
        }
        this.b.edit().putString("improve-translate", this.c).commit();
    }
}

