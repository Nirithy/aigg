package android.ext;

import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.List;

class q implements DialogInterface.OnDismissListener {
    private final List a;

    private q() {
        this.a = new ArrayList();
    }

    q(q q0) {
    }

    public void a(DialogInterface.OnDismissListener dialogInterface$OnDismissListener0) {
        if(dialogInterface$OnDismissListener0 != null && !this.a.contains(dialogInterface$OnDismissListener0)) {
            this.a.add(dialogInterface$OnDismissListener0);
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        i.b();
        for(Object object0: this.a) {
            DialogInterface.OnDismissListener dialogInterface$OnDismissListener0 = (DialogInterface.OnDismissListener)object0;
            if(dialogInterface$OnDismissListener0 != null) {
                dialogInterface$OnDismissListener0.onDismiss(dialogInterface0);
            }
        }
    }
}

