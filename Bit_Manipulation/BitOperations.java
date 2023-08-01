package Bit_Manipulation;

public class BitOperations {
	public static int getIthBit(int n, int i) {
		int bitMask = 1 << i;
		if ((n & bitMask) == 0)
			return 0;
		return 1;
	}
	public static int setIthBit(int n, int i) {
		int bitMask = 1 << i;
		return n | bitMask;
	}
	public static int clearIthBit(int n, int i) {
		int bitMask = ~(1 << i);
		return n & bitMask;
	}
	public static int updateIthBit(int n, int i, int newBit) {
		//Method 1
//		if (newBit == 0)
//			return clearIthBit(n, i);
//		else
//			return setIthBit(n, i);
		//Method 2
		int num = clearIthBit(n, i);
		int BitMask = newBit << i;
		return num |BitMask;
	}
	public static int clearIBits(int n, int i) {
		int bitMask = (~0) << i; // ~0 = -1; (-1)10 == (1 1 1 1 1 1 1 1)2
		return n & bitMask;
	}
	public static int clearIBitsinRange(int n, int i, int j) {
		int a = ((~0) << (j + 1));
		int b = (1 << i) - 1;
		int bitMask = a | b;
		return n & bitMask;
	}
	public static boolean isPowerOfTwo(int n) {
		return (n & (n - 1)) == 0;
	}
	public static int countSetBits(int n) {
		//O(log n)
		int count = 0;
		while(n > 0) {
			if ((n & 1) != 0)
				count++;
			n = n >>1;
		}
		return count;
	}
	public static int addOne(int x) {
         return -~x;
    }
	public static int moduloExpo(int a, int n, int p) {
		//performing n with power a and then do the modulus with p
		int ans = 1;
		while (n > 0) {
			if ((n & 1) != 0)
				ans = ans * a;
			a = a * a;
			n = n >> 1;
		}
		return ans % p;
	}
	public static int fastExpo(int a, int n) {
		int ans = 1;
		while(n > 0) {
			if ((n & 1) != 0)
				ans = ans * a;
			a = a * a;
			n = n >> 1;
		}
		return ans;
	}
	public static void main(String[] args) {
//		System.out.println(getIthBit(10, 2));
//		System.out.println(getIthBit(10, 3));
//		System.out.println(setIthBit(10, 2));
//		System.out.println(setIthBit(10, 3));
//		System.out.println(clearIthBit(10, 2));
//		System.out.println(clearIthBit(10, 3));
//		System.out.println(updateIthBit(10, 3, 0));
//		System.out.println(updateIthBit(10, 2, 1));
//		System.out.println(clearIBits(15, 2));
//		System.out.println(clearIBits(15, 3));
//		System.out.println(clearIBitsinRange(15, 2, 4));
//		System.out.println(clearIBitsinRange(10, 2, 4));
//		System.out.println(isPowerOfTwo(8));
//		System.out.println(isPowerOfTwo(10));
//		System.out.println(countSetBits(15));
//		System.out.println(countSetBits(8));
//		System.out.println(fastExpo(5, 3));
//		System.out.println(fastExpo(8, 2));
//		System.out.println(moduloExpo(10, 3, 4));
//		System.out.println(moduloExpo(10, 3, 3));
		System.out.println(addOne(10));
	}
}
