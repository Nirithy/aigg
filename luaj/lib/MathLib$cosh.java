package luaj.lib;

final class MathLib.cosh extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.cosh(f);
    }
}

