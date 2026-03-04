package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class lq implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ConfigListAdapter.b(0x7F0702D6);  // string:help_force_close_title "Unexpected shutdown"
    }
}

