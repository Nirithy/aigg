package android.ext;

class Script.1 implements Runnable {
    final Script a;
    private final Script.SavedState b;

    Script.1(Script script0, Script.SavedState script$SavedState0) {
        this.a = script0;
        this.b = script$SavedState0;
        super();
    }

    @Override
    public void run() {
        Config.a(0x7F0B0081).d = this.b.a;  // id:config_ranges
        Config.c();
    }
}

