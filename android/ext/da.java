package android.ext;

class da implements Runnable {
    final ConfigListAdapter a;
    private final tp b;

    da(ConfigListAdapter configListAdapter0, tp tp0) {
        this.a = configListAdapter0;
        this.b = tp0;
        super();
    }

    @Override
    public void run() {
        Tools.a(MainService.instance.S, this.b);
    }
}

