package android.ext;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface;

class dm implements DialogInterface.OnMultiChoiceClickListener {
    final dk a;
    private final boolean[] b;

    dm(dk dk0, boolean[] arr_z) {
        this.a = dk0;
        this.b = arr_z;
        super();
    }

    @Override  // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface0, int v, boolean z) {
        this.b[v] = z;
    }
}

