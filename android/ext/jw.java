package android.ext;

class jw implements Runnable {
    private final String a;

    jw(String s) {
        this.a = s;
        super();
    }

    @Override
    public void run() {
        String s = jp.e == null || jp.e.d == null ? null : jp.e.d.getAbsolutePath();
        i.c(i.a(ar.f).setMessage(qk.a(0x7F070158) + '\n' + this.a + '\n' + s).setPositiveButton(0x7F07009D, new jx(this)).setCancelable(false).create());  // string:no_space "No space left on your device"
    }
}

