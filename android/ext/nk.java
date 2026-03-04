package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class nk implements DialogInterface.OnClickListener {
    final MainService a;

    nk(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.d(true);
        ConfigListAdapter.b(0x7F07006D);  // string:help_games_protection_ "__help_games_protection__\t__help_games_protection_9__\n\n__help_games_protection_end__\n 
                                          //    "
    }
}

