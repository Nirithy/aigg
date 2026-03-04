package luaj.lib;

class h {
    final String a;
    final String b;

    h(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override
    public String toString() {
        return this.b + " \'" + this.a + "\'";
    }
}

