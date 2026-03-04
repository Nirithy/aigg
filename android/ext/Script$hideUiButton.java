package android.ext;

import luaj.ap;

final class Script.hideUiButton extends Script.ApiFunction {
    final Script d;

    Script.hideUiButton(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.hideUiButton() -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        MainService.instance.f(false);
        return Script.hideUiButton.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

