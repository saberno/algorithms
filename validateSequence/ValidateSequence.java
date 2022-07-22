import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * true example:
 * 14
 * 12 13 1 100 15 6 33 55 -1 34 35 10 110 120
 * 4
 * 1 6 -1 10
 *
 * false example:
 * 13
 * 12 13 1 100 15 6 33 55 -1 34 35 110 120
 * 4
 * 1 6 -1 10
 */
public class ValidateSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainArraySize;
        int subsequenceArraySize;
        List<Integer> mainArray = new ArrayList<>();
        List<Integer> subsequenceArray = new ArrayList<>();
        mainArraySize = scanner.nextInt();
        for (int i = 0; i < mainArraySize; i++) {
            mainArray.add(scanner.nextInt());
        }
        subsequenceArraySize = scanner.nextInt();
        for (int i = 0; i < subsequenceArraySize; i++) {
            subsequenceArray.add(scanner.nextInt());
        }
        System.out.println(isSubsequence(mainArray, subsequenceArray));
    }

    private static boolean isSubsequence(List<Integer> mainArray, List<Integer> otherArray) {
        int valueIndex = 0;
        for (int i = 0; i < otherArray.size(); i++) {
            valueIndex = findValueIndex(mainArray, valueIndex, otherArray.get(i));
            if (valueIndex == -1) {
                return false;
            } else {
                valueIndex++;
            }
        }
        return true;
    }

    private static int findValueIndex(List<Integer> mainArray, int startIndex, int value) {
        if (startIndex >= mainArray.size()) {
            return -1;
        }
        for (int i = startIndex; i < mainArray.size(); i++) {
            if (mainArray.get(i) == value) {
                return i;
            }
        }
        return -1;
    }
}
