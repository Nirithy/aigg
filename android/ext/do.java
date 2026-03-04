package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class do implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ConfigListAdapter.g();
    }
}

