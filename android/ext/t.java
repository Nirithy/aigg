package android.ext;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

class t implements AdapterView.OnItemClickListener {
    final AdapterView.OnItemClickListener a;
    final AlertDialog b;

    private t(AlertDialog alertDialog0, AdapterView.OnItemClickListener adapterView$OnItemClickListener0) {
        this.a = adapterView$OnItemClickListener0;
        this.b = alertDialog0;
    }

    t(AlertDialog alertDialog0, AdapterView.OnItemClickListener adapterView$OnItemClickListener0, t t0) {
        this(alertDialog0, adapterView$OnItemClickListener0);
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        try {
            this.a.onItemClick(adapterView0, view0, v, v1);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            Tools.a(this.b);
        }
    }
}

