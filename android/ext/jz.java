package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class jz implements DialogInterface.OnClickListener {
    final jy a;

    jz(jy jy0) {
        this.a = jy0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            new be("kwws=22jdphjxdugldq1qhw2iruxp2wrslf2:6<;0jdwkhulqj0lqirupdwlrq0derxw0jj0huuruv2").onClick(dialogInterface0, -1);
            rx.a().postDelayed(new ka(this), 5000L);
            return;
        }
        jp.a(true);
    }
}

