//This project implements some recursive methods
public class AdditionalPracticeRecursive2 {
    public static void main(String[] args) {
        starString(4);
        System.out.println();
        writeNums(5);
        System.out.println();
        writeSequence(8);
        System.out.println();
        System.out.println(doubleDigits(345));
        writeSquares(8);
        System.out.println();
        writeBinary(64);
        System.out.println();
        writeChars(8);
        System.out.println();
        System.out.println(multiplyEvens(4));
        System.out.println(sumTo(2));
        System.out.println(digitMatch(1072503891, 62530841));
        System.out.println(repeat("Hello", 3));
        System.out.println(isReverse("hello", "oLLeH"));
        System.out.println(indexOf("Barack Obama", "bam"));
        System.out.println(evenDigits(-34579));
        System.out.println(permut(6, 3));
    }

    // starString accepts an integer as a parameter and prints to the console a
    // string of stars (asterisks) that is 2n (i.e., 2 to the nth power) long
    public static void starString(int power) {
        if (power < 0)
            throw new IllegalArgumentException();

        helperStarString((int) Math.pow(2, power));
    }

    // This is the helper method of starString
    private static void helperStarString(int value) {
        if (value >= 1) {
            helperStarString(value - 1);
            System.out.print("*");
        }
    }

    // writeNums takes an integer n as a parameter and prints to the console the
    // first n integers starting with 1 in sequential order, separated by commas.
    public static void writeNums(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        else if (n == 1)
            System.out.print(n);
        else {
            writeNums(n - 1);
            System.out.print(", " + n);
        }
    }

    // writeSequence accepts an integer n as a parameter and prints to the console a
    // symmetric sequence of n numbers composed of descending integers that ends in
    // 1, followed by a sequence of ascending integers that begins with 1
    public static void writeSequence(int n) {
        if (n == 1)
            throw new IllegalArgumentException();

        int k = (int) Math.round((double) n / 2);
        helper1WriteSequence(k);
        helper2WriteSequence(k, n);
    }

    // This is the first helper method of writeSequence
    private static void helper1WriteSequence(int n) {
        if (n == 1)
            System.out.print(n + " ");

        else {
            System.out.print(n + " ");
            helper1WriteSequence(n - 1);
        }
    }

    // This is the second helper method of writeSequence
    private static void helper2WriteSequence(int k, int n) {
        if (k == 1 && n % 2 == 0)
            System.out.print(k + " ");
        else if (k > 1) {
            helper2WriteSequence(k - 1, n);
            System.out.print(k + " ");
        }
    }

    // doubleDigits accepts an integer n as a parameter and returns the integer
    // obtained by replacing every digit of n with two of that digit
    public static int doubleDigits(int num) {
        if (num == 0)
            return 0;
        else if (num / 10 == 0)
            return num * 11;
        else {
            int c = num % 10;
            return Integer.parseInt(doubleDigits(num / 10) + String.valueOf(c * 11));
        }
    }

    // writeSquares accepts an integer parameter n and prints the first n
    // squares separated by commas, with the odd squares in descending order
    // followed by the even squares in ascending order
    public static void writeSquares(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        helper1WriteSquares(n);
        helper2WriteSquares(n);
    }

    // This is the first helper method of writeSquares
    private static void helper1WriteSquares(int n) {
        if (n == 1)
            System.out.print(1);
        else {
            if (n % 2 != 0)
                System.out.print((int) Math.pow(n, 2) + ", ");
            helper1WriteSquares(n - 1);
        }
    }

    // This is the second helper method of writeSquares
    private static void helper2WriteSquares(int n) {
        if (n > 1) {
            helper2WriteSquares(n - 1);
            if (n % 2 == 0)
                System.out.print(", " + (int) Math.pow(n, 2));
        }
    }

    // writeBinary accepts an integer as a parameter and writes its binary
    // represen- tation to the console
    public static void writeBinary(int n) {
        for (int i = 7; i >= 0; i--) {
            if ((int) Math.pow(2, i) <= n) {
                helperWriteBinary(n, i);
                break;
            }
        }
    }

    // This is the helper method of writeBinary
    private static void helperWriteBinary(int n, int power) {
        if (n > 0 || power >= 0) {
            if (n / (int) Math.pow(2, power) != 0) {
                System.out.print(1);
                helperWriteBinary(n - (int) Math.pow(2, power), power - 1);
            } else if (n / (int) Math.pow(2, power) == 0) {
                System.out.print(0);
                helperWriteBinary(n, power - 1);
            }
        }
    }

    // writeChars accepts an integer parameter n and that prints out a total of
    // n char- acters. The middle character of the output should always be an
    // asterisk ("*"). If you are asked to write out an even number of characters,
    // then there will be two asterisks in the middle ("**"). Before the asterisk(s)
    // you should write out less-than characters ("<"). After the asterisk(s) you
    // should write out greater-than characters (">"). Your method should throw an
    // IllegalArgumentException if it is passed a value less than 1
    public static void writeChars(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        int k;
        if (n % 2 != 0) {
            k = (n - 1) / 2;
            helper1WriteChars(k);
            System.out.print("*");
        } else {
            k = (n - 2) / 2;
            helper1WriteChars(k);
            System.out.print("**");
        }
        helper2WriteChars(k);
    }

