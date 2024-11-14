package edu.umn.d.cs2511.MLData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooleanDataTest {

    BooleanData b1;
    BooleanData b2;
    BooleanData b3;
    BooleanData b4;
    BooleanData b5;
    BooleanData b6;

    @BeforeEach
    void setUp() {
        b1 = new BooleanData(false);
        b2 = new BooleanData(true);
        b3 = new BooleanData("false");
        b4 = new BooleanData("true");
        b5 = new BooleanData("tRuE");
        b6 = new BooleanData("FalSE");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStringValue() {
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
    }

    @Test
    void getType() {
        assertEquals(Data.DataType.BOOLEAN, b1.getType());
        assertEquals(Data.DataType.BOOLEAN, b2.getType());
        assertEquals(Data.DataType.BOOLEAN, b3.getType());
        assertEquals(Data.DataType.BOOLEAN, b4.getType());
        assertEquals(Data.DataType.BOOLEAN, b5.getType());
        assertEquals(Data.DataType.BOOLEAN, b6.getType());

    }

    @Test
    void getIntValue() {
        assertEquals(false, b1.getIntValue());
        assertEquals(true, b2.getIntValue());
        assertEquals(false, b3.getIntValue());
        assertEquals(true, b4.getIntValue());
        assertEquals(true, b5.getIntValue());
        assertEquals(false, b6.getIntValue());
    }
}