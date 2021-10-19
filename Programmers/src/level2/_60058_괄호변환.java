class Solution {
	static boolean flag;

	public String solution(String p) {
		String answer = "";

		int uIdx = 0, diff = 0;

		// 1
		if (p.length() == 0) {
			return null;
		}

		if (chkRight(p))
			return p;

		// 2
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				diff++;
			} else {
				diff--;
			}
			if (diff == 0) { // 균형 맞음 -> u
				uIdx = i;
				break;
			}
		}
		String u = p.substring(0, uIdx + 1);
		String v = p.substring(uIdx + 1);

		// 3
		if (chkRight(u)) {
			answer = u;
			answer = answer.concat(solution(v));
		} else {
			// 4
			if (uIdx == p.length() - 1) {
				// v가 빈 문자열일 경우
				answer = makeU(u);
			} else {
				answer = makeU(u, v);
			}
			return answer;
		}

		return answer;
	}

	public String makeU(String u) {
		// 4-1,2,3
		String str = "()";

		// 4-4
		u = u.substring(1, u.length() - 1);

		// 4-5
		u = u.replace("(", ":");
		u = u.replace(")", "(");
		u = u.replace(":", ")");
		str = str.concat(u);

		return str;
	}

	public String makeU(String u, String v) {

		// 4-1,2,3
		String str = "(";
		str = str.concat(solution(v));
		str = str.concat(")");

		// 4-4
		u = u.substring(1, u.length() - 1);

		// 4-5
		u = u.replace("(", ":");
		u = u.replace(")", "(");
		u = u.replace(":", ")");
		str = str.concat(u);

		return str;

	}

	public boolean chkRight(String p) {
		flag = true;

		if (p.charAt(0) == ')')
			return false;
		// 무조건 열린 괄호부터 시작해야 올바른 괄호 문자열

		int chk = 1; // 첫 시작은 열린 괄호
		for (int i = 1; i < p.length(); i++) {
			// 닫힘이 더 많이 나오는 순간 올바르지 않음 chk 증감 해서 더 많이 나오면 false
			if (p.charAt(i) == '(')
				chk++;
			else
				chk--;
			if (chk < 0)
				return false;
		}
		return flag;
	}
}