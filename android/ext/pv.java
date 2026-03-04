package android.ext;

public class pv {
    public long a;
    public boolean b;
    public int c;

    public pv() {
        this.a = 0L;
        this.b = false;
        this.c = 0;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + this.a + " 0x" + Integer.toHexString(this.c);
    }
}

