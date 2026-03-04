package lasm;

import java.io.Serializable;

public class i implements Serializable {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public String f;
    public i g;
    public i h;

    public i() {
    }

    public i(int v, String s) {
        this.a = v;
        this.f = s;
    }

    public static i a(int v, String s) {
        return new i(v, s);
    }

    @Override
    public String toString() {
        return this.f;
    }
}

