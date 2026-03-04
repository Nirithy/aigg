package luaj.lib;

final class MathLib.pow extends MathLib.BinaryOp {
    @Override  // luaj.lib.MathLib$BinaryOp
    protected double a(double f, double f1) {
        return Math.pow(f, f1);
    }
}

