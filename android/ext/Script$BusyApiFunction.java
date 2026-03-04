package android.ext;

abstract class Script.BusyApiFunction extends Script.ApiFunction {
    final Script d;

    public Script.BusyApiFunction(Script script0) {
        this.d = script0;
        super();
        this.a = script0;
    }

    @Override  // android.ext.Script$ApiFunction
    protected String e() {
        return this.d.j;
    }
}

