class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num+1;
            } else {
                String bin = Long.toBinaryString(num);
                for (int j = bin.length()-1; j >= 0; j--) {
                    if (bin.charAt(j) == '0') {
                        String str = bin.substring(0, j);
                        str = str.concat("10");
                        str = str.concat(bin.substring(j + 2));
                        answer[i] = Long.parseLong(str, 2);
                        break;
                    }
                    
                }
            }
            // long num = numbers[i], tmp = numbers[i];

            // boolean flag = true;
            // while (flag) {
            //     tmp++;
            //     long xor = num ^ tmp;
            //     String bin_xor = Long.toBinaryString(xor);
            //     int cnt = 0;
            //     for (int j = 0; j < bin_xor.length(); j++) {
            //         if (bin_xor.charAt(j) == '1') {
            //             cnt++;
            //             if (cnt > 2)
            //                 break;
            //         }
            //     }
            //     if (cnt <= 2) {
            //         answer[i] = tmp;
            //         flag = false;
            //     }
            // }
        }
        return answer;
    }
}