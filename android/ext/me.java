package android.ext;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.DeadObjectException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class me extends Dialog implements DialogInterface.OnDismissListener {
    private View a;

    public me(Context context0, View view0) {
        super(context0);
        this.a = view0;
        this.requestWindowFeature(1);
        this.setContentView(Tools.d(view0));
        this.setCanceledOnTouchOutside(false);
        this.setCancelable(false);
        this.setOnDismissListener(this);
    }

    public void a() {
        la.a("MainDialog menu");
        MainService.instance.e();
    }

    @TargetApi(11)
    private void b() {
        this.a.setPadding(0, ((Config.B & 16) == 0 ? 0 : ((int)Tools.a(24.0f))), 0, 0);
        Window window0 = this.getWindow();
        window0.setAttributes(this.c());
        window0.setBackgroundDrawable(new ColorDrawable(0));
        if((Config.B & 2) == 0) {
            window0.clearFlags(0x1000000);
        }
        else {
            window0.addFlags(0x1000000);
        }
        ShowApp.a(window0);
    }

    private WindowManager.LayoutParams c() {
        WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams();
        windowManager$LayoutParams0.type = rv.a();
        windowManager$LayoutParams0.width = -1;
        windowManager$LayoutParams0.height = -1;
        windowManager$LayoutParams0.format = -2;
        windowManager$LayoutParams0.horizontalMargin = 0.0f;
        windowManager$LayoutParams0.horizontalWeight = 1.0f;
        windowManager$LayoutParams0.verticalMargin = 0.0f;
        windowManager$LayoutParams0.verticalWeight = 1.0f;
        windowManager$LayoutParams0.dimAmount = 0.0f;
        return windowManager$LayoutParams0;
    }

    @Override  // android.app.Dialog
    public void dismiss() {
        try {
            super.dismiss();
            Tools.d(this.a);
        }
        catch(Throwable throwable0) {
            Throwable throwable1 = throwable0.getCause();
            if(throwable1 != null && throwable1 instanceof DeadObjectException) {
                i.a(i.c().setCustomTitle(Tools.d(0x7F0700EB)).setMessage(qk.a(0x7F0700EC)).setPositiveButton(qk.a(0x7F0700B8), new ib(900)).setNegativeButton(qk.a(0x7F0700B9), null));  // string:failed_remove_window "Failed to remove window"
            }
            la.c("main dismiss failed", throwable0);
        }
        if(this.isShowing()) {
            la.b("main hide fail");
        }
    }

    @Override  // android.app.Dialog
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        try {
            return super.dispatchTouchEvent(motionEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        la.a("MainDialog back");
        MainService.instance.g();
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        la.a("MainDialog dismiss");
    }

    @Override  // android.app.Dialog
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(super.onKeyDown(v, keyEvent0)) {
            return true;
        }
        if(v == 82) {
            keyEvent0.startTracking();
            return true;
        }
        return false;
    }

    @Override  // android.app.Dialog
    public boolean onKeyUp(int v, KeyEvent keyEvent0) {
        if(super.onKeyUp(v, keyEvent0)) {
            return true;
        }
        if(v == 82 && keyEvent0.isTracking() && !keyEvent0.isCanceled()) {
            this.a();
            return true;
        }
        return false;
    }

    @Override  // android.app.Dialog
    public void setContentView(int v) {
        try {
            super.setContentView(v);
        }
        catch(RuntimeException runtimeException0) {
            la.a(runtimeException0);
        }
    }

    @Override  // android.app.Dialog
    public void setContentView(View view0) {
        try {
            super.setContentView(view0);
        }
        catch(RuntimeException runtimeException0) {
            la.a(runtimeException0);
        }
    }

    @Override  // android.app.Dialog
    public void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        try {
            super.setContentView(view0, viewGroup$LayoutParams0);
        }
        catch(RuntimeException runtimeException0) {
            la.a(runtimeException0);
        }
    }

    @Override  // android.app.Dialog
    public void show() {
        this.b();
        Tools.a(this.getWindow());
        try {
            super.show();
            Tools.l(this.getWindow().getDecorView());
        }
        catch(Throwable throwable0) {
            Throwable throwable1 = throwable0.getCause();
            if(throwable1 != null && throwable1 instanceof DeadObjectException) {
                i.a(i.c().setCustomTitle(Tools.d(0x7F0700EA)).setMessage(qk.a(0x7F0700EC)).setPositiveButton(qk.a(0x7F0700B8), new ib(800)).setNegativeButton(qk.a(0x7F0700B9), null));  // string:failed_add_window "Failed to add window"
            }
            la.c("main show failed", throwable0);
        }
        if(!this.isShowing()) {
            la.b("main show fail");
        }
    }
}

