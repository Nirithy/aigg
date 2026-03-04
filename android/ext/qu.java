package android.ext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

class qu implements Callable {
    private final String a;
    private final String b;
    private final StringBuilder c;

    qu(String s, String s1, StringBuilder stringBuilder0) {
        this.a = s;
        this.b = s1;
        this.c = stringBuilder0;
        super();
    }

    public String a() {
        int v;
        la.a(("cmd (" + this.a + ") start"));
        String s = qt.a(this.b);
        la.a(("su (" + s + ") used"));
        Process process0 = s == "" ? Tools.a(new String[]{this.a}) : qt.a(this.a, s, true);
        if(process0 == null) {
            la.c("cmd fail: ");
            return "cmd fail - got null";
        }
        v = Tools.a(process0);
        qt.b = v;
        try(BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(process0.getInputStream()))) {
            String s1;
            while((s1 = bufferedReader0.readLine()) != null) {
                la.a(("cmd (" + this.a + ") out: " + s1));
                this.c.append(s1);
                this.c.append('\n');
            }
        }
        this.c.append("exit code: ");
        int v1 = process0.waitFor();
        this.c.append(v1);
        la.a(("cmd (" + this.a + ") exit: " + process0.exitValue()));
        if(v > 0) {
            try {
                la.a(("Kill at end: " + v));
                android.os.Process.killProcess(v);
                la.a("Kill at end: ok");
            }
            catch(Throwable throwable1) {
                la.a("Failed kill at end", throwable1);
            }
        }
        qt.b = 0;
        return null;
    }

    @Override
    public Object call() {
        return this.a();
    }
}

