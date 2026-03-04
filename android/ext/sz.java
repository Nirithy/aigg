package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.widget.TextView;

class sz implements DialogInterface.OnClickListener {
    final sy a;
    private final TextView b;

    sz(sy sy0, TextView textView0) {
        this.a = sy0;
        this.b = textView0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Tools.a(this.b.getText().toString().trim(), false);
    }
}

