package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class as implements DialogInterface.OnClickListener {
    final ar a;

    as(ar ar0) {
        this.a = ar0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        int v1 = 0;
        switch(v) {
            case 0: {
                ig.a(rv.a);
                break;
            }
            case 1: {
                ct ct0 = Config.a(0x7F0B00BA);  // id:selinux
                if((Config.A & 4) == 0) {
                    v1 = 1;
                }
                ct0.d = v1;
                Config.c();
                break;
            }
            case 2: {
                new bq(this.a).b();
                return;
            }
            case 3: {
                Config.a(0x7F0B00BD).d = -1;  // id:config_float_type
                Config.a(0x7F0B00BE).d = -1;  // id:config_float_flags
                Config.c();
                break;
            }
            case 4: {
                ct ct1 = Config.a(0x7F0B009C);  // id:config_use_notification
                if((Config.B & 0x100) == 0) {
                    v1 = 1;
                }
                ct1.d = v1;
                Config.c();
                break;
            }
            case 5: {
                Config.a(0x7F0B009D).d();  // id:config_hot_key
                return;
            }
            case 6: {
                this.a.c();
                return;
            }
            case 7: {
                Config.c = 0L;
                Config.c();
                break;
            }
            case 8: {
                ConfigListAdapter.j();
                return;
            }
            case 9: {
                ar.f();
                return;
            }
            case 10: {
                ar.g();
                return;
            }
            case 11: {
                Config.a(0x7F0B009B).d();  // id:config_prevent_unload
                return;
            }
            case 12: {
                Config.a(0x7F0B00AE).d();  // id:config_acceleration
                return;
            }
            case 13: {
                Config.a(0x7F0B009A).d();  // id:config_vspace_root
                return;
            }
            case 14: {
                Config.a(0x7F0B00B1).d();  // id:config_number_locale
                return;
            }
        }
        ar.h();
    }
}

