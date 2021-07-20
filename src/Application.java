import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @date 20/07/2021 2:09 PM
 */
public class Application {
    public static void main(String[] args) {
        CyclicRotation.printArray(new int[]{3, 8, 9, 7, 6});
        CyclicRotation.printArray(CyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3));
    }
}

class CyclicRotation {
    static int[] solution(int[] array, int rotations) {

        /*
            [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
            [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
            [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
         */
        for (int index = 0; index < rotations; index++) {
            for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
                if (arrayIndex < array.length - 1) {
                    int current = array[arrayIndex];
                    int next = array[arrayIndex+1];
                    System.out.println(current + ", " + next);
                    array[index] = next;
                }
            }
            printArray(array);
        }
        System.out.println();

        return array;
    }

    static void printArray(int[] solution) {
        for (int item : solution) System.out.print(item + " ");
        System.out.println();
    }
}

class BinaryGap {
    static int solution(int N) {
        // converting umber to binary
        char[] binNArray = intToBin(N);

        // maximum gap for all time
        int maxGap = 0;
        int gap = 0;
        // 10000010001
        for (int index = 0; index < binNArray.length; index++) {
            if (binNArray[index] == '0')
                gap++;
            else if (binNArray[index] == '1') {
                if (maxGap < gap) maxGap = gap;
                gap = 0;
            }
        }
        return maxGap;
    }

    private static char[] intToBin(int n) {
        return Integer.toBinaryString(n).toCharArray();
    }
}

class CardsWar {
    public static int solution(String A, String B) {
        // write your code in Java SE 8
        Map<Character, Integer> cardRank = new HashMap<>();
        cardRank.put('2', 2);
        cardRank.put('3', 3);
        cardRank.put('4', 4);
        cardRank.put('5', 5);
        cardRank.put('7', 6);
        cardRank.put('6', 7);
        cardRank.put('8', 8);
        cardRank.put('9', 9);
        cardRank.put('T', 10);
        cardRank.put('J', 11);
        cardRank.put('Q', 12);
        cardRank.put('K', 13);
        cardRank.put('A', 14);


        // converting string to Character[]
        Character[] aCards = A.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Character[] bCards = B.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        int aliceScore = 0;
        for (int index = 0; index < aCards.length; index++) {
            if (cardRank.get(aCards[index]) > cardRank.get(bCards[index])) {
                System.out.println(aCards[index] + ", " + bCards[index]);
                aliceScore++;
            }
        }

        return aliceScore;
    }
}

class FairIndex {
    static int solution(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            sumB += B[i];
        }
        int count = 0;
        int tempA = A[0];
        int tempB = B[0];

        for (int i = 1; i < A.length; i++) {
            if (i != 1 && tempA == tempB && 2 * tempA == sumA && 2 * tempB == sumB) {
                count++;
            }
            tempA += A[i];
            tempB += B[i];
        }
        return count;
    }

}