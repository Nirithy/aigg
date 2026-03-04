package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.widget.CheckBox;

class if implements DialogInterface.OnClickListener {
    final id a;
    private final CheckBox b;

    if(id id0, CheckBox checkBox0) {
        this.a = id0;
        this.b = checkBox0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.b.setChecked(true);
    }
}

