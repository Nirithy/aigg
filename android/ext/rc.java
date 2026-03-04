package android.ext;

public class rc {
    public long a;
    public long b;
    public int c;
    public int d;

    public rc() {
        this.a = 0L;
        this.b = 0L;
        this.c = 0;
        this.d = 0x20000000;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(super.toString()).append(": ").append(this.a);
        return this.d == 0x20000000 ? stringBuilder0.append("~").append(this.b).append(' ').append(this.c).toString() : stringBuilder0.append("~~").append(this.b).append(' ').append(this.c).toString();
    }
}

