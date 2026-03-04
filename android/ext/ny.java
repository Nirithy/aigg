package android.ext;

class ny implements Runnable {
    final nx a;
    private final String b;

    ny(nx nx0, String s) {
        this.a = nx0;
        this.b = s;
        super();
    }

    @Override
    public void run() {
        String s;
        try {
            Process process0 = qt.b(("exec pm install -r --abi x86 " + this.b));
            if(process0 == null) {
                s = qk.a(0x7F07033F) + "\nnull";  // string:reinstall_failed "Reinstallation failed:"
            }
            else {
                int v = process0.waitFor();
                s = v == 0 ? qk.a(0x7F070340) : qk.a(0x7F07033F) + "\ncode: " + v;  // string:reinstall_ended "Reinstallation completed."
            }
        }
        catch(InterruptedException interruptedException0) {
            la.a("Reinstall failed", interruptedException0);
            s = qk.a(0x7F07033F) + "\n" + interruptedException0.getMessage();  // string:reinstall_failed "Reinstallation failed:"
        }
        Tools.a(s, 1);
    }
}

