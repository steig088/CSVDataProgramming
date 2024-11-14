package edu.umn.d.cs2511.MLData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDataTest {

    StringData s1;
    StringData s2;
    StringData s3;
    StringData s4;
    StringData s5;
    StringData s6;

    @BeforeEach
    void setUp() {
        s1 = new StringData("./\"");
        s2 = new StringData("hello world");
        s3 = new StringData("+++");
        s4 = new StringData("h");
        s5 = new StringData("h4llo w0rld");
        s6 = new StringData("    ");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStringValue() {
        assertThrows(Exception.class, () -> new IntData("true"));
        assertThrows(Exception.class, () -> new IntData("false"));
        assertThrows(Exception.class, () -> new IntData("0.1"));
        assertThrows(Exception.class, () -> new IntData("54.343"));

    }

    @Test
    void getType() {
        assertEquals(Data.DataType.STRING,s1.getType());
        assertEquals(Data.DataType.STRING,s2.getType());
        assertEquals(Data.DataType.STRING,s3.getType());
        assertEquals(Data.DataType.STRING,s4.getType());
        assertEquals(Data.DataType.STRING,s5.getType());
        assertEquals(Data.DataType.STRING,s6.getType());
    }

    @Test
    void getIntValue() {
        assertEquals("./\"", s1.getIntValue());
        assertEquals("hello world", s2.getIntValue());
        assertEquals("+++", s3.getIntValue());
        assertEquals("h", s4.getIntValue());
        assertEquals("h4llo w0rld", s5.getIntValue());
        assertEquals("    ", s6.getIntValue());

    }
}