package edu.umn.d.cs2511.MLData;

import java.util.Scanner;

public class StringData extends Data {
    String data;

    public StringData() { data = ""; }
    public StringData(String d) { data = String.valueOf(d); }

    @Override
    public String getStringValue() { return data; }

    @Override
    public DataType getType() {
        return DataType.STRING;
    }

    public String getIntValue() {
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
                String v = String.valueOf(s);
                int intCount = 0;
                for (int i = 0; i < v.length(); i++) {
                    if(v.charAt(i) == '0' || v.charAt(i) == '1' || v.charAt(i) == '2'
                            || v.charAt(i) == '3' || v.charAt(i) == '4' || v.charAt(i) == '5'
                            || v.charAt(i) == '6' || v.charAt(i) == '7' || v.charAt(i) == '8'
                            || v.charAt(i) == '9' || v.charAt(i) == '.') {
                        intCount++;
                    }
                }
                if (intCount == v.length() || v.equals("true") || v.equals("false")) {
                    throw new Exception();
                } else {
                    System.out.println("Yes a String: " + v);
                }
            }
            catch (Exception e) {
                System.out.println("No, not a String");
            }
        } while (true);
    }
}
