package edu.umn.d.cs2511.MLData;

import java.util.Scanner;

public class BooleanData extends Data {
    Boolean data;

    public BooleanData() { data = false; }
    public BooleanData(boolean d) { data = d; }
    public BooleanData(Boolean d) { data = Boolean.valueOf(d); }
    public BooleanData(String s) throws NumberFormatException { data = Boolean.valueOf(s); }

    @Override
    public String getStringValue() {
        return Boolean.toString(data);
    }

    @Override
    public DataType getType() { return DataType.BOOLEAN;
    }

    public Boolean getIntValue() {
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
                s = s.toLowerCase();
                if (s.equals("true") || s.equals("false")) {
                    System.out.println("String: " + s);
                    Boolean v = Boolean.valueOf(s);
                    System.out.println("Yes a Boolean: " + v);
                } else {
                    throw new Exception();
                }
            }
            catch (Exception e) {
                System.out.println("No, not a Boolean");
            }
        } while (true);
    }
}
