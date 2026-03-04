package luaj;

import android.ext.la;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class o extends RuntimeException {
    protected int d;
    protected String e;
    protected String f;
    protected int g;
    protected String h;
    protected Throwable i;
    LuaValue j;
    protected String k;
    public String l;

    public o(String s) {
        super(s);
        this.l = null;
        this.d = 1;
    }

    public o(String s, int v) {
        super(s);
        this.l = null;
        this.d = v;
    }

    public o(String s, int v, String s1) {
        super(s1);
        this.l = null;
        this.d = 1;
        this.f = s;
        this.g = v;
        this.b();
    }

    public o(String s, Throwable throwable0) {
        super(s);
        this.l = null;
        this.i = throwable0;
        this.d = 1;
    }

    public o(Throwable throwable0) {
        super("vm error: " + throwable0);
        this.l = null;
        this.i = throwable0;
        this.d = 1;
    }

    public o(LuaValue luaValue0) {
        super(luaValue0.d_());
        this.l = null;
        this.j = luaValue0;
        this.d = 1;
    }

    private String a(String s) {
        return s == null || s.length() <= 0x7C ? s : s.substring(0, 0x7C) + "...";
    }

    public LuaValue a() {
        if(this.j != null) {
            return this.j;
        }
        String s = this.getMessage();
        return s != null ? LuaValue.m(s) : null;
    }

    public void b() {
        this.e = this.a(this.f) + ":" + this.g;
    }

    private String c() {
        int v = 1;
        if(this.f == null || this.g < 0) {
            return String.valueOf(this.e) + '\n';
        }
        try {
            String s = this.f.length() <= 0 || this.f.charAt(0) != 0x40 ? this.f : this.f.substring(1);
            File file0 = new File(s);
            BufferedInputStream bufferedInputStream0 = file0.exists() ? new BufferedInputStream(new FileInputStream(file0)) : new ByteArrayInputStream(s.getBytes());
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(bufferedInputStream0));
            while(v < this.g && bufferedReader0.readLine() != null) {
                ++v;
            }
            if(v == this.g) {
                String s1 = this.a(bufferedReader0.readLine());
                return String.valueOf(this.e) + '\n' + '`' + s1 + '`';
            }
            return String.valueOf(this.e) + '\n' + '`' + "failed read line" + '`';
        }
        catch(Throwable throwable0) {
            la.c("Failed read source", throwable0);
            return String.valueOf(this.e) + '\n' + '`' + "failed read source" + '`';
        }
    }

    @Override
    public Throwable getCause() {
        return this.i;
    }

    @Override
    public String getMessage() {
        if(this.h != null) {
            return this.l != null && !this.h.startsWith(this.l) ? this.l + this.h : this.h;
        }
        String s = this.k == null ? super.getMessage() : this.k;
        if(s == null) {
            return null;
        }
        if(this.e != null) {
            return this.l != null && !s.startsWith(this.l) ? this.l + this.c() + '\n' + s : "" + this.c() + '\n' + s;
        }
        return this.l != null && !s.startsWith(this.l) ? this.l + s : s;
    }
}

