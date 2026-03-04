package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;

class nl implements DialogInterface.OnClickListener {
    final MainService a;
    private final String b;
    private final boolean c;

    nl(MainService mainService0, String s, boolean z) {
        this.a = mainService0;
        this.b = s;
        this.c = z;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        boolean z;
        int v1 = 0;
        this.a.as = false;
        switch(v) {
            case 0: {
                new ib(1100).onClick(dialogInterface0, 0);
                break;
            }
            case 1: {
                la.a(("Restart: " + this.b));
                try {
                    Intent intent0 = Tools.m().getLaunchIntentForPackage(this.b);
                    if(intent0 == null) {
                        intent0 = new Intent("android.intent.action.MAIN");
                        intent0.setPackage(this.b);
                    }
                    intent0.setFlags(0x10000000);
                    Tools.e().startActivity(intent0);
                    z = true;
                }
                catch(Exception exception0) {
                    la.c(("Failed restart app: " + this.b), exception0);
                    z = false;
                }
                Handler handler0 = rx.a();
                nm nm0 = new nm(this, this.b);
                if(z) {
                    v1 = 4000;
                }
                handler0.postDelayed(nm0, ((long)v1));
                break;
            }
            case 2: {
                if(lh.a(null, new nn(this, this.b, this.c))) {
                    i.a(i.c().setCustomTitle(Tools.d(0x7F070047)).setMessage(qk.a(0x7F070281)).setNegativeButton(qk.a(0x7F0700A1), null).setPositiveButton(qk.a(0x7F07009D), new no(this, this.b, this.c)));  // string:restart_game_without_protection "__restart_game__ (__without_protection__)"
                }
                break;
            }
            case 3: {
                ConfigListAdapter.b(0x7F07026E);  // string:help_games_protection_title "How to get around protection in games"
                this.a.j.a();
                break;
            }
            default: {
                this.a.j.a();
            }
        }
        Tools.a(dialogInterface0);
    }
}

