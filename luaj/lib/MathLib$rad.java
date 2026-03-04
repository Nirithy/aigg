package luaj.lib;

final class MathLib.rad extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.toRadians(f);
    }
}

