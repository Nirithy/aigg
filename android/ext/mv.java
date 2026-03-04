package android.ext;

import android.database.DataSetObserver;

class mv extends DataSetObserver {
    final MainService a;

    mv(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.a.v();
    }

    @Override  // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.a.v();
    }
}

