package android.ext;

class mm implements Runnable {
    final MainService a;

    mm(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override
    public void run() {
        this.a.i = this.a.a("record-interrupt", 0, 0, 0x7F0702E4, 0x7F02004E);  // string:record "Record"
        this.a.Z.d();
    }
}

