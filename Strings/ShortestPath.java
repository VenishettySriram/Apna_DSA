package Strings;

import java.util.Scanner;

public class ShortestPath {
	public static float shortestPath(String path) {
		int x = 0, y = 0;
		for (int i = 0; i < path.length(); i++) {
			char dir = path.charAt(i);
			//South
			if (dir == 'S') {
				y--;
			}
			//North
			else if (dir == 'N') {
				y++;
			}
			//East
			else if (dir == 'E') {
				x++;
			}
			else {
				x--;
			}

		}
		int X = x * x;
		int Y = y * y;
		return (float)Math.sqrt(X + Y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		System.out.println("Shortest Path is " + shortestPath(path));
	}
}
