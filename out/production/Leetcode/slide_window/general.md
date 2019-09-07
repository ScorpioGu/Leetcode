   
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
    
        // 初始化一个集合或者数或者字符串保存结果，根据题目的需求
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        // 保存字符的每个字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // 计数器，对窗口计数，作为判断条件
        int counter = map.size();

        int begin = 0, end = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(end < s.length()){
            
            char c = s.charAt(end);//get a character
            
            // 更新map和counter
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            
            // while循环中，左指针向右移动。
            // 如果要求最小窗口，那么这个循环是from valid to invalid，然后最优值的更新是在循环内
            // 如果要求最大窗口，那么这个循环是from invalid to valid, 然后最优值的更新是在循环外
            while(counter == 0 /* counter condition. different question may have different condition */){
                
                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }
                
                /*在这里更新最小窗口*
                
                begin++;
            }
            
            /*在这里更新最大窗口*/
            
            end++;
        }
        return result;
    }
}
