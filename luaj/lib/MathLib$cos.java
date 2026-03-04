package luaj.lib;

final class MathLib.cos extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.cos(f);
    }
}

