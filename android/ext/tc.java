package android.ext;

import android.widget.ListView;

class tc implements Runnable {
    private final ListView a;
    private final int b;
    private final int c;

    tc(ListView listView0, int v, int v1) {
        this.a = listView0;
        this.b = v;
        this.c = v1;
        super();
    }

    @Override
    public void run() {
        this.a.setSelectionFromTop(this.b, this.c);
    }
}

