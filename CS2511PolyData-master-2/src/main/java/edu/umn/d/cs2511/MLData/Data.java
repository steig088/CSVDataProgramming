package edu.umn.d.cs2511.MLData;

public abstract class Data {
    public enum DataType {
        INT, DOUBLE, STRING, BOOLEAN, CHAR
    }
    public abstract String getStringValue();
    public abstract DataType getType();
}
