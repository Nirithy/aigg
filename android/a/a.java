package android.a;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Formatter;
import java.util.Locale;

public abstract class a extends PrintStream {
    private final StringBuilder a;
    private ByteBuffer b;
    private CharBuffer c;
    private CharsetDecoder d;
    private final Formatter e;

    protected a() {
        super(new b());
        this.a = new StringBuilder();
        this.e = new Formatter(this.a, null);
    }

    private void a(boolean z) {
        int v = this.a.length();
        int v1;
        for(v1 = 0; v1 < v; v1 = v2 + 1) {
            int v2 = this.a.indexOf("\n", v1);
            if(v2 == -1) {
                break;
            }
            this.a(this.a.substring(v1, v2));
        }
        if(z) {
            if(v1 < v || v == 0) {
                this.a(this.a.substring(v1));
            }
            this.a.setLength(0);
            return;
        }
        this.a.delete(0, v1);
    }

    protected abstract void a(String arg1);

    @Override
    public PrintStream append(char c) {
        synchronized(this) {
            this.print(c);
            return this;
        }
    }

    @Override
    public PrintStream append(CharSequence charSequence0) {
        synchronized(this) {
            this.a.append(charSequence0);
            this.a(false);
            return this;
        }
    }

    @Override
    public PrintStream append(CharSequence charSequence0, int v, int v1) {
        synchronized(this) {
            this.a.append(charSequence0, v, v1);
            this.a(false);
            return this;
        }
    }

    @Override
    public Appendable append(char c) {
        return this.append(c);
    }

    @Override
    public Appendable append(CharSequence charSequence0) {
        return this.append(charSequence0);
    }

    @Override
    public Appendable append(CharSequence charSequence0, int v, int v1) {
        return this.append(charSequence0, v, v1);
    }

    @Override
    public boolean checkError() {
        return false;
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
        synchronized(this) {
            this.a(true);
        }
    }

    @Override
    public PrintStream format(String s, Object[] arr_object) {
        return this.format(Locale.getDefault(), s, arr_object);
    }

    @Override
    public PrintStream format(Locale locale0, String s, Object[] arr_object) {
        synchronized(this) {
            if(s == null) {
                throw new NullPointerException("format");
            }
            this.e.format(locale0, s, arr_object);
            this.a(false);
            return this;
        }
    }

    @Override
    public void print(char c) {
        synchronized(this) {
            this.a.append(c);
            if(c == 10) {
                this.a(false);
            }
        }
    }

    @Override
    public void print(double f) {
        synchronized(this) {
            this.a.append(f);
        }
    }

    @Override
    public void print(float f) {
        synchronized(this) {
            this.a.append(f);
        }
    }

    @Override
    public void print(int v) {
        synchronized(this) {
            this.a.append(v);
        }
    }

    @Override
    public void print(long v) {
        synchronized(this) {
            this.a.append(v);
        }
    }

    @Override
    public void print(Object object0) {
        synchronized(this) {
            this.a.append(object0);
            this.a(false);
        }
    }

    @Override
    public void print(String s) {
        synchronized(this) {
            this.a.append(s);
            this.a(false);
        }
    }

    @Override
    public void print(boolean z) {
        synchronized(this) {
            this.a.append(z);
        }
    }

    @Override
    public void print(char[] arr_c) {
        synchronized(this) {
            this.a.append(arr_c);
            this.a(false);
        }
    }

    @Override
    public PrintStream printf(String s, Object[] arr_object) {
        return this.format(s, arr_object);
    }

    @Override
    public PrintStream printf(Locale locale0, String s, Object[] arr_object) {
        return this.format(locale0, s, arr_object);
    }

    @Override
    public void println() {
        synchronized(this) {
            this.a(true);
        }
    }

    @Override
    public void println(char c) {
        synchronized(this) {
            this.a.append(c);
            this.a(true);
        }
    }

    @Override
    public void println(double f) {
        synchronized(this) {
            this.a.append(f);
            this.a(true);
        }
    }

    @Override
    public void println(float f) {
        synchronized(this) {
            this.a.append(f);
            this.a(true);
        }
    }

    @Override
    public void println(int v) {
        synchronized(this) {
            this.a.append(v);
            this.a(true);
        }
    }

    @Override
    public void println(long v) {
        synchronized(this) {
            this.a.append(v);
            this.a(true);
        }
    }

    @Override
    public void println(Object object0) {
        synchronized(this) {
            this.a.append(object0);
            this.a(true);
        }
    }

    @Override
    public void println(String s) {
        synchronized(this) {
            if(this.a.length() != 0 || s == null) {
                this.a.append(s);
                this.a(true);
            }
            else {
                int v1 = s.length();
                int v2;
                for(v2 = 0; v2 < v1; v2 = v3 + 1) {
                    int v3 = s.indexOf(10, v2);
                    if(v3 == -1) {
                        break;
                    }
                    this.a(s.substring(v2, v3));
                }
                if(v2 < v1) {
                    this.a(s.substring(v2));
                }
            }
        }
    }

    @Override
    public void println(boolean z) {
        synchronized(this) {
            this.a.append(z);
            this.a(true);
        }
    }

    @Override
    public void println(char[] arr_c) {
        synchronized(this) {
            this.a.append(arr_c);
            this.a(true);
        }
    }

    @Override
    protected void setError() {
    }

    @Override
    public void write(int v) {
        this.write(new byte[]{((byte)v)}, 0, 1);
    }

    @Override
    public void write(byte[] arr_b) {
        this.write(arr_b, 0, arr_b.length);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        synchronized(this) {
            if(this.d == null) {
                this.b = ByteBuffer.allocate(80);
                this.c = CharBuffer.allocate(80);
                this.d = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            }
            int v3 = v + v1;
            while(v < v3) {
                int v4 = Math.min(this.b.remaining(), v3 - v);
                this.b.put(arr_b, v, v4);
                v += v4;
                this.b.flip();
                do {
                    CoderResult coderResult0 = this.d.decode(this.b, this.c, false);
                    this.c.flip();
                    this.a.append(this.c);
                    this.c.clear();
                }
                while(coderResult0.isOverflow());
                this.b.compact();
            }
            this.a(false);
        }
    }
}

