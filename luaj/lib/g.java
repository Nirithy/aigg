package luaj.lib;

import luaj.LuaFunction;
import luaj.al;

class g {
    String a;
    String b;
    String c;
    String d;
    int e;
    int f;
    int g;
    short h;
    short i;
    boolean j;
    boolean k;
    String l;
    e m;

    public void a(LuaFunction luaFunction0) {
        if(luaFunction0.j()) {
            al al0 = luaFunction0.k().a;
            this.d = al0.w == null ? "=?" : al0.w.d_();
            this.f = al0.x;
            this.g = al0.y;
            this.c = this.f == 0 ? "main" : "Lua";
            this.l = "null";
            return;
        }
        this.d = "=[Java]";
        this.f = -1;
        this.g = -1;
        this.c = "Java";
        this.l = "[Java]";
    }

    @Override
    public String toString() {
        return "DebugInfo [\n\tname=" + this.a + "\n\tnamewhat=" + this.b + "\n\twhat=" + this.c + "\n\tsource=" + this.d + "\n\tcurrentline=" + this.e + "\n\tlinedefined=" + this.f + "\n\tlastlinedefined=" + this.g + "\n\tnups=" + ((int)this.h) + "\n\tnparams=" + ((int)this.i) + "\n\tisvararg=" + this.j + "\n\tistailcall=" + this.k + "\n\tshort_src=" + this.l + "\n\tcf=" + this.m + "\n]";
    }
}

