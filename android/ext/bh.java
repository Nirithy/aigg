package android.ext;

class bh implements Runnable {
    @Override
    public void run() {
        try {
            if(MainService.instance != null) {
                MainService.instance.O();
            }
        }
        catch(Throwable throwable0) {
            la.b("MainService onDestroy fail", throwable0);
        }
    }
}

