package android.ext;

import java.util.Locale;

class am {
    final String a;
    final int b;
    int c;
    int d;
    int e;

    am(String s) {
        this.d = -1;
        this.e = -1;
        String s1 = s.toUpperCase(Locale.US);
        this.a = s1;
        this.b = s1.length();
        this.a();
    }

    int a(String s) {
        String s1 = this.a;
        int v = this.c;
        int v1 = this.b - v;
        int v2 = -1;
        int v3 = -1;
        if(v1 >= 0) {
            int v4 = s.length();
            int v5 = 0;
            for(int v6 = 0; v5 <= v4; ++v6) {
                int v7 = s.indexOf(0, v5) == -1 ? v4 : s.indexOf(0, v5);
                if(v5 != v7) {
                    String s2 = s.substring(v5, v7);
                    int v8 = s2.length();
                    if(v8 == 0) {
                        if(v3 < 0) {
                            v5 = v7;
                            v3 = 0;
                            v2 = v6;
                        }
                        else {
                            v5 = v7;
                        }
                    }
                    else if(v8 > v1) {
                        v5 = v7;
                    }
                    else {
                        for(int v9 = 0; true; ++v9) {
                            if(v9 >= v8) {
                                if(v3 < v8) {
                                    v5 = v7;
                                    v3 = v8;
                                    v2 = v6;
                                }
                                else {
                                    v5 = v7;
                                }
                                break;
                            }
                            if(s1.charAt(v + v9) != s2.charAt(v9)) {
                                v5 = v7;
                                break;
                            }
                        }
                    }
                }
                ++v5;
            }
        }
        if(v3 > 0) {
            this.c = v + v3;
        }
        return v2;
    }

    int a(String[] arr_s) {
        String s = this.a;
        int v = this.c;
        int v1 = this.b - v;
        int v2 = -1;
        if(v1 >= 0) {
            for(int v3 = arr_s.length - 1; v3 >= 0; --v3) {
                String s1 = arr_s[v3];
                int v4 = s1.length();
                if(v4 == 0) {
                    v2 = v3;
                }
                else if(v4 <= v1) {
                    for(int v5 = 0; true; ++v5) {
                        if(v5 >= v4) {
                            this.c = v + v4;
                            return v3;
                        }
                        if(s.charAt(v + v5) != s1.charAt(v5)) {
                            break;
                        }
                    }
                }
            }
        }
        return v2;
    }

    void a() {
        String s = this.a;
        int v = this.b;
        int v1;
        for(v1 = 0; v1 < v && ai.a(s, v, v1) <= 0x20; ++v1) {
        }
        this.c = v1;
    }

    boolean a(char c) {
        if(this.b() != c) {
            return false;
        }
        ++this.c;
        return true;
    }

    char b() {
        String s = this.a;
        int v = this.c;
        int v1 = this.b;
        char c = ai.a(s, v1, v) == 0 ? ' ' : ai.a(s, v1, v);
        if(v < v1 && c <= 0x20) {
            int v2;
            for(v2 = v; v2 < v1 && ai.a(s, v1, v2 + 1) <= 0x20; ++v2) {
            }
            this.c = v2;
            return ' ';
        }
        return c;
    }

    boolean b(String s) {
        String s1 = this.a;
        int v = this.c;
        int v1 = this.b - v;
        if(v1 >= 0) {
            int v2 = s.length();
            if(v2 == 0) {
                return true;
            }
            if(v2 <= v1) {
                for(int v3 = 0; true; ++v3) {
                    if(v3 >= v2) {
                        this.c = v + v2;
                        return true;
                    }
                    if(s1.charAt(v + v3) != s.charAt(v3)) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    char c() {
        char c = this.b();
        ++this.c;
        return c;
    }

    int d() {
        boolean z;
        int v = 0;
        int v1 = this.c();
        if(v1 == 45) {
            v1 = this.c();
            z = true;
        }
        else {
            z = false;
        }
        if(v1 < 0x30 || v1 > 57) {
            throw ai.f;
        }
        do {
            v = v * 10 + (v1 - 0x30);
            v1 = this.c();
        }
        while(v1 >= 0x30 && v1 <= 57);
        --this.c;
        return z ? -v : v;
    }

    long e() {
        int v = this.c();
        if((v < 0x30 || v > 57) && (v < 65 || v > 70)) {
            throw ai.f;
        }
        long v1 = 0L;
        do {
            v1 = ((long)(v < 0x30 || v > 57 ? v - 55 : v - 0x30)) + (v1 << 4);
            v = this.c();
        }
        while(v >= 0x30 && v <= 57 || v >= 65 && v <= 70);
        --this.c;
        return v1;
    }

    long f() {
        if(this.a('-')) {
            return this.b("0X") ? -this.e() : -((long)this.d());
        }
        return this.b("0X") ? this.e() : ((long)this.d());
    }

    float g() {
        String s = this.a;
        int v = this.c;
        int v1 = s.length();
        if(v >= v1) {
            throw ai.f;
        }
        try {
            float f = Float.parseFloat(s.substring(v, (s.indexOf(59, v) == -1 ? v1 : s.indexOf(59, v))));
            this.c = v1;
            return f;
        }
        catch(NumberFormatException unused_ex) {
            throw ai.f;
        }
    }
}

