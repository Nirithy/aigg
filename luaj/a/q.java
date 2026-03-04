package luaj.a;

class q {
    final short a;

    q(int v) {
        this.a = (short)v;
    }

    @Override
    public String toString() {
        return "Vardesc [idx=" + ((int)this.a) + ']';
    }
}

