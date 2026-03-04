package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import java.util.List;

class ec implements DialogInterface.OnClickListener {
    final eb a;
    private final List b;

    ec(eb eb0, List list0) {
        this.a = eb0;
        this.b = list0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            ad.c(((String)this.b.get(v)));
            ConfigListAdapter.c();
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.c(("Failed get locale for index: " + v), indexOutOfBoundsException0);
        }
        Tools.a(dialogInterface0);
    }
}

