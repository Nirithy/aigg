package android.ext;

import android.content.DialogInterface.OnClickListener;

class lu implements Runnable {
    final lr a;
    private final DialogInterface.OnClickListener b;

    lu(lr lr0, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a = lr0;
        this.b = dialogInterface$OnClickListener0;
        super();
    }

    @Override
    public void run() {
        i.a(i.c().setMessage(qk.a(0x7F070023)).setPositiveButton(qk.a(0x7F070223), this.b).setNegativeButton(qk.a(0x7F0700B9), this.b));  // string:improve_translation_ "__improve_translation_en__\n\n__improve_translation__"
    }
}

