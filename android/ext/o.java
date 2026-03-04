package android.ext;

import android.app.AlertDialog.Builder;

class o implements Runnable {
    private final AlertDialog.Builder a;
    private final EditText b;

    o(AlertDialog.Builder alertDialog$Builder0, EditText editText0) {
        this.a = alertDialog$Builder0;
        this.b = editText0;
        super();
    }

    @Override
    public void run() {
        i.a(this.a.create(), this.b);
    }
}

