package android.ext;

class oi extends oj {
    final MainService c;

    public oi(MainService mainService0) {
        this.c = mainService0;
        super(mainService0, 0x7F070344, 0x7F020045);  // string:changed_as_search_result "Changed as search result"
    }

    @Override  // android.ext.of
    void b() {
        g g0 = this.c.ao;
        if(g0.b() == 0) {
            Tools.b(qk.a(0x7F070345));  // string:changed_not_found "Changed items not found."
            return;
        }
        this.a(g0.d(), null);
    }
}

