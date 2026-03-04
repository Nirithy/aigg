package android.ext;

import android.content.Context;
import android.content.ContextWrapper;

public class cs extends ContextWrapper {
    public cs(Context context0) {
        super(context0);
    }

    @Override  // android.content.Context
    public String getOpPackageName() {
        la.a(("Use 2 " + Config.E + " instead of " + "catch_.me_.if_.you_.can_"));
        return Config.E;
    }

    @Override  // android.content.ContextWrapper
    public String getPackageName() {
        la.a(("Use 1 " + Config.E + " instead of " + "catch_.me_.if_.you_.can_"));
        return Config.E;
    }
}

