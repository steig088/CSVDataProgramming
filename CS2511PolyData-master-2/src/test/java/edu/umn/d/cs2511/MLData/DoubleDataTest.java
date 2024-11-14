package edu.umn.d.cs2511.MLData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleDataTest {

    DoubleData d1;
    DoubleData d2;
    DoubleData d3;
    DoubleData d4;
    DoubleData d5;
    DoubleData d6;

    @BeforeEach
    void setUp() {
        d1 = new DoubleData("0.0");
        d2 = new DoubleData(1.0);
        d3 = new DoubleData("-2.0");
        d4 = new DoubleData("0.000001");
        d5 = new DoubleData("-0.000001");
        d6 = new DoubleData("5.38385");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStringValue() {
        DoubleData d;
        assertThrows(Exception.class, () -> new IntData("xyz"));
        assertThrows(Exception.class, () -> new IntData("42t"));
        assertThrows(Exception.class, () -> new IntData("0.1"));
        assertThrows(Exception.class, () -> new IntData("++"));
        assertThrows(Exception.class, () -> new IntData(""));
        assertThrows(Exception.class, () -> new IntData("32, 31"));
        assertThrows(Exception.class, () -> new IntData("+3-"));
        assertThrows(Exception.class, () -> new IntData("   "));
        assertThrows(Exception.class, () -> new IntData("1.0"));
        assertThrows(Exception.class, () -> new IntData("$*#$#$#*$"));
        assertThrows(Exception.class, () -> new IntData("t"));
        assertThrows(Exception.class, () -> new IntData("true"));
        assertThrows(Exception.class, () -> new IntData("false"));

    }

    @Test
    void getType() {
        assertEquals(Data.DataType.DOUBLE,d1.getType());
        assertEquals(Data.DataType.DOUBLE,d2.getType());
        assertEquals(Data.DataType.DOUBLE,d3.getType());
        assertEquals(Data.DataType.DOUBLE,d4.getType());
        assertEquals(Data.DataType.DOUBLE,d5.getType());
        assertEquals(Data.DataType.DOUBLE,d6.getType());
    }

    @Test
    void getIntValue() {
        assertEquals(0.0,d1.getIntValue());
        assertEquals(1.0,d2.getIntValue());
        assertEquals(-2.0,d3.getIntValue());
        assertEquals(0.000001,d4.getIntValue());
        assertEquals(-0.000001,d5.getIntValue());
        assertEquals(5.38385,d6.getIntValue());
    }
}