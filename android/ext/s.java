package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.List;

class s implements DialogInterface.OnShowListener {
    private final List a;

    private s() {
        this.a = new ArrayList();
    }

    s(s s0) {
    }

    public void a(DialogInterface.OnShowListener dialogInterface$OnShowListener0) {
        if(dialogInterface$OnShowListener0 != null && !this.a.contains(dialogInterface$OnShowListener0)) {
            this.a.add(dialogInterface$OnShowListener0);
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.c(((AlertDialog)dialogInterface0));
        for(Object object0: this.a) {
            DialogInterface.OnShowListener dialogInterface$OnShowListener0 = (DialogInterface.OnShowListener)object0;
            if(dialogInterface$OnShowListener0 != null) {
                dialogInterface$OnShowListener0.onShow(dialogInterface0);
            }
        }
    }
}

