package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface;
import android.widget.ListView;

class eq implements DialogInterface.OnMultiChoiceClickListener {
    final eo a;
    private final boolean[] b;

    eq(eo eo0, boolean[] arr_z) {
        this.a = eo0;
        this.b = arr_z;
        super();
    }

    @Override  // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface0, int v, boolean z) {
        this.b[v] = z;
        if(z) {
            if(v < 4) {
                v = 0;
            }
            ListView listView0 = ((AlertDialog)dialogInterface0).getListView();
            if(listView0 != null) {
                for(int v1 = 0; v1 < this.b.length; ++v1) {
                    if(v != (v1 < 4 ? 0 : v1)) {
                        this.b[v1] = false;
                        listView0.setItemChecked(v1, false);
                    }
                }
            }
        }
    }
}

