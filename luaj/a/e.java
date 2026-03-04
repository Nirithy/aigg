package luaj.a;

public class e {
    final int[] a;
    final int b;

    public e(int[] arr_v, int v) {
        this.a = arr_v;
        this.b = v;
    }

    int a() {
        return this.a[this.b];
    }

    void a(int v) {
        this.a[this.b] = v;
    }
}

