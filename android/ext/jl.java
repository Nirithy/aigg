package android.ext;

import android.graphics.drawable.Drawable;

class jl implements Runnable {
    final HotPoint a;
    private final Drawable b;

    jl(HotPoint hotPoint0, Drawable drawable0) {
        this.a = hotPoint0;
        this.b = drawable0;
        super();
    }

    @Override
    public void run() {
        Tools.a(this.a.m, this.b, 24 - this.a.f);
    }
}

