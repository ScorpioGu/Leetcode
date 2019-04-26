## 求解满足一些限制条件的子串问题，通常使用hashmap配合双指针

```
int findSubstring(string s){
        vector<int> map(128,0);
        int counter; // check whether the substring is valid
        int begin=0, end=0; //two pointers, one point to tail and one  head
        int d; //the length of substring

        for() { /* initialize the hash map here */ }

        while(end<s.size()){

            if(map[s[end++]]-- ?){  /* modify counter here */ }

            while(/* counter condition */){ 
                 
                 /* update d here if finding minimum*/

                //increase begin to make it invalid/valid again
                
                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
            }  

            /* update d here if finding maximum*/
        }
        return d;
  }
```
## 如果是求解最小窗口，则在内循环中更新。如果是求解最大窗口，则是在外循环中更新。
```
    包含两个不同字符的最长窗口
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = 0;
        int l = 0, r = 0;
        //map存字符及其出现的次数
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length())
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while (map.size() > 2) {
                //先不断减少次数,并向右移动left,当次数到0的时候remove掉
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
```
