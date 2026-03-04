package android.ext;

class mj implements Runnable {
    final MainService a;
    private final boolean b;

    mj(MainService mainService0, boolean z) {
        this.a = mainService0;
        this.b = z;
        super();
    }

    @Override
    public void run() {
        if(this.b) {
            this.a.g = false;
        }
        this.a.f = this.b ? this.a.a("script-ui-button", 0, 50, 0x7F020051, 0x7F020051) : null;  // drawable:ic_ui_button_24dp
        this.a.Z.b();
    }
}

