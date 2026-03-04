package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class df implements DialogInterface.OnClickListener {
    final ConfigListAdapter a;
    private final MainService b;

    df(ConfigListAdapter configListAdapter0, MainService mainService0) {
        this.a = configListAdapter0;
        this.b = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.b.k.f();
    }
}