    // This is the first helper method of writeChars
    private static void helper1WriteChars(int k) {
        if (k > 0) {
            System.out.print("<");
            helper1WriteChars(k - 1);
        }
    }

    // This is the second helper method of writeChars
    private static void helper2WriteChars(int k) {
        if (k > 0) {
            System.out.print(">");
            helper2WriteChars(k - 1);
        }
    }

    // multiplyEvens returns the product of the first n even integers. For
    // example, multiplyEvens(1) returns 2 and multiplyEvens(4) returns 384 (because
    // 2 * 4 * 6 * 8 = 384). The method should throw an IllegalArgumentException if
    // it is passed a value less than or equal to 0
    public static int multiplyEvens(int n) {
        if (n == 0)
            throw new IllegalArgumentException();
        else if (n == 1)
            return 2;
        else
            return 2 * n * multiplyEvens(n - 1);
    }

    // sumTo accepts an integer parameter n and returns a real number
    // representing the sum of the first n reciprocals. In other words, sumTo(n)
    // returns (1 + 1/2 + 1/3 + 1/4 + ... + 1/n)
    public static double sumTo(int n) {
        if (n == 0)
            return 0.0;
        else if (n < 0)
            throw new IllegalArgumentException();
        else if (n == 1)
            return 1;
        else
            return sumTo(n - 1) + (double) 1 / n;
    }

    // digitMatch accepts two nonnegative integers as parameters and that
    // returns the number of digits that match between them. Two digits match if
    // they are equal and have the same position relative to the end of the number
    // (i.e., starting with the ones digit). In other words, the method should
    // compare the last digits of each number, the second-to-last digits of each
    // number, the third-to-last digits of each number, and so forth, counting how
    // many pairs match
    public static int digitMatch(int first, int second) {
        if (first > 0 && second > 0) {
            if (first % 10 == second % 10)
                return 1 + digitMatch(first / 10, second / 10);
            else
                return digitMatch(first / 10, second / 10);
        } else
            return 0;
    }

    // repeat accepts a string s and an integer n as parameters and that
    // returns s con- catenated together n times
    public static String repeat(String s, int n) {
        if (n == 0)
            return "";
        else if (n == 1)
            return s;
        else
            return s + repeat(s, n - 1);
    }

    // isReverse accepts two strings as parameters and returns true if the two
    // strings contain the same sequence of characters as each other but in the
    // opposite order (ignoring capitalization), and false otherwise
    public static boolean isReverse(String s1, String s2) {
        return helperIsReverse(s1.toLowerCase(), s2.toLowerCase(), 0, s2.length() - 1);
    }

    // This is the helper method of isReverse
    private static boolean helperIsReverse(String s1, String s2, int firstIndex, int secondIndex) {
        if (s1.length() != s2.length())
            return false;
        else if (secondIndex >= 0) {
            if (s1.charAt(firstIndex) != s2.charAt(secondIndex))
                return false;
            return helperIsReverse(s1, s2, firstIndex + 1, secondIndex - 1);
        }
        return true;
    }

    // indexOf accepts two strings as parameters and that returns the starting
    // index of the first occurrence of the second string inside the first string
    // (or 􏰁1 if not found)
    public static int indexOf(String s1, String s2) {
        return helperIndexOf(s1, s2, s1.length() - s2.length());
    }

    // This is the helper method of indexOf
    private static int helperIndexOf(String s1, String s2, int index) {
        if (index >= 0) {
            if (s1.substring(index, index + s2.length()).equals(s2))
                return index;
            else
                return helperIndexOf(s1, s2, index - 1);
        }
        return -1;
    }

    // evenDigits accepts an integer parameter and that returns the integer
    // formed by removing the odd digits from it
    public static int evenDigits(int n) {
        if (n == 0 || helperEvenDigits(Math.abs(n)) == Math.abs(n))
            return 0;
        else if (n > 0)
            return helperEvenDigits(Math.abs(n));
        else
            return -1 * helperEvenDigits(Math.abs(n));
    }

    // This is the helper method of evenDigits
    private static int helperEvenDigits(int n) {
        if (n / 10 == 0 && n % 2 == 0)
            return n;
        else if (n % 2 != 0)
            return helperEvenDigits(n / 10);
        else if (n % 2 == 0)
            return Integer.parseInt(String.valueOf(helperEvenDigits(n / 10)) + String.valueOf(n % 10));
        else
            return 0;
    }

    // permut accepts two integers n and r as parameters and returns the number
    // of unique permutations of r items from a group of n items. For given values
    // of n and r, this value P(n, r) can be com- puted as follows:
    // P(n,r) = (n!)/((n-r)!)
    public static int permut(int n, int r) {
        return helperPermut(n) / helperPermut(n - r);
    }

    // This is the helper method of permut
    private static int helperPermut(int n) {
        if (n == 0)
            return 1;
        return helperPermut(n - 1) * n;
    }
}
