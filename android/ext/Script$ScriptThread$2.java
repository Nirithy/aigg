package android.ext;

import android.content.DialogInterface.OnClickListener;

class Script.ScriptThread.2 implements Runnable {
    final Script.ScriptThread a;
    private final String b;
    private final int c;
    private final String d;
    private final DialogInterface.OnClickListener e;

    Script.ScriptThread.2(Script.ScriptThread script$ScriptThread0, String s, int v, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.a = script$ScriptThread0;
        this.b = s;
        this.c = v;
        this.d = s1;
        this.e = dialogInterface$OnClickListener0;
        super();
    }

    @Override
    public void run() {
        Tools.a(this.b, this.c, this.d, this.e);
    }
}

