package android.ext;

import android.view.View;
import android.widget.Toast;

class sh implements Runnable {
    final sg a;

    sh(sg sg0) {
        this.a = sg0;
        super();
    }

    @Override
    public void run() {
        try {
            Toast toast0 = Toast.makeText(sf.b(), " ", 1);
            View view0 = toast0.getView();
            view0.setBackgroundColor(0);
            toast0.setView(view0);
            sf.f(toast0).show();
            Object object0 = sf.b;
            synchronized(object0) {
                sf.a = toast0;
            }
        }
        catch(Throwable throwable0) {
            la.b("Toast show", throwable0);
        }
    }
}

