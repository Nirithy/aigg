package luaj.lib;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import luaj.Globals;
import luaj.LuaString;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.ap;
import luaj.z;

public final class GgLib.saveVariable extends VarArgFunction {
    final Globals a;
    Writer b;
    Map c;
    List d;
    final Integer e;
    static final String[] f;

    static {
        GgLib.saveVariable.f = new String[]{"address", "value", "flags", "name", "freeze", "freezeType", "freezeFrom", "freezeTo"};
    }

    public GgLib.saveVariable(Globals globals0) {
        this.e = 0;
        this.a = globals0;
    }

    private void S() {
        String[] arr_s = GgLib.saveVariable.f;
        this.b.write("local ");
        for(int v = 0; v < arr_s.length; ++v) {
            this.b.write(((int)(((char)(v + 97)))));
            this.b.write(44);
        }
        this.b.write("v,t=");
        for(int v1 = 0; v1 < arr_s.length; ++v1) {
            this.b.write(39);
            this.b.write(arr_s[v1]);
            this.b.write("\',");
        }
        this.b.write("nil\nv={");
        Writer writer0 = this.b;
        Map map0 = this.c;
        int v2 = 0;
        for(Object object0: this.d) {
            ++v2;
            map0.put(((LuaTable)object0), v2);
            writer0.write("{");
            z z0 = ((LuaTable)object0).S();
            int v3 = 1;
            while(z0.a()) {
                int v4 = z0.b();
                if(v4 == 0) {
                    LuaValue luaValue0 = z0.c();
                    if(luaValue0 instanceof LuaTable) {
                        continue;
                    }
                    writer0.write("[");
                    this.a(writer0, arr_s, map0, luaValue0);
                    writer0.write("]=");
                }
                else if(v4 == v3) {
                    ++v3;
                }
                else {
                    writer0.write("[");
                    writer0.write(Integer.toString(v4));
                    writer0.write("]=");
                }
                LuaValue luaValue1 = z0.d();
                if(luaValue1 instanceof LuaTable) {
                    writer0.write("nil");
                }
                else {
                    this.a(writer0, arr_s, map0, luaValue1);
                }
                writer0.write(";");
            }
            writer0.write("};");
        }
        writer0.write("}");
    }

    private void T() {
        LuaValue luaValue1;
        String[] arr_s = GgLib.saveVariable.f;
        Writer writer0 = this.b;
        Map map0 = this.c;
        int v = 0;
        for(Object object0: this.d) {
            ++v;
            z z0 = ((LuaTable)object0).S();
            boolean z1 = true;
            while(z0.a()) {
                int v1 = z0.b();
                LuaValue luaValue0 = z0.d();
                if(luaValue0 instanceof LuaTable) {
                    luaValue1 = v1 == 0 ? z0.c() : null;
                }
                else {
                    if(v1 != 0) {
                        continue;
                    }
                    luaValue1 = z0.c();
                    if(!(luaValue1 instanceof LuaTable)) {
                        continue;
                    }
                }
                if(z1) {
                    writer0.write("\nt=v[");
                    writer0.write(Integer.toString(v));
                    writer0.write(93);
                    z1 = false;
                }
                writer0.write("\nt[");
                if(luaValue1 == null) {
                    writer0.write(Integer.toString(v1));
                }
                else {
                    this.a(writer0, arr_s, map0, luaValue1);
                }
                writer0.write("]=");
                this.a(writer0, arr_s, map0, luaValue0);
            }
        }
    }

    private Appendable a(Appendable appendable0, String s) {
        if(appendable0 == null) {
            appendable0 = new StringBuilder();
        }
        appendable0.append('\'');
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = s.charAt(v1);
            switch(v2) {
                case 7: {
                    appendable0.append('\\');
                    appendable0.append('a');
                    break;
                }
                case 8: {
                    appendable0.append('\\');
                    appendable0.append('b');
                    break;
                }
                case 9: {
                    appendable0.append('\\');
                    appendable0.append('t');
                    break;
                }
                case 10: {
                    appendable0.append('\\');
                    appendable0.append('n');
                    break;
                }
                case 11: {
                    appendable0.append('\\');
                    appendable0.append('v');
                    break;
                }
                case 12: {
                    appendable0.append('\\');
                    appendable0.append('f');
                    break;
                }
                case 13: {
                    appendable0.append('\\');
                    appendable0.append('r');
                    break;
                }
                case 39: 
                case 92: {
                    appendable0.append('\\');
                    appendable0.append(((char)v2));
                    break;
                }
                default: {
                    appendable0.append(((char)v2));
                }
            }
        }
        appendable0.append('\'');
        return appendable0;
    }

    private void a(Writer writer0, String[] arr_s, Map map0, LuaValue luaValue0) {
        if(luaValue0 instanceof LuaTable) {
            writer0.write("v[");
            writer0.write(Integer.toString(((int)(((Integer)map0.get(luaValue0))))));
            writer0.write(93);
            return;
        }
        if(luaValue0 instanceof LuaString) {
            String s = luaValue0.d_();
            for(int v = 0; true; ++v) {
                if(v >= arr_s.length) {
                    this.a(writer0, s);
                    return;
                }
                if(s.equals(arr_s[v])) {
                    writer0.write(v + 97);
                    return;
                }
            }
        }
        writer0.write(luaValue0.d_());
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaValue luaValue0 = ap0.c(1);
        String s = ap0.r(2);
        this.a.a(s);
        try {
            this.b(luaValue0, s);
            return LuaValue.u;
        }
        catch(Throwable throwable0) {
            return LuaValue.m(throwable0.toString());
        }
    }

    private void b(LuaTable luaTable0) {
        if(((Integer)this.c.put(luaTable0, this.e)) == null && luaTable0 instanceof LuaTable) {
            z z0 = luaTable0.S();
            while(z0.a()) {
                for(int v = 0; v < 2; ++v) {
                    LuaValue luaValue0 = v == 0 ? z0.c() : z0.d();
                    if(luaValue0 instanceof LuaTable) {
                        this.b(((LuaTable)luaValue0));
                    }
                }
            }
        }
    }

    private void b(LuaValue luaValue0, String s) {
        try {
            BufferedWriter bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(new i(this, s)), 0x10000);
            this.b = bufferedWriter0;
            if(luaValue0 instanceof LuaTable) {
                this.c = new HashMap();
                this.b(((LuaTable)luaValue0));
                this.d = new ArrayList(this.c.keySet());
                this.S();
                this.T();
                bufferedWriter0.write("\nreturn v[" + this.c.get(luaValue0) + "]\n");
                this.c = null;
            }
            else {
                if(luaValue0 instanceof LuaString) {
                    bufferedWriter0.write("return ");
                    this.a(bufferedWriter0, luaValue0.d_());
                }
                else {
                    bufferedWriter0.write("return ");
                    bufferedWriter0.write(luaValue0.d_());
                }
                bufferedWriter0.write(10);
            }
            bufferedWriter0.close();
            this.b = null;
            this.c = null;
            this.d = null;
        }
        catch(Throwable throwable0) {
            this.b = null;
            this.c = null;
            this.d = null;
            throw throwable0;
        }
    }
}

