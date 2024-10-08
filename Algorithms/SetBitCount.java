public class SetBitCount {
    // Brian Kernighan’s Algorithm:
    // method to count set bits in a given number
    static int countSetBits(int n) {
        int setBits = 0;
        while (n > 0) {
            n &= (n - 1);
            setBits++;
        }
        return setBits;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(countSetBits(n));
    }
}