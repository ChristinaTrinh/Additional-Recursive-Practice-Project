//This project implements some recursive methods
public class AdditionalPracticeRecursive1 {
    public static void main(String[] args) {
        System.out.println();
        countDownRecursively(5);
        System.out.println();
        countUpRecursively(7);
        System.out.println();
        fractionCountUpRecursively(5);
        System.out.println();
        printEvenNums(5);
        System.out.println();
        printOddNums(5);
        System.out.println();
        print10sRecursively(6);
        System.out.println();
        printLettersRecursively(7);
        System.out.println();
        printLettersRecursivelyStartEnd(5, 10);
        System.out.println();
        printParenthesesRecursively(5);
        System.out.println();
        printRepetitiveNumber(3, 6);
        printTriangleRecursively(4);
        System.out.println(areDigitsAllEvenRecursively(24182));
        System.out.println(countNumberOf_Ks_Recursively(323345321, 3));
        printNumberBackwards(12345);
        System.out.println();
        System.out.println(reverseNumRecursively(12345));
        System.out.println(isPalindrome(1234521));
        System.out.println(powerRecursively(3, 5));
        System.out.println(hasDigit(12345, 6));
        System.out.println(areDigitsDecreasing(54321));
        System.out.println(countCinS("abcadaef", 'a'));
        int[] a = new int[] { 5, 4, 3, 2, 1 };
        System.out.println(isArraySortedDecreasingly(a, 0));

    }

    // Outputs the numbers from n to 1.
    // Ex 5, 4, 3, 2, 1 with n = 5
    public static void countDownRecursively(int n) {
        if (n != 0) {
            System.out.print(n + " ");
            countDownRecursively(n - 1);
        }
    }

    // Outputs the numbers from 1 to n.
    // Ex 1, 2, 3, 4, 5, 6, 7 with n = 7
    public static void countUpRecursively(int n) {
        if (n != 0) {
            countUpRecursively(n - 1);
            System.out.print(n + " ");
        }
    }

    // Outputs n number of fractions.
    // Ex. 1/1, ½. 1/3. ¼. 1/5 with n = 5
    public static void fractionCountUpRecursively(int n) {
        if (n != 0) {
            fractionCountUpRecursively(n - 1);
            System.out.print("1/" + n + " ");
        }
    }

    // Outputs n number of even numbers.
    // Ex, 2, 4, 6, 8, 10 with n = 5
    public static void printEvenNums(int n) {
        if (n != 0) {
            printEvenNums(n - 1);
            System.out.print(2 * n + " ");
        }
    }

    // Outputs n number of odd numbers.
    // Ex, 1, 3, 5, 7, 9 with n = 5
    public static void printOddNums(int n) {
        if (n != 0) {
            printOddNums(n - 1);
            System.out.print(2 * n - 1 + " ");
        }
    }

    // Output n terms of 10.
    // Ex 1, 10, 100, 1000, 10000, 100000 with n = 6
    public static void print10sRecursively(int n) {
        if (n != 0) {
            print10sRecursively(n - 1);
            System.out.print((int) Math.pow(10, n - 1) + " ");
        }
    }

    // Output n number of letters beginning with ‘a’.
    // Ex. a, b, c, d, e, f, g with n = 7
    public static void printLettersRecursively(int n) {
        if (n != 0) {
            printLettersRecursively(n - 1);
            System.out.print((char) (96 + n) + " ");
        }
    }

    // Output letters from ‘start’ to ‘end’.
    // Ex start = 5 end = 10 Output: e, f, g, h, I, j
    public static void printLettersRecursivelyStartEnd(int start, int end) {
        if (end >= start) {
            printLettersRecursivelyStartEnd(start, end - 1);
            System.out.print((char) (96 + end) + " ");
        }
    }

    // Outputs n number of pairs of parentheses.
    // Ex. ((((( ))))) with n = 5
    public static void printParenthesesRecursively(int n) {
        if (n > 0) {
            System.out.print("(");
            printParenthesesRecursively(n - 1);
            printParenthesesRecursively(-n);
        } else if (n < 0) {
            System.out.print(")");
        }
    }

