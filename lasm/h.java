package lasm;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class h {
    int a;
    int b;
    int c;
    public int d;
    protected int[] e;
    protected int[] f;
    protected int g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected Reader k;
    protected char[] l;
    protected int m;
    protected int n;
    protected int o;

    public h(InputStream inputStream0, String s, int v, int v1) {
        this(inputStream0, s, v, v1, 0x1000);
    }

    public h(InputStream inputStream0, String s, int v, int v1, int v2) {
        this((s == null ? new InputStreamReader(inputStream0) : new InputStreamReader(inputStream0, s)), v, v1, v2);
    }

    public h(Reader reader0, int v, int v1, int v2) {
        this.d = -1;
        this.i = false;
        this.j = false;
        this.m = 0;
        this.n = 0;
        this.o = 8;
        this.k = reader0;
        this.h = v;
        this.g = v1 - 1;
        this.a = v2;
        this.b = v2;
        this.l = new char[v2];
        this.e = new int[v2];
        this.f = new int[v2];
    }

    protected void a() {
        if(this.m == this.b) {
            if(this.b != this.a) {
                if(this.b > this.c) {
                    this.b = this.a;
                }
                else if(this.c - this.b < 0x800) {
                    this.a(true);
                }
                else {
                    this.b = this.c;
                }
            }
            else if(this.c > 0x800) {
                this.m = 0;
                this.d = 0;
                this.b = this.c;
            }
            else if(this.c < 0) {
                this.m = 0;
                this.d = 0;
            }
            else {
                this.a(false);
            }
        }
        try {
            int v = this.k.read(this.l, this.m, this.b - this.m);
            if(v == -1) {
                this.k.close();
                throw new IOException();
            }
            this.m = v + this.m;
        }
        catch(IOException iOException0) {
            --this.d;
            this.a(0);
            if(this.c == -1) {
                this.c = this.d;
            }
            throw iOException0;
        }
    }

    protected void a(char c) {
        ++this.g;
        if(this.j) {
            this.j = false;
            this.g = 1;
            ++this.h;
        }
        else if(this.i) {
            this.i = false;
            if(c == 10) {
                this.j = true;
            }
            else {
                this.g = 1;
                ++this.h;
            }
        }
        switch(c) {
            case 9: {
                this.g += this.o - this.g % this.o;
                break;
            }
            case 10: {
                this.j = true;
                break;
            }
            case 13: {
                this.i = true;
            }
        }
        this.e[this.d] = this.h;
        this.f[this.d] = this.g;
    }

    public void a(int v) {
        this.n += v;
        int v1 = this.d - v;
        this.d = v1;
        if(v1 < 0) {
            this.d += this.a;
        }
    }

    protected void a(boolean z) {
        char[] arr_c = new char[this.a + 0x800];
        int[] arr_v = new int[this.a + 0x800];
        int[] arr_v1 = new int[this.a + 0x800];
        try {
            if(z) {
                System.arraycopy(this.l, this.c, arr_c, 0, this.a - this.c);
                System.arraycopy(this.l, 0, arr_c, this.a - this.c, this.d);
                this.l = arr_c;
                System.arraycopy(this.e, this.c, arr_v, 0, this.a - this.c);
                System.arraycopy(this.e, 0, arr_v, this.a - this.c, this.d);
                this.e = arr_v;
                System.arraycopy(this.f, this.c, arr_v1, 0, this.a - this.c);
                System.arraycopy(this.f, 0, arr_v1, this.a - this.c, this.d);
                this.f = arr_v1;
                int v = this.d + (this.a - this.c);
                this.d = v;
                this.m = v;
            }
            else {
                System.arraycopy(this.l, this.c, arr_c, 0, this.a - this.c);
                this.l = arr_c;
                System.arraycopy(this.e, this.c, arr_v, 0, this.a - this.c);
                this.e = arr_v;
                System.arraycopy(this.f, this.c, arr_v1, 0, this.a - this.c);
                this.f = arr_v1;
                int v1 = this.d - this.c;
                this.d = v1;
                this.m = v1;
            }
        }
        catch(Throwable throwable0) {
            throw new Error(throwable0.getMessage());
        }
        this.a += 0x800;
        this.b = this.a;
        this.c = 0;
    }

    public char b() {
        this.c = -1;
        char c = this.c();
        this.c = this.d;
        return c;
    }

    public char c() {
        if(this.n > 0) {
            --this.n;
            int v = this.d + 1;
            this.d = v;
            if(v == this.a) {
                this.d = 0;
            }
            return this.l[this.d];
        }
        int v1 = this.d + 1;
        this.d = v1;
        if(v1 >= this.m) {
            this.a();
        }
        char c = this.l[this.d];
        this.a(c);
        return c;
    }

    public int d() {
        return this.f[this.d];
    }

    public int e() {
        return this.e[this.d];
    }

    public int f() {
        return this.f[this.c];
    }

    public int g() {
        return this.e[this.c];
    }

    public String h() {
        return this.d < this.c ? new String(this.l, this.c, this.a - this.c) + new String(this.l, 0, this.d + 1) : new String(this.l, this.c, this.d - this.c + 1);
    }
}

