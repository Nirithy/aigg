package android.ext;

import luaj.ap;

class Script.ApiFunction.1 implements Runnable {
    final Script.ApiFunction a;
    private final ap b;

    Script.ApiFunction.1(Script.ApiFunction script$ApiFunction0, ap ap0) {
        this.a = script$ApiFunction0;
        this.b = ap0;
        super();
    }

    @Override
    public void run() {
        this.a.c(this.b);
    }
}

