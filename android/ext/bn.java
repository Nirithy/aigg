package android.ext;

import android.os.Handler;

class bn implements Runnable {
    final bl a;

    bn(bl bl0) {
        this.a = bl0;
        super();
    }

    @Override
    public void run() {
        this.a.k = -1L;
        this.a.a = i.c().setView(Tools.d(this.a.j)).setCancelable(false).setPositiveButton(0x7F070215, null).setNegativeButton(0x7F0700A1, null).create();  // string:hide "Hide"
        this.a.a("", -1L, 1L, 0, 1, 0L, "");
        i.a(this.a.a, this.a);
        if(MainService.instance.p != null) {
            Handler handler0 = rx.a();
            handler0.removeCallbacks(this.a.n);
            handler0.postDelayed(this.a.n, 100L);
        }
    }
}

