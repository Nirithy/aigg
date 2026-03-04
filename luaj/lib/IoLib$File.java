package luaj.lib;

import java.io.EOFException;
import java.io.IOException;
import luaj.LuaString;
import luaj.LuaValue;

public abstract class IoLib.File extends LuaValue {
    final IoLib a;

    protected IoLib.File(IoLib ioLib0) {
        this.a = ioLib0;
        super();
    }

    public abstract void S();

    public abstract boolean T();

    public abstract void U();

    public abstract boolean V();

    public abstract int W();

    public abstract int X();

    public abstract int a(byte[] arg1, int arg2, int arg3);

    public abstract int af();

    public boolean ag() {
        try {
            return this.X() < 0;
        }
        catch(EOFException unused_ex) {
            return true;
        }
    }

    public abstract int c(String arg1, int arg2);

    public abstract void d(String arg1, int arg2);

    @Override  // luaj.LuaValue
    public String d_() {
        return "file: " + Integer.toHexString(this.hashCode());
    }

    public abstract void e(LuaString arg1);

    @Override  // luaj.LuaValue
    public int e_() {
        return 7;
    }

    @Override  // luaj.LuaValue
    public String f_() {
        return "userdata";
    }

    @Override
    public void finalize() {
        if(!this.V()) {
            try {
                this.U();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    @Override  // luaj.LuaValue
    public LuaValue i() {
        return this.a.d;
    }

    @Override  // luaj.LuaValue
    public LuaValue w(LuaValue luaValue0) {
        return this.a.d.w(luaValue0);
    }
}

