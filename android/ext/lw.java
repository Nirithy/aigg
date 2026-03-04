package android.ext;

import android.os.Process;

class lw implements Runnable {
    @Override
    public void run() {
        int v = 1;
        lh.a(1, null);
        boolean z = jp.a().a;
        ar.d.g = z;
        if(z) {
            boolean z1 = ConfigListAdapter.i();
            la.a(("Install64: " + z1));
            if(z1) {
                lh.b();
                return;
            }
            lh.a();
            return;
        }
        ar.h = false;
        if(lh.d) {
            lh.a(8, null);
            lh.i();
            return;
        }
        boolean z2 = bi.a();
        if(!z2) {
            v = 2;
        }
        lh.a(((byte)v));
        if(!z2) {
            la.a(("Not instr: " + Process.myUid()));
            lh.a(2, Config.z);
            rx.a(new lx(this));
            lh.a(4, null);
            return;
        }
        la.a(("Use instr: " + Process.myUid()));
        lh.a(9, null);
        lh.e();
        lh.i();
    }
}

