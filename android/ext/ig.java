package android.ext;

import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class ig {
    public ig(boolean z) {
        if(z) {
            new gr(new ih(this), "FloatCheck").start();
            return;
        }
        this.a();
    }

    private void a(String s) {
        la.a(("FloatCheck: float off by " + s));
        rv.a = false;
    }

    public static void a(boolean z) {
        new qw().a("float-off", z, false).commit();
    }

    void a() {
        SharedPreferences sharedPreferences0 = Tools.s();
        if(sharedPreferences0.contains("float-off")) {
            if(sharedPreferences0.getBoolean("float-off", false)) {
                this.a("pref");
            }
            return;
        }
        this.b();
    }

    private void b() {
        try {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(Tools.a(new String[]{"getprop"}).getInputStream()));
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                if(s.contains("ro.build.remixos.version")) {
                    la.a(("Remix-detect: " + s));
                    if(!s.contains("[2.")) {
                        break;
                    }
                    this.a(s);
                    break;
                }
            }
            bufferedReader0.close();
        }
        catch(Throwable throwable0) {
            la.c("Remix-detect", throwable0);
        }
    }
}

