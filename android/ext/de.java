package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class de implements DialogInterface.OnClickListener {
    final ConfigListAdapter a;

    de(ConfigListAdapter configListAdapter0) {
        this.a = configListAdapter0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        ConfigListAdapter.a(v);
    }
}

