package level3;

class 네트워크 {
	boolean[] v;
	
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n];
        
        for (int i = 0; i < n; i++) {
        	if(!v[i]) {
        		answer++;
        		dfs(computers,i);
        	}
		}
        return answer;
    }

	private void dfs(int[][] computers, int idx) {
		v[idx] = true;
		for (int i = 0; i < computers.length; i++) {
			if(i != idx && computers[idx][i] == 1 && !v[i]) {
				dfs(computers,i);
			}
		}
	}
}
