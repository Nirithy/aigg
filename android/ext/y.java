package android.ext;

import catch_.me_.if_.you_.can_.MainActivity;

public class y {
    static float a;
    static final String b;
    static final String c;
    static final String d;
    static final String e;

    static {
        String s;
        try {
            y.a = 101.099998f;
            y.b = "catch_.me_.if_.you_.can_";
            y.c = "GameGuardian";
            s = MainActivity.class.getPackage().getName();
        }
        catch(Throwable throwable0) {
            s = "catch_.me_.if_.you_.can_";
            la.a(throwable0);
        }
        y.d = s.intern();
        y.e = "GameGuardian";
    }

    public static final void a() {
    }
}

