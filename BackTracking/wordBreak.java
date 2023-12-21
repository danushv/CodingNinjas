//Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

//Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

class Solution {
    Map<String, Boolean> map=new HashMap<String,Boolean>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)
        return true;
        if(map.containsKey(s))
        return map.get(s);
        for(int i=0;i<s.length();i++)
        {
          String left = s.substring(0,i+1);

          if(wordDict.contains(left)&& wordBreak(s.substring(i+1),wordDict))  {
          map.put(s,true);
          return true;
          }
        }
        map.put(s,false);
        return false;

    }
}
