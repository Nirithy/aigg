package android.ext;

class dp extends gr {
    final ConfigListAdapter a;

    dp(ConfigListAdapter configListAdapter0, String s) {
        this.a = configListAdapter0;
        super(s);
    }

    @Override
    public void run() {
        Tools.a(("Logcat: " + qk.a(0x7F0700C8)), 0);  // string:loading "Loading..."
        Tools.b(("Thu Mar 05 01:17:10 CST 2026" + '\n' + gs.a(true)), 3);
    }
}

