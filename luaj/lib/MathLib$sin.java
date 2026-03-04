package luaj.lib;

final class MathLib.sin extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.sin(f);
    }
}

