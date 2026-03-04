package android.ext;

import android.fix.ScrollView;

class tb implements Runnable {
    final ta a;
    private final ScrollView b;

    tb(ta ta0, ScrollView scrollView0) {
        this.a = ta0;
        this.b = scrollView0;
        super();
    }

    @Override
    public void run() {
        this.b.fullScroll(130);
    }
}

