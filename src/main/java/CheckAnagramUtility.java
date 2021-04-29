import org.apache.groovy.parser.antlr4.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CheckAnagramUtility {

    public List<Integer> anagramStartIndex(String s, String p){
        List<Integer> startIndexList= new ArrayList<>();

        if(s== null || p== null || StringUtils.isEmpty(s) || StringUtils.isEmpty(p)){
            return startIndexList;
        }

        for(int i=0; i<=s.length()-p.length(); i++){
            if(areAnagrams(s.substring(i, p.length()+i), p)){
                startIndexList.add(i);
            }
        }

        return startIndexList;
    }

    private boolean areAnagrams(String s1, String s2){
        if(s1== null || s2== null || StringUtils.isEmpty(s1) || StringUtils.isEmpty(s2)){
            return false;
        }

        if(s1.length()!= s2.length()){
            return false;
        }

        int [] asciiCharArr= new int[256];
        s1= s1.toLowerCase();
        s2= s2.toLowerCase();

        for(int i=0; i<s1.length(); i++){
            asciiCharArr[s1.charAt(i)]++;
            asciiCharArr[s2.charAt(i)]--;
        }

        for(int i=0; i<asciiCharArr.length; i++){
            if(asciiCharArr[i]!= 0){
                return false;
            }
        }
        return true;
    }
}
