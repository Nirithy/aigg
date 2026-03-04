package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import java.util.List;

class ac implements DialogInterface.OnClickListener {
    final z a;
    private final int b;
    private final List c;

    ac(z z0, int v, List list0) {
        this.a = z0;
        this.b = v;
        this.c = list0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == this.b) {
            ConfigListAdapter.b(0x7F07028A);  // string:help_game_not_listed_title "Why my game is not in the process list?"
            return;
        }
        qh qh0 = (qh)this.c.get(v);
        this.a.a(qh0);
        this.a.a = true;
        Tools.a(dialogInterface0);
        Runnable runnable0 = this.a.b;
        if(runnable0 != null) {
            this.a.b = null;
            runnable0.run();
        }
    }
}

