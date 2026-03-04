package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class lo implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        i.a(i.c().setCustomTitle(Tools.d(0x7F070164)).setItems(new String[]{Config.a(0x7F0B009B).toString(), Config.a(0x7F0B0093).toString()}, new lp(this)).setNegativeButton(qk.a(0x7F0700A1), null));  // string:fix_it "Fix it"
    }
}

