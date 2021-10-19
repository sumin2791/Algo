import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;  
        
        str1 = str1.replaceAll("[^a-zA-Z]"," ");
        str1 = str1.toUpperCase();
        str2 = str2.replaceAll("[^a-zA-Z]"," ");
        str2 = str2.toUpperCase();
        
        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();
        for (int i = 0; i < str1.length()-1; i++) {
            String str = str1.substring(i,i+2);
            if(!str.contains(" ")){
                aList.add(str);
            }
        }
        for (int i = 0; i < str2.length()-1; i++) {
            String str = str2.substring(i,i+2);
            if(!str.contains(" ")){
                bList.add(str);
            }
        }
  
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        for(int i=0; i<aList.size(); i++){
            if(bList.remove(aList.get(i)))
                intersection.add(aList.get(i));
            union.add(aList.get(i));
        }      
        for(int i=0; i<bList.size(); i++){
            union.add(bList.get(i));
        }

        if(union.size()==0){
            return 65536;
        }

        answer = 65536*intersection.size()/union.size();
        return answer;
    }
}
