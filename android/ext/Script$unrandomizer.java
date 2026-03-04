package android.ext;

import luaj.ap;

final class Script.unrandomizer extends Script.BusyApiFunction {
    final Script e;

    Script.unrandomizer(Script script0) {
        this.e = script0;
        super(script0);
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.unrandomizer([long qword = nil [, long qincr = nil [, double double_ = nil [, double dincr = nil]]]]) -> true || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        int v = ap0.f(1) && ap0.f(2) ? 0 : 2;
        int v1 = ap0.f(2) && ap0.f(3) ? v : v | 4;
        MainService.instance.k.a(this.e.a(), v1, ap0.a(1, 0L), ap0.a(2, 0L), ap0.a(3, 0.0), ap0.a(4, 0.0));
        return null;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 4;
    }
}

