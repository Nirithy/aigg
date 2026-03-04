package android.ext;

class nd implements Runnable {
    final MainService a;
    private final long b;

    nd(MainService mainService0, long v) {
        this.a = mainService0;
        this.b = v;
        super();
    }

    @Override
    public void run() {
        if(0xFFFFFFFFFFFFFC00L < this.b && this.b <= 0L) {
            i.c(i.c().setMessage(qk.a(0x7F0702DB) + ' ' + -this.b).setNegativeButton(qk.a(0x7F07009D), null).create());  // string:allocate_fail "Could not allocate memory page. Error"
            return;
        }
        String s = d.b(this.b, 4) + 'h';
        ne ne0 = new ne(this, s);
        iw.a(s, 1);
        i.c(i.c().setMessage(Tools.c(0x7F0702DC) + ": " + s).setPositiveButton(qk.a(0x7F07008D), ne0).setNeutralButton(qk.a(0x7F070161), ne0).setNegativeButton(qk.a(0x7F07009D), null).create());  // string:allocated "Allocated memory page:"
    }
}

