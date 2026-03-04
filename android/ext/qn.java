package android.ext;

class qn implements Runnable {
    final qm a;
    private final Throwable b;

    qn(qm qm0, Throwable throwable0) {
        this.a = qm0;
        this.b = throwable0;
        super();
    }

    @Override
    public void run() {
        try {
            i.a(i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(this.a.c + "\n\n" + this.b.toString()).setPositiveButton(qk.a(0x7F07009D), null));  // string:error "Error"
        }
        catch(Throwable throwable0) {
            la.b("Failed show alert", throwable0);
        }
    }
}

