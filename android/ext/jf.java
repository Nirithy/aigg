package android.ext;

class jf implements Runnable {
    final HotFrame a;

    jf(HotFrame hotFrame0) {
        this.a = hotFrame0;
        super();
    }

    @Override
    public void run() {
        boolean z;
        try {
            this.a.setHapticFeedbackEnabled(true);
            z = false;
            z = this.a.performHapticFeedback(0, 1);
            this.a.setHapticFeedbackEnabled(false);
        }
        catch(Throwable throwable0) {
            la.a("Failed make HapticFeedback", throwable0);
            this.a.setHapticFeedbackEnabled(false);
        }
        la.a(("Real long click: " + z));
        MainService.instance.onLongClick(null);
    }
}

