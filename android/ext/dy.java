package android.ext;

import android.app.AlertDialog;

class dy implements Runnable {
    final du a;
    private final AlertDialog b;

    dy(du du0, AlertDialog alertDialog0) {
        this.a = du0;
        this.b = alertDialog0;
        super();
    }

    @Override
    public void run() {
        this.b.show();
    }
}

