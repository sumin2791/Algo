package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Stock {
	private final static int CMD_INIT = 1;
	private final static int CMD_BUY = 2;
	private final static int CMD_SELL = 3;
	private final static int CMD_CANCEL = 4;
	private final static int CMD_BEST_PROFIT = 5;

	private final static UserSolution usersolution = new UserSolution();

	private static boolean run(BufferedReader br) throws Exception {
		StringTokenizer st;

		int numQuery;

		int mNumber, mStock, mQuantity, mPrice;

		int userAns, ans;

		boolean isCorrect = false;

		numQuery = Integer.parseInt(br.readLine());

		for (int q = 0; q < numQuery; ++q) {
			st = new StringTokenizer(br.readLine(), " ");

			int cmd;
			cmd = Integer.parseInt(st.nextToken());

			switch (cmd) {
				case CMD_INIT:
					usersolution.init();
					isCorrect = true;
					break;
				case CMD_BUY:
					mNumber = Integer.parseInt(st.nextToken());
					mStock = Integer.parseInt(st.nextToken());
					mQuantity = Integer.parseInt(st.nextToken());
					mPrice = Integer.parseInt(st.nextToken());
					userAns = usersolution.buy(mNumber, mStock, mQuantity, mPrice);
					ans = Integer.parseInt(st.nextToken());
					if (userAns != ans) {
						isCorrect = false;
					}
					break;
				case CMD_SELL:
					mNumber = Integer.parseInt(st.nextToken());
					mStock = Integer.parseInt(st.nextToken());
					mQuantity = Integer.parseInt(st.nextToken());
					mPrice = Integer.parseInt(st.nextToken());
					userAns = usersolution.sell(mNumber, mStock, mQuantity, mPrice);
					ans = Integer.parseInt(st.nextToken());
					if (userAns != ans) {
						isCorrect = false;
					}
					break;
				case CMD_CANCEL:
					mNumber = Integer.parseInt(st.nextToken());
					usersolution.cancel(mNumber);
					break;
				case CMD_BEST_PROFIT:
					mStock = Integer.parseInt(st.nextToken());
					userAns = usersolution.bestProfit(mStock);
					ans = Integer.parseInt(st.nextToken());
					if (userAns != ans) {
						isCorrect = false;
					}
					break;
				default:
					isCorrect = false;
					break;
			}
		}

		return isCorrect;
	}

	public static void main(String[] args) throws Exception {
		int TC, MARK;

		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}

class UserSolution {
	ArrayList<Integer[]> sell_list = new ArrayList<>();
	ArrayList<Integer[]> buy_list = new ArrayList<>();
	HashMap<Integer, ArrayList<Integer>> time = new HashMap<>();

	public void init() {
	}

	public int buy(int mNumber, int mStock, int mQuantity, int mPrice) {
		int min = Integer.MAX_VALUE, idx = -1;

		for (int i = 0; i < sell_list.size(); i++) {
			Integer[] sell = sell_list.get(i);
			if (sell[1] == mStock && sell[3] <= mPrice && sell[3] < min) {
				min = sell[3];
				idx = i;
			}
		}

		if (idx != -1) { // 체결할 수 있는 경우
			Integer[] sell = sell_list.get(idx);
			if (sell[2] > mQuantity) { // 매수주문보다 매도가 더 많을 때, 체결가 리스트 넣고 매도미체결량 수정하고 0 리턴
				addTime(mStock, sell[3]);
				sell[2] -= mQuantity;
				sell_list.add(idx, sell);
				// System.out.println("buy all");
				return 0;
			} else if (sell[2] == mQuantity) { // 양이 같을 경우 체결가 리스트, 매도미체결 지우고 0 리턴
				addTime(mStock, sell[3]);
				sell_list.remove(idx);
				// System.out.println("buy same");
				return 0;
			} else { // 매수가 매도가 더 많을 경우, 체결가 리스트에 넣고 매도미체결 지우고 남은 매수량 다음으로 넘기기
				addTime(mStock, sell[3]);
				sell_list.remove(idx);
				// System.out.println("buy next");
				return buy(mNumber, mStock, mQuantity - sell[2], mPrice);
			}
		}

		Integer[] buy = { mNumber, mStock, mQuantity, mPrice };
		buy_list.add(buy);
		// System.out.println("buy fail " + mQuantity);
		return mQuantity;
	}

	public int sell(int mNumber, int mStock, int mQuantity, int mPrice) {
		int max = 0, idx = -1;

		for (int i = 0; i < buy_list.size(); i++) {
			Integer[] buy = buy_list.get(i);
			if (buy[1] == mStock && buy[3] >= mPrice && buy[3] > max) {
				max = buy[3];
				idx = i;
			}
		}

		if (idx != -1) { // 체결할 수 있는 경우
			Integer[] buy = buy_list.get(idx);
			if (buy[2] > mQuantity) { // 매도주문보다 매수가 더 많을 때, 체결가 리스트 넣고 매수미체결량 수정하고 0 리턴
				addTime(mStock, buy[3]);
				buy[2] -= mQuantity;
				buy_list.add(idx, buy);
				// System.out.println("sell all");
				return 0;
			} else if (buy[2] == mQuantity) { // 양이 같을 경우 체결가 리스트, 매수미체결 지우고 0 리턴
				addTime(mStock, buy[3]);
				buy_list.remove(idx);
				// System.out.println("sell same");
				return 0;
			} else { // 매수보다 매도가 더 많을 경우, 체결가 리스트에 넣고 매수미체결 지우고 남은 매수량 다음으로 넘기기
				addTime(mStock, buy[3]);
				buy_list.remove(idx);
				// System.out.println("sell next");
				return sell(mNumber, mStock, mQuantity - buy[2], mPrice);
			}
		}

		Integer[] sell = { mNumber, mStock, mQuantity, mPrice };
		sell_list.add(sell);
		// System.out.println("sell fail " + mQuantity);
		return mQuantity;
	}

	public void cancel(int mNumber) {
		for (int i = 0; i < sell_list.size(); i++) {
			if (sell_list.get(i)[0] == mNumber) {
				sell_list.remove(i);
				break;
			}
		}
		for (int i = 0; i < buy_list.size(); i++) {
			if (buy_list.get(i)[0] == mNumber) {
				buy_list.remove(i);
				break;
			}
		}
		return;
	}

	public int bestProfit(int mStock) {
		ArrayList<Integer> list = time.get(mStock);
		int max = 0;

		for (int i = list.size() - 1; i > 0; i--) {
			for (int j = i; j >= 0; j--) {
				int a = list.get(i), b = list.get(j);
				if (max <= (a - b)) {
					max = a - b;
				}
			}
		}
		// System.out.println("bestProfit "+max);
		return max;
	}

	private void addTime(int mStock, Integer mPrice) {
		if (time.containsKey(mStock)) {
			ArrayList<Integer> list = time.get(mStock);
			list.add(mPrice);
			time.put(mStock, list);
		} else {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(mPrice);
			time.put(mStock, list);
		}
	}

}
