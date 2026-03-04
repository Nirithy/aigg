package luaj.lib;

final class MathLib.floor extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.floor(f);
    }
}

