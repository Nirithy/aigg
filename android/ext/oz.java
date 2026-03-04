package android.ext;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface;

class oz implements DialogInterface.OnMultiChoiceClickListener {
    final ow a;
    private final boolean[] b;

    oz(ow ow0, boolean[] arr_z) {
        this.a = ow0;
        this.b = arr_z;
        super();
    }

    @Override  // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface0, int v, boolean z) {
        this.b[v] = z;
    }
}

