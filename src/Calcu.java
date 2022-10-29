import java.io.IOException;
import java.util.Scanner;
class  Calc{
    static Scanner scanner = new Scanner(System.in);
    static String result;


    static String numToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }


    static String romanToNumber(String roman) {
        switch (roman) {
            case "I":
                return "1";
            case "II":
                return "2";
            case "III":
                return "3";
            case "IV":
                return "4";
            case "V":
                return "5";
            case "VI":
                return "6";
            case "VII":
                return "7";
            case "VIII":
                return "8";
            case "IX":
                return "9";
            case "X":
                return "10";
        }

        return roman;
    }

    public static class Main {
        public static String calc(String input) {
            int number1 = 0;
            int number2 = 0;
            char operand;
            int results = 0;
            String results2;
            String[] str = input.split(" ");
            String str1 = str[0];
            String str2 = str[1];
            String str3 = str[2];
            String str01 = str1.trim();
            String str02 = str2.trim();
            String str03 = str3.trim();
            try {
                number1 = Integer.parseInt(str01);
                number2 = Integer.parseInt(str03);
            }catch (NumberFormatException e){
                System.out.println("trows Exception //!!ТОЛЬКО ДВА ЧИСЛА ОТ 1 ДО 10, НЕ БОЛЕЕ!!");
                System.exit(1);
            }
            if (number1 > 10 | number2 > 10){try {
                throw new IOException();
            }catch (IOException e) {
                System.out.println("trows Exception // !!ТОЛЬКО ДВА ЧИСЛА ОТ 1 ДО 10, НЕ БОЛЕЕ!!");
                System.exit(1);}}
            operand = str02.charAt(0);
            if (operand == '+') {
                results = number1 + number2;
            } else if (operand == '-') {
                results = number1 - number2;
            } else if (operand == '*') {
                results = number1 * number2;
            } else if (operand == '/') {
                results = number1 / number2;
            }
            results2 = String.valueOf(results);
            return results2;

        }
        public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
            System.out.println("ВВЕДИТЕ ВЫРАЖЕНИЕ");
            System.out.println("НАПРИМЕР: 5 * 2 ; или V + V");
            String[] roman1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arabian = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String inputUser = scanner.nextLine();
            String[] roman = inputUser.split(" ");
            if (roman.length != 3) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("trows Exception // т.к. формат строки не удовлетворяет заданию - два операнда и одие оператор");
                    return;
                }
            }
            String s1;
            String s2;
            try {
                s1 = roman[0];
                s2 = roman[2];
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
            boolean rom1 = false, rom2 = false;
            boolean arab1 = false, arab2 = false;
            for (int i = 0; i < roman1.length; i++) {
                if (roman[0].contains(roman1[i])) {
                    rom1 = true;
                }
                if (roman[2].contains(roman1[i])) {
                    rom2 = true;
                }
                if (roman[0].contains(arabian[i])) {
                    arab1 = true;                         // проверка какие символы зашли
                }
                if (roman[2].contains(arabian[i])) {
                    arab2 = true;
                }
            }
            if (rom1 & arab2) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //!!т.к. ИСПОЛЬЗУЮТЬСЯ ОДНОВРЕМЕННО РАЗНЫЕ СИСТЕМЫ СЧИСЛЕНИЯ!!");
                }
            }
            if (rom2 & arab1) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception //!!т.к. ИСПОЛЬЗУЮТЬСЯ ОДНОВРЕМЕННО РАЗНЫЕ СИСТЕМЫ СЧИСЛЕНИЯ!!");
                }
            }
            if (rom1 & rom2) {
                String strum1 = romanToNumber(s1);
                String strum2 = romanToNumber(s2);
                String metronome = strum1 + " " + roman[1] + " " + strum2;
                result = calc(metronome);
//
                int resultRome = Integer.parseInt(result);
                try {
                    System.out.println(numToRoman(resultRome));
                } catch (RuntimeException e) {
                    System.out.println("throws Exception //т.к.в римской системе нет отрицательных чисел");
                }
            }
            if (arab1 & arab2) {
                result = calc(inputUser);
                System.out.println(result);
            }
        }
    }
}
