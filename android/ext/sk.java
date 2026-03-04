package android.ext;

import android.view.View;
import android.view.WindowManager.LayoutParams;

class sk implements Runnable {
    private final WindowManager.LayoutParams a;
    private final View b;

    sk(WindowManager.LayoutParams windowManager$LayoutParams0, View view0) {
        this.a = windowManager$LayoutParams0;
        this.b = view0;
        super();
    }

    @Override
    public void run() {
        Tools.a(this.b);
        Tools.ViewWrapper tools$ViewWrapper0 = new Tools.ViewWrapper(this.b.getContext());
        tools$ViewWrapper0.addView(this.b);
        Tools.b(tools$ViewWrapper0, this.a);
    }
}

