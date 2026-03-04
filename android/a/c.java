package android.a;

import android.util.Xml;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
    private static final Object a(XmlPullParser xmlPullParser0, String s) {
        try {
            if(s.equals("int")) {
                return Integer.parseInt(xmlPullParser0.getAttributeValue(null, "value"));
            }
            if(s.equals("long")) {
                return Long.valueOf(xmlPullParser0.getAttributeValue(null, "value"));
            }
            if(s.equals("float")) {
                return Float.valueOf(xmlPullParser0.getAttributeValue(null, "value"));
            }
            if(s.equals("double")) {
                return Double.valueOf(xmlPullParser0.getAttributeValue(null, "value"));
            }
            return s.equals("boolean") ? Boolean.valueOf(xmlPullParser0.getAttributeValue(null, "value")) : null;
        }
        catch(NullPointerException unused_ex) {
            throw new XmlPullParserException("Need value attribute in <" + s + '>');
        }
        catch(NumberFormatException unused_ex) {
            throw new XmlPullParserException("Not a number in value attribute in <" + s + '>');
        }
    }

    private static final Object a(XmlPullParser xmlPullParser0, String[] arr_s) {
        int v = xmlPullParser0.getEventType();
        do {
            switch(v) {
                case 2: {
                    return c.a(xmlPullParser0, arr_s, null);
                }
                case 3: {
                    throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser0.getName());
                }
                case 4: {
                    throw new XmlPullParserException("Unexpected text: " + xmlPullParser0.getText());
                }
            }
            v = xmlPullParser0.next();
        }
        while(v != 1);
        throw new XmlPullParserException("Unexpected end of document");
    }

    private static final Object a(XmlPullParser xmlPullParser0, String[] arr_s, d d0) {
        int[] arr_v;
        String s = xmlPullParser0.getAttributeValue(null, "name");
        String s1 = xmlPullParser0.getName();
        if(s1.equals("null")) {
            arr_v = null;
        }
        else {
            if(s1.equals("string")) {
                arr_v = "";
                while(true) {
                    int v = xmlPullParser0.next();
                    if(v == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    }
                    if(v == 3) {
                        if(!xmlPullParser0.getName().equals("string")) {
                            throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser0.getName());
                        }
                        arr_s[0] = s;
                        return arr_v;
                    }
                    if(v == 4) {
                        arr_v = arr_v + xmlPullParser0.getText();
                    }
                    else if(v == 2) {
                        break;
                    }
                }
                throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser0.getName());
            }
            arr_v = c.a(xmlPullParser0, s1);
            if(arr_v == null) {
                if(s1.equals("int-array")) {
                    arr_v = c.a(xmlPullParser0, "int-array", arr_s);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(s1.equals("long-array")) {
                    arr_v = c.b(xmlPullParser0, "long-array", arr_s);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(s1.equals("double-array")) {
                    arr_v = c.c(xmlPullParser0, "double-array", arr_s);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(s1.equals("string-array")) {
                    arr_v = c.d(xmlPullParser0, "string-array", arr_s);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(s1.equals("boolean-array")) {
                    arr_v = c.e(xmlPullParser0, "boolean-array", arr_s);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(s1.equals("map")) {
                    xmlPullParser0.next();
                    arr_v = c.a(xmlPullParser0, "map", arr_s, d0);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(s1.equals("list")) {
                    xmlPullParser0.next();
                    arr_v = c.b(xmlPullParser0, "list", arr_s, d0);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(s1.equals("set")) {
                    xmlPullParser0.next();
                    arr_v = c.c(xmlPullParser0, "set", arr_s, d0);
                    arr_s[0] = s;
                    return arr_v;
                }
                if(d0 == null) {
                    throw new XmlPullParserException("Unknown tag: " + s1);
                }
                arr_v = d0.a(xmlPullParser0, s1);
                arr_s[0] = s;
                return arr_v;
            }
        }
        do {
            int v1 = xmlPullParser0.next();
            if(v1 == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + s1 + '>');
            }
            if(v1 == 3) {
                if(!xmlPullParser0.getName().equals(s1)) {
                    throw new XmlPullParserException("Unexpected end tag in <" + s1 + ">: " + xmlPullParser0.getName());
                }
                arr_s[0] = s;
                return arr_v;
            }
            if(v1 == 4) {
                throw new XmlPullParserException("Unexpected text in <" + s1 + ">: " + xmlPullParser0.getName());
            }
        }
        while(v1 != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + s1 + ">: " + xmlPullParser0.getName());
    }

    public static final HashMap a(InputStream inputStream0) {
        XmlPullParser xmlPullParser0 = Xml.newPullParser();
        xmlPullParser0.setInput(inputStream0, "UTF-8");
        return (HashMap)c.a(xmlPullParser0, new String[1]);
    }

    private static final HashMap a(XmlPullParser xmlPullParser0, String s, String[] arr_s, d d0) {
        HashMap hashMap0 = new HashMap();
        int v = xmlPullParser0.getEventType();
        do {
            switch(v) {
                case 2: {
                    Object object0 = c.a(xmlPullParser0, arr_s, d0);
                    hashMap0.put(arr_s[0], object0);
                    break;
                }
                case 3: {
                    if(!xmlPullParser0.getName().equals(s)) {
                        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
                    }
                    return hashMap0;
                }
            }
            v = xmlPullParser0.next();
        }
        while(v != 1);
        throw new XmlPullParserException("Document ended before " + s + " end tag");
    }

    private static final int[] a(XmlPullParser xmlPullParser0, String s, String[] arr_s) {
        int v;
        try {
            v = Integer.parseInt(xmlPullParser0.getAttributeValue(null, "num"));
        }
        catch(NullPointerException unused_ex) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        }
        catch(NumberFormatException unused_ex) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
        xmlPullParser0.next();
        int[] arr_v = new int[v];
        int v1 = 0;
        int v2 = xmlPullParser0.getEventType();
    alab1:
        while(true) {
            switch(v2) {
                case 2: {
                    if(xmlPullParser0.getName().equals("item")) {
                        try {
                            arr_v[v1] = Integer.parseInt(xmlPullParser0.getAttributeValue(null, "value"));
                            break;
                        }
                        catch(NullPointerException unused_ex) {
                            throw new XmlPullParserException("Need value attribute in item");
                        }
                        catch(NumberFormatException unused_ex) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    }
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser0.getName());
                }
                case 3: {
                    if(xmlPullParser0.getName().equals(s)) {
                        return arr_v;
                    }
                    if(!xmlPullParser0.getName().equals("item")) {
                        break alab1;
                    }
                    ++v1;
                }
            }
            v2 = xmlPullParser0.next();
            if(v2 == 1) {
                throw new XmlPullParserException("Document ended before " + s + " end tag");
            }
        }
        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
    }

    private static final ArrayList b(XmlPullParser xmlPullParser0, String s, String[] arr_s, d d0) {
        ArrayList arrayList0 = new ArrayList();
        int v = xmlPullParser0.getEventType();
        do {
            switch(v) {
                case 2: {
                    arrayList0.add(c.a(xmlPullParser0, arr_s, d0));
                    break;
                }
                case 3: {
                    if(!xmlPullParser0.getName().equals(s)) {
                        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
                    }
                    return arrayList0;
                }
            }
            v = xmlPullParser0.next();
        }
        while(v != 1);
        throw new XmlPullParserException("Document ended before " + s + " end tag");
    }

    private static final long[] b(XmlPullParser xmlPullParser0, String s, String[] arr_s) {
        int v;
        try {
            v = Integer.parseInt(xmlPullParser0.getAttributeValue(null, "num"));
        }
        catch(NullPointerException unused_ex) {
            throw new XmlPullParserException("Need num attribute in long-array");
        }
        catch(NumberFormatException unused_ex) {
            throw new XmlPullParserException("Not a number in num attribute in long-array");
        }
        xmlPullParser0.next();
        long[] arr_v = new long[v];
        int v1 = 0;
        int v2 = xmlPullParser0.getEventType();
    alab1:
        while(true) {
            switch(v2) {
                case 2: {
                    if(xmlPullParser0.getName().equals("item")) {
                        try {
                            arr_v[v1] = Long.parseLong(xmlPullParser0.getAttributeValue(null, "value"));
                            break;
                        }
                        catch(NullPointerException unused_ex) {
                            throw new XmlPullParserException("Need value attribute in item");
                        }
                        catch(NumberFormatException unused_ex) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    }
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser0.getName());
                }
                case 3: {
                    if(xmlPullParser0.getName().equals(s)) {
                        return arr_v;
                    }
                    if(!xmlPullParser0.getName().equals("item")) {
                        break alab1;
                    }
                    ++v1;
                }
            }
            v2 = xmlPullParser0.next();
            if(v2 == 1) {
                throw new XmlPullParserException("Document ended before " + s + " end tag");
            }
        }
        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
    }

    private static final HashSet c(XmlPullParser xmlPullParser0, String s, String[] arr_s, d d0) {
        HashSet hashSet0 = new HashSet();
        int v = xmlPullParser0.getEventType();
        do {
            switch(v) {
                case 2: {
                    hashSet0.add(c.a(xmlPullParser0, arr_s, d0));
                    break;
                }
                case 3: {
                    if(!xmlPullParser0.getName().equals(s)) {
                        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
                    }
                    return hashSet0;
                }
            }
            v = xmlPullParser0.next();
        }
        while(v != 1);
        throw new XmlPullParserException("Document ended before " + s + " end tag");
    }

    private static final double[] c(XmlPullParser xmlPullParser0, String s, String[] arr_s) {
        int v;
        try {
            v = Integer.parseInt(xmlPullParser0.getAttributeValue(null, "num"));
        }
        catch(NullPointerException unused_ex) {
            throw new XmlPullParserException("Need num attribute in double-array");
        }
        catch(NumberFormatException unused_ex) {
            throw new XmlPullParserException("Not a number in num attribute in double-array");
        }
        xmlPullParser0.next();
        double[] arr_f = new double[v];
        int v1 = 0;
        int v2 = xmlPullParser0.getEventType();
    alab1:
        while(true) {
            switch(v2) {
                case 2: {
                    if(xmlPullParser0.getName().equals("item")) {
                        try {
                            arr_f[v1] = Double.parseDouble(xmlPullParser0.getAttributeValue(null, "value"));
                            break;
                        }
                        catch(NullPointerException unused_ex) {
                            throw new XmlPullParserException("Need value attribute in item");
                        }
                        catch(NumberFormatException unused_ex) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    }
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser0.getName());
                }
                case 3: {
                    if(xmlPullParser0.getName().equals(s)) {
                        return arr_f;
                    }
                    if(!xmlPullParser0.getName().equals("item")) {
                        break alab1;
                    }
                    ++v1;
                }
            }
            v2 = xmlPullParser0.next();
            if(v2 == 1) {
                throw new XmlPullParserException("Document ended before " + s + " end tag");
            }
        }
        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
    }

    private static final String[] d(XmlPullParser xmlPullParser0, String s, String[] arr_s) {
        int v;
        try {
            v = Integer.parseInt(xmlPullParser0.getAttributeValue(null, "num"));
        }
        catch(NullPointerException unused_ex) {
            throw new XmlPullParserException("Need num attribute in string-array");
        }
        catch(NumberFormatException unused_ex) {
            throw new XmlPullParserException("Not a number in num attribute in string-array");
        }
        xmlPullParser0.next();
        String[] arr_s1 = new String[v];
        int v1 = 0;
        int v2 = xmlPullParser0.getEventType();
    alab1:
        while(true) {
            switch(v2) {
                case 2: {
                    if(xmlPullParser0.getName().equals("item")) {
                        try {
                            arr_s1[v1] = xmlPullParser0.getAttributeValue(null, "value");
                            break;
                        }
                        catch(NullPointerException unused_ex) {
                            throw new XmlPullParserException("Need value attribute in item");
                        }
                        catch(NumberFormatException unused_ex) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    }
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser0.getName());
                }
                case 3: {
                    if(xmlPullParser0.getName().equals(s)) {
                        return arr_s1;
                    }
                    if(!xmlPullParser0.getName().equals("item")) {
                        break alab1;
                    }
                    ++v1;
                }
            }
            v2 = xmlPullParser0.next();
            if(v2 == 1) {
                throw new XmlPullParserException("Document ended before " + s + " end tag");
            }
        }
        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
    }

    private static final boolean[] e(XmlPullParser xmlPullParser0, String s, String[] arr_s) {
        int v;
        try {
            v = Integer.parseInt(xmlPullParser0.getAttributeValue(null, "num"));
        }
        catch(NullPointerException unused_ex) {
            throw new XmlPullParserException("Need num attribute in string-array");
        }
        catch(NumberFormatException unused_ex) {
            throw new XmlPullParserException("Not a number in num attribute in string-array");
        }
        xmlPullParser0.next();
        boolean[] arr_z = new boolean[v];
        int v1 = 0;
        int v2 = xmlPullParser0.getEventType();
    alab1:
        while(true) {
            switch(v2) {
                case 2: {
                    if(xmlPullParser0.getName().equals("item")) {
                        try {
                            arr_z[v1] = Boolean.valueOf(xmlPullParser0.getAttributeValue(null, "value")).booleanValue();
                            break;
                        }
                        catch(NullPointerException unused_ex) {
                            throw new XmlPullParserException("Need value attribute in item");
                        }
                        catch(NumberFormatException unused_ex) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    }
                    throw new XmlPullParserException("Expected item tag at: " + xmlPullParser0.getName());
                }
                case 3: {
                    if(xmlPullParser0.getName().equals(s)) {
                        return arr_z;
                    }
                    if(!xmlPullParser0.getName().equals("item")) {
                        break alab1;
                    }
                    ++v1;
                }
            }
            v2 = xmlPullParser0.next();
            if(v2 == 1) {
                throw new XmlPullParserException("Document ended before " + s + " end tag");
            }
        }
        throw new XmlPullParserException("Expected " + s + " end tag at: " + xmlPullParser0.getName());
    }
}

