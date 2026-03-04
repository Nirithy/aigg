package luaj.lib;

final class MathLib.deg extends MathLib.UnaryOp {
    @Override  // luaj.lib.MathLib$UnaryOp
    protected double a(double f) {
        return Math.toDegrees(f);
    }
}

