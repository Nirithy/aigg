package android.ext;

class mi implements Runnable {
    final MainService a;

    mi(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.e = this.a.a("script-interrupt", 0, 0, 0x7F070219, 0x7F02004E);  // string:interrupt "Interrupt"
        this.a.f = null;
        this.a.Z.b();
    }
}

