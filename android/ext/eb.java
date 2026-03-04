package android.ext;

import android.app.AlertDialog.Builder;
import android.widget.ListAdapter;
import java.util.List;

class eb implements Runnable {
    private final ListAdapter a;
    private final int b;
    private final List c;

    eb(ListAdapter listAdapter0, int v, List list0) {
        this.a = listAdapter0;
        this.b = v;
        this.c = list0;
        super();
    }

    @Override
    public void run() {
        AlertDialog.Builder alertDialog$Builder0 = i.a(Tools.o()).setCustomTitle(Tools.d(0x7F0700DD));  // string:select_language "Select language"
        ec ec0 = new ec(this, this.c);
        i.a(alertDialog$Builder0.setSingleChoiceItems(this.a, this.b, ec0));
    }
}

