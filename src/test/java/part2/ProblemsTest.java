package part2;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProblemsTest {
    @org.junit.jupiter.api.Test
    void problem1() {
        int[][] inputs = {{2, 7, 11}, {3, 2, 4}, {3, 3}, {1, 5, 4}, {4, 6, 2}};
        int[] targets = {9, 6, 6, 5, 8};
        int[][] expecteds = {{0, 1}, {1, 2}, {0, 1}, {0, 2}, {1, 2}};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Input: " + Arrays.toString(inputs[i]));
            System.out.println("Target: " + targets[i]);
            System.out.println("Expected: " + Arrays.toString(expecteds[i]));
            int[] result = Problems.problem1(inputs[i], targets[i]);
            System.out.println();
            assertArrayEquals(expecteds[i], result);
        }
    }

    @org.junit.jupiter.api.Test
    void problem2() {
        int[] inputs = {121, -121, 10, 99, 9, 9999, 69696, 4554, 45541, 0};
        boolean[] expecteds = {true, false, false, true, true, true, true, true, false, true};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Input: " + inputs[i]);
            System.out.println("Expected: " + expecteds[i]);
            boolean result = Problems.problem2(inputs[i]);
            assertEquals(expecteds[i], result);
            System.out.println();
        }
    }

    @org.junit.jupiter.api.Test
    void problem3() {
        String[][] inputs = {{"flower", "flow", "flight"}, {"dog", "racecar", "car"}, {"nela", "nice", "neat"}};
        String[] expecteds = {"fl", "", "n"};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Input: " + Arrays.toString(inputs[i]));
            System.out.println("Expected: " + expecteds[i]);
            String result = Problems.problem3(inputs[i]);
            assertEquals(expecteds[i], result);
            System.out.println();
        }
    }

    @org.junit.jupiter.api.Test
    void problem4() {
        String[] inputs = {"III", "LVIII", "MCMXCIV", "XXIX", "MCMXCIX", "XCI", "MMII"};
        int[] expecteds = {3, 58, 1994, 29, 1999, 91, 2002};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Input: " + inputs[i]);
            System.out.println("Expected: " + expecteds[i]);
            int result = Problems.problem4(inputs[i]);
            assertEquals(expecteds[i], result);
            System.out.println();
        }
    }

    @org.junit.jupiter.api.Test
    void problem5() {
        String[] inputs = {"()", "()[]{}", "(]", "nela", "([{}])", "([{]})", "((())", ")(", "())"};
        boolean[] expecteds = {true, true, false, false, true, false, false, false, false};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Input: " + inputs[i]);
            System.out.println("Expected: " + expecteds[i]);
            boolean result = Problems.problem5(inputs[i]);
            assertEquals(expecteds[i], result);
            System.out.println();
        }
    }

    @org.junit.jupiter.api.Test
    void problem6() {
        int[][] inputs1 = {{1, 2, 4}, {}, {}, {0}, {-1, 0, 1}};
        int[][] inputs2 = {{1, 3, 4}, {}, {0}, {0}, {0, 1, 2}};
        int[][] expecteds = {{1, 1, 2, 3, 4, 4}, {}, {0}, {0, 0}, {-1, 0, 0, 1, 1, 2}};

        for (int i = 0; i < inputs1.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Input1: " + Arrays.toString(inputs1[i]));
            System.out.println("Input2: " + Arrays.toString(inputs2[i]));
            System.out.println("Expected: " + Arrays.toString(expecteds[i]));
            int[] result = Problems.problem6(inputs1[i], inputs2[i]);
            assertArrayEquals(expecteds[i], result);
            System.out.println();
        }
    }

    @org.junit.jupiter.api.Test
    void problem7() {
        int[][] inputs = {{1, 2, 3}, {4, 3, 2, 1}, {9}, {9, 9, 9}, {8, 9, 9}};
        int[][] expecteds = {{1, 2, 4}, {4, 3, 2, 2}, {1, 0}, {1, 0, 0, 0}, {9, 0, 0}};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Test case " + (i + 1));
            System.out.println("Input: " + Arrays.toString(inputs[i]));
            System.out.println("Expected: " + Arrays.toString(expecteds[i]));
            int[] result = Problems.problem7(inputs[i]);

            assertArrayEquals(expecteds[i], result);
            System.out.println();
        }
    }
}