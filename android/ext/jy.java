package android.ext;

class jy implements Runnable {
    private final Throwable a;

    jy(Throwable throwable0) {
        this.a = throwable0;
        super();
    }

    @Override
    public void run() {
        jz jz0 = new jz(this);
        i.c(i.a(ar.f).setMessage(Tools.c(0x7F0702FC) + ":\n\n" + la.b(this.a)).setPositiveButton(0x7F070156, jz0).setNegativeButton(0x7F07009D, jz0).setCancelable(false).create());  // string:reinstall_fail "Unable to reinstall __app_name__ with random name.\n\n__app_name__ 
                                                                                                                                                                                      // can be easily detected by games.\n\nYou can record __logcat__, during installation, 
                                                                                                                                                                                      // and contact the official forum for help.\n\nRejection reason:"
    }
}

