package android.ext;

import android.app.AlertDialog;

class dx implements Runnable {
    final du a;
    private final AlertDialog b;

    dx(du du0, AlertDialog alertDialog0) {
        this.a = du0;
        this.b = alertDialog0;
        super();
    }

    @Override
    public void run() {
        if(MainService.instance != null) {
            MainService.instance.g();
        }
        this.b.hide();
    }
}

