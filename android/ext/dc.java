package android.ext;

class dc implements Runnable {
    final db a;
    private final StringBuilder b;

    dc(db db0, StringBuilder stringBuilder0) {
        this.a = db0;
        this.b = stringBuilder0;
        super();
    }

    @Override
    public void run() {
        Tools.a(i.c(i.c().setCustomTitle(Tools.d(0x7F070165)).setMessage(this.b.toString()).setNegativeButton(qk.a(0x7F07009D), null).create()));  // string:change_log "Change log"
    }
}

