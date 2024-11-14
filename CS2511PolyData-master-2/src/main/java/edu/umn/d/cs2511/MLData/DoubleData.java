package edu.umn.d.cs2511.MLData;

import java.util.Scanner;

public class DoubleData extends Data {
    Double data;

    public DoubleData() { data = 0.0; }
    public DoubleData(double d) { data = d; }
    public DoubleData(Double d) { data = Double.valueOf(d); }
    public DoubleData(String s) throws NumberFormatException { data = Double.valueOf(s); }

    @Override
    public String getStringValue() {
        return Double.toString(data);
    }

    @Override
    public DataType getType() {
        return DataType.DOUBLE;
    }

    public Double getIntValue() {
        return data;
    }

    public static void main(String[] args) {
        do {
            Scanner scanner = new Scanner(System.in);
            String s;

            try {
                System.out.print("Input: ");
                s = scanner.nextLine();
                s = s.trim();
                System.out.println("String: " + s);
                Double v = Double.valueOf(s);
                System.out.println("Yes a double: " + v);
            }
            catch (Exception e) {
                System.out.println("No, not a double");
            }
        } while (true);
    }
}
