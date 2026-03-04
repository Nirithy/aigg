package luaj.lib;

final class MathLib.exp extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.exp(f);
    }
}

