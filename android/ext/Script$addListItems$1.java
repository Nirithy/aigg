package android.ext;

import luaj.LuaValue;

class Script.addListItems.1 implements Runnable {
    final Script.addListItems a;
    private final Object b;

    Script.addListItems.1(Script.addListItems script$addListItems0, Object object0) {
        this.a = script$addListItems0;
        this.b = object0;
        super();
    }

    @Override
    public void run() {
        try {
            SavedListAdapter savedListAdapter0 = MainService.instance.an;
            for(Object object0: this.a.d) {
                qx qx0 = (qx)object0;
                if(qx0 != null) {
                    savedListAdapter0.a(qx0, 0, false);
                }
            }
            savedListAdapter0.notifyDataSetChanged();
            savedListAdapter0.d();
            this.a.e = LuaValue.v;
        }
        catch(Throwable throwable0) {
            la.c("Failed add list items", throwable0);
            this.a.e = LuaValue.m(Script.a(throwable0));
        }
        synchronized(this.b) {
            this.b.notifyAll();
        }
    }
}

