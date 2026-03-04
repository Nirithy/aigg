package android.ext;

import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.ScrollView;

class ta implements DialogInterface.OnShowListener {
    final sy a;
    private final ScrollView b;

    ta(sy sy0, ScrollView scrollView0) {
        this.a = sy0;
        this.b = scrollView0;
        super();
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        tb tb0 = new tb(this, this.b);
        this.b.postDelayed(tb0, 100L);
    }
}

