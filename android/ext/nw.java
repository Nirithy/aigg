package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class nw implements DialogInterface.OnClickListener {
    final MainService a;
    private final String b;

    nw(MainService mainService0, String s) {
        this.a = mainService0;
        this.b = s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        i.a(i.c().setMessage(qk.a(0x7F07033D)).setPositiveButton(qk.a(0x7F07009B), new nx(this, this.b)).setNeutralButton(qk.a(0x7F070223), new be("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh278:0krz0wr0uhsodfh0dup0oleudulhv0zlwk0{;90oleudulhv0{0soruh2")).setNegativeButton(qk.a(0x7F07009C), null));  // string:try_reinstall_x86 "Try reinstalling the game with x86 libraries?\n\nThe game 
                                                                                                                                                                                                                                                                                                             // may stop working after that. If this happens, reinstall the game from the apk located 
                                                                                                                                                                                                                                                                                                             // in __data_app__."
    }
}

