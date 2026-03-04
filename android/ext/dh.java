package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class dh implements DialogInterface.OnClickListener {
    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        MainService mainService0;
        try {
            mainService0 = MainService.instance;
            mainService0.g();
            rx.a().postDelayed(new di(this), 8000L);
            mainService0.g(true);
            mainService0.l.f();
            rx.a().postDelayed(new dj(this), 300L);
        }
        catch(Throwable throwable0) {
            la.c("Failed take screenshot", throwable0);
            try {
                mainService0.l.d();
            }
            catch(Throwable throwable1) {
                la.c("Failed restore after take screenshot", throwable1);
            }
        }
    }
}

