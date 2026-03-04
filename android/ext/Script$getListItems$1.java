package android.ext;

import java.util.ArrayList;

class Script.getListItems.1 implements Runnable {
    final Script.getListItems a;
    private final ArrayList b;
    private final Object c;

    Script.getListItems.1(Script.getListItems script$getListItems0, ArrayList arrayList0, Object object0) {
        this.a = script$getListItems0;
        this.b = arrayList0;
        this.c = object0;
        super();
    }

    @Override
    public void run() {
        try {
            SavedListAdapter savedListAdapter0 = MainService.instance.an;
            int v = savedListAdapter0.getCount();
        label_3:
            for(int v1 = 0; v1 < v; ++v1) {
                qx qx0 = savedListAdapter0.b(v1);
                if(qx0 != null) {
                    this.b.add(qx0);
                }
            }
        }
        catch(Throwable throwable0) {
            la.c("Failed get list items", throwable0);
            if(true) {
                goto label_12;
            }
            goto label_3;
        }
    label_12:
        synchronized(this.c) {
            this.c.notifyAll();
        }
    }
}

