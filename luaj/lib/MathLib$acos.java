package luaj.lib;

final class MathLib.acos extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.acos(f);
    }
}

