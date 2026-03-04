package luaj.lib;

import luaj.ap;

class MathLib.frexp extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        double f = ap0.m(1);
        if(f == 0.0) {
            return MathLib.frexp.b(MathLib.frexp.y, MathLib.frexp.y);
        }
        long v = Double.doubleToLongBits(f);
        return v < 0L ? MathLib.frexp.b(MathLib.frexp.c(-0.0 * ((double)((0xFFFFFFFFFFFFFL & v) + 0x10000000000000L))), MathLib.frexp.c((((int)(v >> 52)) & 0x7FF) - 0x3FE)) : MathLib.frexp.b(MathLib.frexp.c(1.110223E-16 * ((double)((0xFFFFFFFFFFFFFL & v) + 0x10000000000000L))), MathLib.frexp.c((((int)(v >> 52)) & 0x7FF) - 0x3FE));
    }
}

