package android.ext;

import luaj.ap;

final class Script.showUiButton extends Script.ApiFunction {
    final Script d;

    Script.showUiButton(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.showUiButton() -> nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        MainService.instance.f(true);
        return Script.showUiButton.u;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

