import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IsomorphicStrings {
public boolean isIsomorphic(String s, String t) {

    List<Character> cl = s.chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList());
    List<Character> tl = t.chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList());

    if(cl.size()!=tl.size()){
    return false;
    }

    Map<Character, Character> map = new HashMap<>();
    for(int i=0;i<s.length();i++){
        if(map.containsKey(s.charAt(i)) && !map.get(s.charAt(i)).equals(t.charAt(i))){
            return false;
        }else{
            map.put(s.charAt(i), t.charAt(i));
        }
    }

    return true;
}

}

/*

Leetcode solution

class Solution {
    private String transformString(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);

            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }

            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
}


 */