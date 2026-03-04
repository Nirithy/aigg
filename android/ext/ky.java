package android.ext;

import java.util.Arrays;

public class ky {
    double[] a;
    private int b;
    private double c;

    public ky() {
        this.b = 0;
        this.c = 1.0;
        this.a = new double[]{1.0};
        this.a(ps.b(Tools.s().getString("list-speeds", "0.000000001;0.00000001;0.0000001;0.000001;0.00001;0.0001;0.001;0.002;0.005;0.01;0.02;0.05;0.1;0.2;0.5;0.6;0.75;0.9;1;1.2;1.3;1.5;2;3;4;5;6;9;12;15;20;30;60;120;180;300;600;1200;2400;3600")), false);
    }

    public static String a() [...] // 潜在的解密器

    private void a(int v) {
        int v1 = this.b + v >= 0 ? this.b + v : 0;
        if(v1 >= this.a.length) {
            v1 = this.a.length - 1;
        }
        this.b = v1;
        this.c = this.a[v1];
    }

    private void a(String s, boolean z) {
        int v2;
        Double double0;
        if(s.length() == 0) {
            s = "0.000000001;0.00000001;0.0000001;0.000001;0.00001;0.0001;0.001;0.002;0.005;0.01;0.02;0.05;0.1;0.2;0.5;0.6;0.75;0.9;1;1.2;1.3;1.5;2;3;4;5;6;9;12;15;20;30;60;120;180;300;600;1200;2400;3600";
        }
        String[] arr_s = s.split(";");
        double[] arr_f = new double[arr_s.length + 1];
        int v = 0;
        boolean z1 = false;
        int v1 = 0;
        while(v1 < arr_s.length) {
            String s1 = arr_s[v1];
            try {
                double0 = Tools.f(s1);
            }
            catch(NumberFormatException numberFormatException0) {
                la.b(("Failed parse speed: \'" + s1 + '\''), numberFormatException0);
                v2 = v;
                goto label_23;
            }
            if(((double)double0) >= 1.000000E-09 && ((double)double0) <= 1000000000.0) {
                if(!z1 && ((double)double0) == 1.0) {
                    z1 = true;
                }
                v2 = v + 1;
                arr_f[v] = (double)double0;
            }
            else {
                la.b(("Speed outside range: " + double0 + " (" + 1.000000E-09 + "; " + 1000000000.0 + ')'));
                v2 = v;
            }
        label_23:
            ++v1;
            v = v2;
        }
        if(!z1) {
            arr_f[v] = 1.0;
            ++v;
        }
        double[] arr_f1 = arr_f.length <= v ? arr_f : Arrays.copyOf(arr_f, v);
        if(Config.l != 0) {
            Arrays.sort(arr_f1);
            if(Config.l == 2) {
                double f = 0.0;
                int v3 = 0;
                for(int v4 = 0; v4 < arr_f1.length; ++v4) {
                    double f1 = arr_f1[v4];
                    if(v4 <= 0 || f1 != f) {
                        if(v4 != v3) {
                            arr_f1[v3] = f1;
                        }
                        ++v3;
                        f = f1;
                    }
                    else {
                        la.b(("Speed duplicate: " + f1 + " (" + v4 + ')'));
                    }
                }
                if(arr_f1.length > v3) {
                    arr_f1 = Arrays.copyOf(arr_f1, v3);
                }
            }
        }
        this.a = arr_f1;
        this.d(this.c);
        if(z) {
            String s2 = ps.a(this.f());
            new qw().a("list-speeds", s2, "0.000000001;0.00000001;0.0000001;0.000001;0.00001;0.0001;0.001;0.002;0.005;0.01;0.02;0.05;0.1;0.2;0.5;0.6;0.75;0.9;1;1.2;1.3;1.5;2;3;4;5;6;9;12;15;20;30;60;120;180;300;600;1200;2400;3600").commit();
        }
    }

    public void a(double f) {
        this.d(f);
    }

    public void a(String s) {
        this.a(s, true);
    }

    public static String b(double f) {
        int v = Math.min(Math.max(((int)Math.log10(f)), 0), 9);
        String s = Tools.a(("%,." + (9 - v) + 'f'), new Object[]{f});
        return 9 - v == 0 ? s : s.replaceAll("[" + '.' + "]?0*$", "");
    }

    public void b() {
        this.a(1.0);
    }

    public static kz c(double f) {
        double f1 = Math.pow(10.0, 9 - Math.max(0, ((int)Math.ceil(Math.log10(f)))));
        int v = ((int)(((double)(((int)(f1 * 2.0)))) * f)) == 0 ? 1 : ((int)(((double)(((int)(f1 * 2.0)))) * f));
        int v1 = Tools.b(v, ((int)(f1 * 2.0)));
        return new kz(v / v1, ((int)(f1 * 2.0)) / v1);
    }

    public double c() {
        return this.c;
    }

    private void d(double f) {
        int v2;
        double f1 = 1.797693E+308;
        int v = 0;
        int v1;
        for(v1 = 0; v < this.a.length; v1 = v2) {
            double f2 = Math.abs(f - this.a[v]);
            if(f2 < f1) {
                f1 = f2;
                v2 = v;
            }
            else {
                v2 = v1;
            }
            ++v;
        }
        this.b = v1;
        this.c = this.a[v1];
    }

    public void d() {
        this.a(1);
    }

    public void e() {
        this.a(-1);
    }

    public String f() {
        StringBuilder stringBuilder0 = new StringBuilder();
        boolean z = true;
        double[] arr_f = this.a;
        for(int v = 0; v < arr_f.length; ++v) {
            double f = arr_f[v];
            if(z) {
                z = false;
            }
            else {
                stringBuilder0.append(';');
            }
            stringBuilder0.append(ky.b(f));
        }
        return stringBuilder0.toString();
    }
}

