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
                ((Integer.parseInt(firstOpp) > 10 || Integer.parseInt(firstOpp) <= 0)) &&
                (Integer.parseInt(secondOpp) > 10 || Integer.parseInt(secondOpp) <= 0)) {
            throw new Exception("you should to use numbers from 1 to 10");
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
