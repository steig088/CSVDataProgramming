package edu.umn.d.cs2511.MLData;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class IntDataTest {

    IntData i1;
    IntData i2;
    IntData i3;
    IntData i4;
    IntData i5;
    IntData i6;

    @BeforeEach
    void setUp() {
        i1 = new IntData();
        i2 = new IntData(42);
        i3 = new IntData("0000");
        i4 = new IntData("042");
        i5 = new IntData("-43");
        i6 = new IntData("43");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStringValue() {
        IntData i;
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

        i = new IntData("42");
        assertEquals(42, i.getIntValue());
        i = new IntData("+43");
        assertEquals(43, i.getIntValue());
        i = new IntData("-44");
        assertEquals(-44, i.getIntValue());
        i = new IntData("00000000");
        assertEquals(0, i.getIntValue());
        i = new IntData("0000000042");
        assertEquals(42, i.getIntValue());
        i = new IntData("123456789");
        assertEquals(123456789, i.getIntValue());
    }

    @Test
    void getType() {
        assertEquals(Data.DataType.INT,i1.getType());
        assertEquals(Data.DataType.INT,i2.getType());
        assertEquals(Data.DataType.INT,i3.getType());
        assertEquals(Data.DataType.INT,i4.getType());
        assertEquals(Data.DataType.INT,i5.getType());
        assertEquals(Data.DataType.INT,i6.getType());
    }

    @Test
    void getIntValue() {
        assertEquals(0,i1.getIntValue());
        assertEquals(42,i2.getIntValue());
        assertEquals(0,i3.getIntValue());
        assertEquals(42,i4.getIntValue());
        assertEquals(-43,i5.getIntValue());
        assertEquals(43,i6.getIntValue());
    }
}