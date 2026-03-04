package android.ext;

import android.c.a;
import java.util.ArrayList;

class Script.getResults.1 implements Runnable {
    final Script.getResults a;
    private final ArrayList b;
    private final Object c;

    Script.getResults.1(Script.getResults script$getResults0, ArrayList arrayList0, Object object0) {
        this.a = script$getResults0;
        this.b = arrayList0;
        this.c = object0;
        super();
    }

    @Override
    public void run() {
        a a0 = MainService.instance.am;
        ArrayList arrayList0 = this.b;
        int v = 0;
        while(v < a0.b()) {
            try {
                d d0 = a0.a(v, null);
                if(d0 != null) {
                    arrayList0.add(d0);
                }
                ++v;
                continue;
            }
            catch(IndexOutOfBoundsException unused_ex) {
            }
            ++v;
        }
        synchronized(this.c) {
            this.c.notifyAll();
        }
    }
}

