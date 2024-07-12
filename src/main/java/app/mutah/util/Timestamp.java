package app.mutah.util;

import java.math.BigInteger;

public class Timestamp extends BigInteger {

    public Timestamp(String val) {
        super(val);
    }

    public Timestamp(byte[] val) {
        super(val);
    }

    public Timestamp(BigInteger val) {
        super(String.valueOf(val));
    }

    public Timestamp fromString(String val) {
        return new Timestamp(val);
    }
}
