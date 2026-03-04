package android.ext;

public class e {
    int a;
    CharSequence b;
    public int c;

    public e(int v, CharSequence charSequence0, int v1) {
        this.a = v;
        this.b = charSequence0;
        this.c = v1;
    }

    @Override
    public String toString() {
        return this.c <= 0 ? this.b.toString() : this.c + ": " + this.b.toString();
    }
}

