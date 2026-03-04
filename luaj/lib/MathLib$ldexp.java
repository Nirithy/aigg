package luaj.lib;

final class MathLib.ldexp extends MathLib.BinaryOp {
    @Override  // luaj.lib.MathLib$BinaryOp
    protected double a(double f, double f1) {
        return Double.longBitsToDouble(((long)f1) + 0x3FFL << 52) * f;
    }
}

