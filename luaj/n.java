package luaj;

public class n extends o {
    public final int a;
    public final String b;
    public final String c;

    public n(int v, String s, String s1) {
        super(null);
        this.a = v;
        this.b = s1;
        this.c = this.a(s);
        this.k = this.c();
    }

    n(n n0) {
        super(null, n0);
        this.a = n0.a - 1;
        this.b = n0.b;
        this.c = n0.c;
        this.k = this.c();
    }

    private String a(String s) {
        if(s == null) {
            StackTraceElement[] arr_stackTraceElement = this.getStackTrace();
            if(arr_stackTraceElement != null) {
                for(int v = 1; v < arr_stackTraceElement.length; ++v) {
                    String s1 = arr_stackTraceElement[v].getClassName();
                    if(s1 != null) {
                        if(s1.endsWith("LuaClosure")) {
                            break;
                        }
                        if(s1.contains("Lib$")) {
                            return LuaFunction.e(s1);
                        }
                    }
                }
            }
        }
        return s;
    }

    private String c() {
        if(this.c == null) {
            return this.a == 0 ? "calling method on bad self" + this.b : "bad argument #" + this.a + ": " + this.b;
        }
        return this.a == 0 ? "calling \'" + this.c + "\' on bad self" + " (" + this.b + ")" : "bad argument #" + this.a + " to \'" + this.c + "\'" + " (" + this.b + ")";
    }
}

