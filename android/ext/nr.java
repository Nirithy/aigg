package android.ext;

class nr implements Runnable {
    final np a;
    private final String b;
    private final String c;

    nr(np np0, String s, String s1) {
        this.a = np0;
        this.b = s;
        this.c = s1;
        super();
    }

    @Override
    public void run() {
        try {
            qt.a((this.b + " \'\'"), 5);
        }
        catch(Throwable throwable0) {
            la.c(("Failed unstub app: " + this.c), throwable0);
        }
    }
}

