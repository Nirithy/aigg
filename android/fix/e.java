package android.fix;

import android.content.Context;
import android.ext.la;
import java.lang.reflect.Field;

class e extends d {
    private Object mPackageInfo;

    e(Context context0) {
        super(context0);
        try {
            Context context1 = this.getBaseContext();
            Class class0 = Class.forName("android.app.ContextImpl");
            if(class0.isInstance(context1)) {
                Field field0 = class0.getDeclaredField("mPackageInfo");
                field0.setAccessible(true);
                this.mPackageInfo = field0.get(context1);
                la.a(("WBContext: " + this.mPackageInfo));
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

