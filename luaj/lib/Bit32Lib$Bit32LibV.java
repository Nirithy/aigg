package luaj.lib;

import luaj.ap;

final class Bit32Lib.Bit32LibV extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        switch(this.aj) {
            case 0: {
                return Bit32Lib.b(ap0);
            }
            case 1: {
                return Bit32Lib.c(ap0);
            }
            case 2: {
                return Bit32Lib.d(ap0);
            }
            case 3: {
                return Bit32Lib.e(ap0);
            }
            case 4: {
                return Bit32Lib.f(ap0);
            }
            case 5: {
                return Bit32Lib.a(((int)ap0.p(1)), ((int)ap0.p(2)), ((int)ap0.a(3, 1L)));
            }
            case 6: {
                return Bit32Lib.a(((int)ap0.p(1)), ((int)ap0.p(2)), ((int)ap0.p(3)), ((int)ap0.a(4, 1L)));
            }
            default: {
                return Bit32Lib.Bit32LibV.u;
            }
        }
    }
}

