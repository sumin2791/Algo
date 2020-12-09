import java.util.Scanner;

public class JUNGOL1863종교 {

	static int N, M, cnt;
	static int[] parents;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
		cnt = 0;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			Union(a, b);
		}
		
		System.out.println(N-cnt);
	}

	static public int Find(int x) {
		if (parents[x] == x)
			return x;
		else
			return parents[x] = Find(parents[x]);
	}

	static public void Union(int x, int y) {
		if (Find(x) != Find(y)) {
			cnt++;
			parents[Find(y)] = Find(x);
		}
	}

}
