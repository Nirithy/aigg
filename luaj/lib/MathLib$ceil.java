package luaj.lib;

final class MathLib.ceil extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.ceil(f);
    }
}

