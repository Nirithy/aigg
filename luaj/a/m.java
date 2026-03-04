package luaj.a;

import luaj.LuaString;

class m {
    LuaString a;
    int b;
    int c;
    short d;

    public m(LuaString luaString0, int v, int v1, short v2) {
        this.a = luaString0;
        this.b = v;
        this.c = v1;
        this.d = v2;
    }

    @Override
    public String toString() {
        return "Labeldesc [name=" + this.a + ", pc=" + this.b + ", line=" + this.c + ", nactvar=" + ((int)this.d) + ']';
    }
}

