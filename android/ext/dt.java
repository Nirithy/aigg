package android.ext;

import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.view.View.OnClickListener;

class dt implements DialogInterface.OnShowListener {
    private final View.OnClickListener a;

    dt(View.OnClickListener view$OnClickListener0) {
        this.a = view$OnClickListener0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this.a);
    }
}

