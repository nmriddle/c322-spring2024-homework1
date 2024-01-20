package part2;

import java.util.Arrays;
import java.util.Stack;

public class Problems {
    public static int[] problem1(int[] nums, int target) {
        /**
         * given an array, returns the two numbers that add up to target
         * @param nums      the list to be checked
         * @param target    the target sum
         * @return the two indices whose values add to target
         */
        int[] result = null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result = new int[]{i, j};
                    return result;
                }
            }
        }
        return result;
    }

    public static boolean problem2(int x) {
        /**
         * given a number, returns if it is a palindrome
         * @param x the number to be checked
         * @return whether x is a palindrome
         */
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int power = (int) Math.log10(x);
        int firstDigit = x / (int) Math.pow(10, power);
        int lastDigit = x % 10;
        if (firstDigit == lastDigit) {
            return problem2((int) (x - firstDigit * Math.pow(10, power)) / 10);
        }
        return false;
    }

    public static String problem3(String[] strs) {
        /**
         * finds the longest common prefix amongst an array of strings
         * @param strs the array to be checked
         * @return the longest common prefix
         */
        String longest = "";
        if (strs.length == 0) {
            return longest;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].toCharArray()[i];
            for (int j = 0; j < strs.length; j++) {
                if (!(strs[j].toCharArray()[i] == c)) {
                    return longest;
                }
            }
            longest += c;
        }
        return longest;
    }

    public static int problem4(String roman) {
        /**
         * finds the integer representation of a roman numeral
         * @param roman the roman numeral to be converted
         * @returns the integer format
         */
        int output = 0;
        if (roman.equals("")) {
            return output;
        }
        while (roman.length() > 0) {
            int l = roman.length();
            boolean found = false;
            if (l >= 2) {
                String lastTwo = roman.substring(l - 2, l);

                switch (lastTwo) {
                    case "IV":
                        found = true;
                        output += 4;
                        roman = roman.substring(0, l - 2);
                        break;
                    case "IX":
                        found = true;
                        output += 9;
                        roman = roman.substring(0, l - 2);
                        break;
                    case "XL":
                        found = true;
                        output += 40;
                        roman = roman.substring(0, l - 2);
                        break;
                    case "XC":
                        found = true;
                        output += 90;
                        roman = roman.substring(0, l - 2);
                        break;
                    case "CD":
                        found = true;
                        output += 400;
                        roman = roman.substring(0, l - 2);
                        break;
                    case "CM":
                        found = true;
                        output += 900;
                        roman = roman.substring(0, l - 2);
                        break;
                }
            }
            if (!found) {
                l = roman.length();
                String last = roman.substring(l - 1, l);
                switch (last) {
                    case "I":
                        roman = roman.substring(0, l - 1);
                        output += 1;
                        break;
                    case "V":
                        roman = roman.substring(0, l - 1);
                        output += 5;
                        break;
                    case "X":
                        roman = roman.substring(0, l - 1);
                        output += 10;
                        break;
                    case "L":
                        roman = roman.substring(0, l - 1);
                        output += 50;
                        break;
                    case "C":
                        roman = roman.substring(0, l - 1);
                        output += 100;
                        break;
                    case "D":
                        roman = roman.substring(0, l - 1);
                        output += 500;
                        break;
                    case "M":
                        roman = roman.substring(0, l - 1);
                        output += 1000;
                        break;
                }
            }
        }
        return output;
    }

    public static boolean problem5(String input) {
        /**
         * Takes a string, and returns if it is valid by rules of parenthesis
         * @param input the string to be checked
         * @return whether it was valid
         */
        Stack<Character> chars = new Stack<>();

        for (char c : input.toCharArray()) {
            if (!(c == '(' || c == '{' || c == '[' || c == ')' || c == ']' || c == '}')) {
                return false;
            }
            if (c == '(' || c == '{' || c == '[') {
                chars.push(c);
            } else {
                if (chars.isEmpty()) {
                    return false;
                }
                char top = chars.pop();
                if (c == ')' && top != '(') {
                    return false;

                } else if (c == ']' && top != '[') {
                    return false;

                } else if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return chars.isEmpty();
    }

    public static int[] problem6(int[] head1, int[] head2) {
        /**
         * merges two sorted lists
         * @param head1 the first list
         * @param head2 the second list
         * @return      the merged list
         */
        int[] sorted = new int[head1.length + head2.length];
        int h1 = 0;
        int h2 = 0;
        int i = 0;
        while (h1 < head1.length || h2 < head2.length) {
            if (h1 == head1.length) {
                sorted[i] = head2[h2];
                h2++;
            } else if (h2 == head2.length) {
                sorted[i] = head1[h1];
                h1++;
            } else if (head1[h1] < head2[h2]) {
                sorted[i] = head1[h1];
                h1++;
            } else {
                sorted[i] = head2[h2];
                h2++;
            }
            i++;
        }
        return sorted;
    }

    public static int[] problem7(int[] digits) {
        /**
         * returns one to a number in array format
         * @param digits the number in array format
         * @return       the added number
         *
         */
        int indexReached = digits.length - 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            }
            digits[i] = 0;
            indexReached--;
        }
        if (indexReached == -1) {
            int[] output = new int[digits.length + 1];
            Arrays.fill(output, 0);
            output[0] = 1;
            return output;
        }

        return digits;
    }
}
