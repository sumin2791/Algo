class Solution {
    public long solution(long w, long h) {
        long answer = w * h;
        long gcd = gcd(w, h);

        answer -= (gcd * ((w / gcd) + (h / gcd) - 1));

        return answer;
    }

    public static long gcd(long x, long y) {
        long tmp, a, b;
        if (x > y) {
            a = x;
            b = y;
        } else {
            a = y;
            b = x;
        }

        while (a % b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }

        return b;

    }
}
