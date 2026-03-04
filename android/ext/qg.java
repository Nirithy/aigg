package android.ext;

public class qg {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;

    public qg(int v, String s) {
        this.e = "";
        this.f = false;
        this.g = false;
        this.h = false;
        this.a = v;
        this.c = s;
        this.d = s;
        this.b = v;
    }

    @Override
    public String toString() {
        return "AppInfo [uid=" + this.a + ", pkg=" + this.c + ", name=" + this.d + ", isSystem=" + this.f + ", isGame=" + this.g + ']';
    }
}

