package android.ext;

class bg implements Runnable {
    @Override
    public void run() {
        try {
            if(MainService.instance != null) {
                MainService.instance.t();
            }
        }
        catch(Throwable throwable0) {
            la.b("MainService onCreate fail", throwable0);
            throw throwable0;
        }
    }
}

