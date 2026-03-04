package android.ext;

import luaj.ap;

final class Script.isClickedUiButton extends Script.ApiFunction {
    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.isClickedUiButton() -> bool || nil";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap b(ap ap0) {
        MainService mainService0 = MainService.instance;
        ap ap1 = Script.isClickedUiButton.u;
        if(mainService0.f != null) {
            if(mainService0.g) {
                mainService0.g = false;
                return Script.isClickedUiButton.v;
            }
            return Script.isClickedUiButton.w;
        }
        return ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

