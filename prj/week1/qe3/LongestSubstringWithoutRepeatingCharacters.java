package leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
//		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(l.lengthOfLongestSubstring("bbbbbbb"));
//		System.out.println(l.lengthOfLongestSubstring("pwwkew"));
//		System.out.println(l.lengthOfLongestSubstring("ckilbkd"));
//		System.out.println(l.lengthOfLongestSubstring("tmmzuxt"));
//		System.out.println(l.lengthOfLongestSubstring("ohvhjdml"));
		System.out.println(l.lengthOfLongestSubstring("izoqdvahnflhotu"));
//		System.out.println(l.lengthOfLongestSubstring("zlfhmkgcbhcwpnjqequcdrbvncwrlztmkzvyjbaklciaqrtwhpangeiugensdhgpgcnrfnbqsktkdogndjalniftmvnrcui"));
//		System.out.println(l.lengthOfLongestSubstring("jeufutixpjlqvaotuwemehuxsdkpotpyzjdtcostxdkvfaozwuocdkavnmkefzeeijamxsixyusduiftcvvgfxbvjozqndv"));
	}

	public int lengthOfLongestSubstring2(String s) {
		if(s.length()<1){
			return 0;
		}
		int cnt =0;
		do{
			for (int i = 0; i <= cnt ; i++) {
				HashSet<String> set = new HashSet();
				int x = i;
				int y = s.length() - (cnt - i);
				String[] list = s.substring(x, y).split("");
				for (String str : list) {
					set.add(str);
				}
				if(list.length == set.size()){
					return set.size();
				}
			}
			cnt++;
		}while(cnt <= s.length());

		return 0;
	}

	public int lengthOfLongestSubstring3(String s) {
		int ret = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, start = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c))
				start = Math.max(map.get(c)+1, start);  //중복 되지 않는 문자열의 시작 위치
			ret = Math.max(ret, i-start+1); //중복 되지 않는 문자열의 길이
			map.put(c, i);
		}
		return ret;
	}

	public int lengthOfLongestSubstring(String s) {
		int result = 0;
		int start = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)){
				start = Math.max(map.get(c)+1, start);
			}
			result = Math.max(result, i-start+1);
			map.put(c, i);
		}

		return result;
	}
}
