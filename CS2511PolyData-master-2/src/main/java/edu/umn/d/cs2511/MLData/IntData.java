package edu.umn.d.cs2511.MLData;

import java.util.Scanner;

public class IntData extends Data {
    Integer data;

    public IntData() { data = 0; }
    public IntData(int d) { data = d; }
    public IntData(Integer d) { data = Integer.valueOf(d); }
    public IntData(String s) throws NumberFormatException {
        data = Integer.valueOf(s); }


    @Override
    public String getStringValue() {
        return Integer.toString(data);
    }

    @Override
    public DataType getType() {
        return DataType.INT;
    }

    public Integer getIntValue() {
        return data;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        do {
            try {
                System.out.print("Input: ");
                s = scanner.nextLine();
                s = s.trim();
                System.out.println("String: " + s);
                Integer v = Integer.valueOf(s);
                System.out.println("Yes an integer: " + v);
            }
            catch (Exception e) {
                System.out.println("No, not an integer");
            }
        } while (true);
    }
}
