package android.ext;

import android.os.Build.VERSION;
import android.widget.ImageView;

class tf implements Runnable {
    private final ImageView a;
    private final float b;

    tf(ImageView imageView0, float f) {
        this.a = imageView0;
        this.b = f;
        super();
    }

    @Override
    public void run() {
        try {
            if(Build.VERSION.SDK_INT < 16) {
                this.a.setAlpha(((int)this.b));
                return;
            }
            try {
                this.a.setImageAlpha(((int)this.b));
            }
            catch(NoSuchMethodError noSuchMethodError1) {
                la.b("setImageAlpha 1", noSuchMethodError1);
                this.a.setAlpha(((int)this.b));
            }
        }
        catch(NoSuchMethodError noSuchMethodError0) {
            la.b("setImageAlpha 2", noSuchMethodError0);
        }
    }
}

