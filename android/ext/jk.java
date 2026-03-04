package android.ext;

class jk implements Runnable {
    final HotPoint a;
    private final int b;

    jk(HotPoint hotPoint0, int v) {
        this.a = hotPoint0;
        this.b = v;
        super();
    }

    @Override
    public void run() {
        int v = 8;
        if(this.b != -1) {
            v = this.b;
        }
        else if(this.a.n.getVisibility() == 8) {
            v = 0;
        }
        this.a.n.setVisibility(v);
        this.a.o.setVisibility(v);
        this.a.setSpeedPanelVisibility(true);
        this.a.c();
        if(v == 0 && this.a.e >= 0) {
            this.a.a(true);
        }
    }
}

