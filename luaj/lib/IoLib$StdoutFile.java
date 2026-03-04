package luaj.lib;

import java.io.PrintStream;
import luaj.LuaString;

final class IoLib.StdoutFile extends IoLib.File {
    final IoLib b;
    private final int c;

    private IoLib.StdoutFile(IoLib ioLib0, int v) {
        this.b = ioLib0;
        super(ioLib0);
        this.c = v;
    }

    IoLib.StdoutFile(IoLib ioLib0, int v, IoLib.StdoutFile ioLib$StdoutFile0) {
        this(ioLib0, v);
    }

    @Override  // luaj.lib.IoLib$File
    public void S() {
        this.ah().flush();
    }

    @Override  // luaj.lib.IoLib$File
    public boolean T() {
        return true;
    }

    @Override  // luaj.lib.IoLib$File
    public void U() {
    }

    @Override  // luaj.lib.IoLib$File
    public boolean V() {
        return false;
    }

    @Override  // luaj.lib.IoLib$File
    public int W() {
        return 0;
    }

    @Override  // luaj.lib.IoLib$File
    public int X() {
        return 0;
    }

    @Override  // luaj.lib.IoLib$File
    public int a(byte[] arr_b, int v, int v1) {
        return 0;
    }

    @Override  // luaj.lib.IoLib$File
    public int af() {
        return 0;
    }

    private final PrintStream ah() {
        return this.c == 2 ? this.b.e.f : this.b.e.e;
    }

    @Override  // luaj.lib.IoLib$File
    public int c(String s, int v) {
        return 0;
    }

    @Override  // luaj.lib.IoLib$File
    public void d(String s, int v) {
    }

    @Override  // luaj.lib.IoLib$File
    public String d_() {
        return "file (" + this.hashCode() + ')';
    }

    @Override  // luaj.lib.IoLib$File
    public void e(LuaString luaString0) {
        this.ah().write(luaString0.b, luaString0.c, luaString0.d);
    }
}

