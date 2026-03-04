package android.ext;

import android.content.Context;

class mn extends FloatPanel {
    final MainService e;
    private final String f;
    private final int g;
    private final int h;

    mn(MainService mainService0, Context context0, String s, int v, int v1) {
        this.e = mainService0;
        this.f = s;
        this.g = v;
        this.h = v1;
        super(context0);
    }

    @Override  // android.ext.FloatPanel
    protected boolean a() {
        return true;
    }

    @Override  // android.ext.FloatPanel
    protected int getDefX() {
        return this.g;
    }

    @Override  // android.ext.FloatPanel
    protected int getDefY() {
        return this.h;
    }

    @Override  // android.ext.FloatPanel
    protected String getPrefName() {
        return this.f;
    }
}

