package android.ext;

import android.widget.BaseAdapter;
import android.widget.ListAdapter;

class mq implements Runnable {
    final MainService a;
    private final ListAdapter b;

    mq(MainService mainService0, ListAdapter listAdapter0) {
        this.a = mainService0;
        this.b = listAdapter0;
        super();
    }

    @Override
    public void run() {
        if(this.b instanceof ConfigListAdapter) {
            ((ConfigListAdapter)this.b).a();
        }
        if(this.b instanceof BaseAdapter) {
            try {
                ((BaseAdapter)this.b).notifyDataSetChanged();
            }
            catch(NoSuchMethodError noSuchMethodError0) {
                la.a(noSuchMethodError0);
            }
        }
    }
}

