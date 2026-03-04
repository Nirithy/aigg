package android.fix;

import android.content.Context;
import android.content.ContextWrapper;

public class h extends ContextWrapper {
    Context a;

    public h(Context context0) {
        super(context0);
        this.a = context0;
    }

    // 去混淆评级： 低(20)
    @Override  // android.content.ContextWrapper
    public Object getSystemService(String s) {
        return "audio".equals(s) ? null : this.a.getSystemService(s);
    }
}

