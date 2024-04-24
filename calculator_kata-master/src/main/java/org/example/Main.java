package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Map<String, Integer> romanNumbers = new HashMap<>();

    {
        romanNumbers.put("I", 1);
        romanNumbers.put("II", 2);
        romanNumbers.put("III", 3);
        romanNumbers.put("IV", 4);
        romanNumbers.put("V", 5);
        romanNumbers.put("VI", 6);
        romanNumbers.put("VII", 7);
        romanNumbers.put("VIII", 8);
        romanNumbers.put("IX", 9);
        romanNumbers.put("X", 10);
        romanNumbers.put("XI", 11);
        romanNumbers.put("XII", 12);
        romanNumbers.put("XIII", 13);
        romanNumbers.put("XIV", 14);
        romanNumbers.put("XV", 15);
        romanNumbers.put("XVI", 16);
        romanNumbers.put("XVII", 17);
        romanNumbers.put("XVIII", 18);
        romanNumbers.put("XIX", 19);
        romanNumbers.put("XX", 20);
        romanNumbers.put("XXI", 21);
        romanNumbers.put("XXII", 22);
        romanNumbers.put("XXIII", 23);
        romanNumbers.put("XXIV", 24);
        romanNumbers.put("XXV", 25);
        romanNumbers.put("XXVI", 26);
        romanNumbers.put("XXVII", 27);
        romanNumbers.put("XXVIII", 28);
        romanNumbers.put("XXIX", 29);
        romanNumbers.put("XXX", 30);
        romanNumbers.put("XXXI", 31);
        romanNumbers.put("XXXII", 32);
        romanNumbers.put("XXXIII", 33);
        romanNumbers.put("XXXIV", 34);
        romanNumbers.put("XXXV", 35);
        romanNumbers.put("XXXVI", 35);
        romanNumbers.put("XXXVII", 37);
        romanNumbers.put("XXXVIII", 38);
        romanNumbers.put("XXXIX", 39);
        romanNumbers.put("XL", 40);
        romanNumbers.put("XLI", 41);
        romanNumbers.put("XLII", 42);
        romanNumbers.put("XLIII", 43);
        romanNumbers.put("XLIV", 44);
        romanNumbers.put("XLV", 45);
        romanNumbers.put("XLVI", 46);
        romanNumbers.put("XLVII", 47);
        romanNumbers.put("XLVIII", 48);
        romanNumbers.put("XLIX", 49);
        romanNumbers.put("L", 50);
        romanNumbers.put("LI", 51);
        romanNumbers.put("LII", 52);
        romanNumbers.put("LIII", 53);
        romanNumbers.put("LIV", 54);
        romanNumbers.put("LV", 55);
        romanNumbers.put("LVI", 56);
        romanNumbers.put("LVII", 57);
        romanNumbers.put("LVIII", 58);
        romanNumbers.put("LIX", 59);
        romanNumbers.put("LX", 60);
        romanNumbers.put("LXI", 61);
        romanNumbers.put("LXII", 62);
        romanNumbers.put("LXIII", 63);
        romanNumbers.put("LXIV", 64);
        romanNumbers.put("LXV", 65);
        romanNumbers.put("LXVI", 66);
        romanNumbers.put("LXVII", 67);
        romanNumbers.put("LXVIII", 68);
        romanNumbers.put("LXIX", 69);
        romanNumbers.put("LXX", 70);
        romanNumbers.put("LXXI", 71);
        romanNumbers.put("LXXII", 72);
        romanNumbers.put("LXXIII", 73);
        romanNumbers.put("LXXIV", 74);
        romanNumbers.put("LXXV", 75);
        romanNumbers.put("LXXVI", 76);
        romanNumbers.put("LXXVII", 77);
        romanNumbers.put("LXXVIII", 78);
        romanNumbers.put("LXXIX", 79);
        romanNumbers.put("LXXX", 80);
        romanNumbers.put("LXXXI", 81);
        romanNumbers.put("LXXXII", 82);
        romanNumbers.put("LXXXIII", 83);
        romanNumbers.put("LXXXIV", 84);
        romanNumbers.put("LXXXV", 85);
        romanNumbers.put("LXXXVI", 86);
        romanNumbers.put("LXXXVII", 87);
        romanNumbers.put("LXXXVIII", 88);
        romanNumbers.put("LXXXIX", 89);
        romanNumbers.put("XC", 90);
        romanNumbers.put("XCI", 91);
        romanNumbers.put("XCII", 92);
        romanNumbers.put("XCIII", 93);
        romanNumbers.put("XCIV", 94);
        romanNumbers.put("XCV", 95);
        romanNumbers.put("XCVI", 96);
        romanNumbers.put("XCVII", 97);
        romanNumbers.put("XCVIII", 98);
        romanNumbers.put("XCIX", 99);
        romanNumbers.put("C", 100);
    }

    public static int convertToArabic(String variable) {
        int rsl = 0;

        for (String key : romanNumbers.keySet()) {
            if (variable.equals(key)) {
                rsl = romanNumbers.get(key);
            }

        }
        return rsl;
    }

    public static String convertToRome(int variable) {
        Set<Map.Entry<String, Integer>> entrySet = romanNumbers.entrySet();
        String rsl = "";
        for (Map.Entry<String, Integer> pair : entrySet) {
            if (variable == pair.getValue()) {
                rsl = pair.getKey();
            }
        }
        return rsl;
    }

    private static boolean isInt(String value) throws NumberFormatException {
        boolean rsl = false;
        try {
            Integer.parseInt(value);
            rsl = true;
        } catch (NumberFormatException e) {
            e.fillInStackTrace();
        }
        return rsl;
    }

    public String calc(String inputText) throws Exception {
        String firstOpp;
        String secondOpp;
        char operator = 0;
        String result = "";


        List<Character> elements = new ArrayList<>();
        for (char ch : inputText.trim().toCharArray()) {
            if (ch != ' ') {
                elements.add(ch);
            }
            if (ch == '+') {
                operator = ch;
            }
            if (ch == '-') {
                operator = ch;
            }
            if (ch == '/') {
                operator = ch;
            }
            if (ch == '*') {
                operator = ch;
            }
        }
        int indexOfOperator = elements.indexOf(operator);
        String expression = elements.stream().map(String::valueOf).collect(Collectors.joining());

        firstOpp = expression.substring(0, indexOfOperator);
        secondOpp = expression.substring(indexOfOperator + 1, expression.length());

        if ((isInt(firstOpp) && isInt(secondOpp)) &&
                ((Integer.parseInt(firstOpp) <= 10) && Integer.parseInt(secondOpp) <= 10) &&
                ((Integer.parseInt(firstOpp) > 0) && Integer.parseInt(secondOpp) > 0)
        ) {
            switch (operator) {
                case '+':
                    result = Integer.toString(Integer.parseInt(firstOpp) + Integer.parseInt(secondOpp));
                    break;
                case '-':
                    result = Integer.toString(Integer.parseInt(firstOpp) - Integer.parseInt(secondOpp));
                    break;
                case '*':
                    result = Integer.toString(Integer.parseInt(firstOpp) * Integer.parseInt(secondOpp));
                    break;
                case '/':
                    result = Integer.toString(Integer.parseInt(firstOpp) / Integer.parseInt(secondOpp));
                    break;
            }
        } else if ((isInt(firstOpp) && !isInt(secondOpp)) || (!isInt(firstOpp) && isInt(secondOpp))) {
            throw new Exception("you cant make expressions with various variables");
        } else if ((isInt(firstOpp) && isInt(secondOpp)) &&
                ((Integer.parseInt(firstOpp) > 10 || Integer.parseInt(firstOpp) < 1) ||
                        (Integer.parseInt(secondOpp) > 10 || Integer.parseInt(secondOpp) < 1))) {
            throw new Exception("you should use numbers from 1 to 10");
        } else {
            switch (operator) {
                case '+':
                    result = convertToRome(convertToArabic(firstOpp) + convertToArabic(secondOpp));
                    break;
                case '-':
                    result = convertToRome(convertToArabic(firstOpp) - convertToArabic(secondOpp));
                    break;
                case '*':
                    result = convertToRome(convertToArabic(firstOpp) * convertToArabic(secondOpp));
                    break;
                case '/':
                    result = convertToRome(convertToArabic(firstOpp) / convertToArabic(secondOpp));
                    break;
            }
        }
        return result;
    }
}
