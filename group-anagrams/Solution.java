/* I spent some time doing this one and I over-used some data structure. 
* I don't believe it is in the optimal shape.
* 
* Runtime: 70 ms, faster than 6.57% of Java online submissions for Group Anagrams.
* Memory Usage: 43.6 MB, less than 59.06% of Java online submissions for Group Anagrams.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> originalSorted = new
            HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            char[] t = strs[i].toCharArray();
            Arrays.sort(t);
            String sorted = new String(t);
            if(originalSorted.get(sorted) != null) {
                List<String> temp = new ArrayList<>();
                temp = originalSorted.get(sorted);
                temp.add(strs[i]);
                originalSorted.put(sorted, temp);
            }
            else {
                List<String> temp = new ArrayList<>();
                //temp = originalSorted.get(sorted);
                temp.add(strs[i]);
                originalSorted.put(sorted, temp);
            }
            strs[i] = sorted;            
        }
        
        Arrays.sort(strs);
        
        List<List<String>> mainList;
        mainList = new ArrayList<>();
        //mainList.add(new ArrayList<>());
        
        ArrayList<String> same = new ArrayList<String>();
        
        for(int i = 1, j=0; i < strs.length; i++, j++)
        {
            System.out.println(strs[i].equals(strs[i-1]));
            if (strs[i].equals(strs[i-1])) {
                same.add(strs[i-1]);
                same.add(strs[i]);
                i++;
                continue;
        }
            else same.add(strs[i-1]);
            
            mainList.add(same);
            same = new ArrayList<String>();
        }
        if (same.size() > 0) mainList.add(same);
            //return mainList;
        
        List<List<String>> q;
        q = new ArrayList<>();
        //mainList.add(new ArrayList<>());
        
        ArrayList<String> p;
        for(Map.Entry<String, List<String>> entry : originalSorted.entrySet()){
            p = new ArrayList<String>();
            for(String z : entry.getValue())
                p.add(z);
            q.add(p);
        }
        return q;
    }
}