    // Outputs ‘t’ n number of times.
    // Ex. t = 3 n = 6 Output: 333333
    public static void printRepetitiveNumber(int t, int n) {
        if (n != 0) {
            System.out.print(t);
            printRepetitiveNumber(t, n - 1);
        }
    }

    // Outputs a triangle of n rows with stars
    public static void printTriangleRecursively(int n) {
        if (n > 0) {
            printTriangleRecursively(n - 1);
            printTriangleRecursively(-n);
        } else if (n < 0) {
            System.out.print("*");
            printTriangleRecursively(n + 1);
        } else if (n == 0)
            System.out.println();
    }

    // Returns the number of digits in n.
    // Ex. 7 with n = 1234567
    public static int numberOfDigitsRecursively(int n) {
        if (n == 0)
            return 0;
        else {
            return 1 + numberOfDigitsRecursively(n - 1);
        }
    }

    // Returns true/false accordingly
    // Ex. true with n = 2468
    // Ex. false with n = 24568
    public static boolean areDigitsAllEvenRecursively(int n) {
        if (n == 0)
            return true;
        else if ((n != 0) && (n % 2 != 0))
            return false;
        return areDigitsAllEvenRecursively(n / 10);
    }

    // Returns the number of Ks in n.
    // Ex 4 with n = 323345321 and k = 3
    public static int countNumberOf_Ks_Recursively(long n, int k) {
        if (n == 0)
            return 0;
        else {
            if (n % 10 == k)
                return 1 + countNumberOf_Ks_Recursively(n / 10, k);
            else
                return countNumberOf_Ks_Recursively(n / 10, k);
        }
    }

    // Outputs n backwards one digit at a time
    // Ex 12345 => 54321
    public static void printNumberBackwards(int n) {
        if (n != 0) {
            System.out.print(n % 10);
            printNumberBackwards(n / 10);
        }
    }

    // Returns the number reversed.
    // Ex 12345 => 54321
    public static int reverseNumRecursively(int n) {
        if (n / 10 == 0)
            return n;
        else
            return n % 10 * (int) (Math.pow(10, String.valueOf(n).length() - 1)) + reverseNumRecursively(n / 10);
    }

    // Returns a^b
    public static int powerRecursively(int a, int b) {
        if (b == 0)
            return 1;
        else
            return a * powerRecursively(a, b - 1);
    }

    // Given n, tell whether it is a Palindrome or not.
    public static boolean isPalindrome(int n) {
        if (reverseNumRecursively(n) == n)
            return true;
        else
            return false;
    }

    // Given n, Returns if it has the digit k anywhere in it.
    // Ex1 n =12345 k=3 Returns true
    // Ex2 n = 12345 k=9 Returns false
    public static boolean hasDigit(int n, int k) {
        if (n == 0)
            return false;
        else {
            if (n % 10 == k)
                return true;
        }
        return hasDigit(n / 10, k);
    }

    // Given n, Returns if all its digits are decreasing.
    // Ex1 n = 54321 Returns true
    // Ex2 n = 54231 Returns false
    // Ex3 n = 54331 Returns false
    public static boolean areDigitsDecreasing(int n) {
        if (n / 10 == 0)
            return true;
        else if ((n % 10) >= ((n / 10) % 10))
            return false;
        return areDigitsDecreasing(n / 10);
    }

    // Returns how many of character c is in s
    // Ex1 s = “abcadaef” c = ‘a’ Returns 3
    // Ex2 s = “abcadaef” c = ‘z’ Returns 0
    public static int countCinS(String s, char c) {
        return helperCountCinS(s, c, s.length() - 1);
    }

    private static int helperCountCinS(String s, char c, int index) {
        if (index < 0)
            return 0;
        else if (s.charAt(index) == c)
            return 1 + helperCountCinS(s, c, index - 1);
        else
            return helperCountCinS(s, c, index - 1);
    }

    // Ex1 a = {5, 4, 3, 2, 1} Returns true
    // Ex2 a = {5, 4, 1, 2, 1} Returns false
    public static boolean isArraySortedDecreasingly(int[] a, int currentPosition) {
        if (currentPosition == a.length - 2 && a[currentPosition] > a[currentPosition + 1])
            return true;
        else if (a[currentPosition] <= a[currentPosition + 1])
            return false;
        return isArraySortedDecreasingly(a, currentPosition + 1);
    }
}
