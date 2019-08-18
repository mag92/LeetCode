/* *
* Used DFS to see if all rooms are reachable.
* */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < rooms.size(); i++) {
            graph.put(i, rooms.get(i));
        }
        
        boolean[] visited = new boolean[rooms.size()];
        
        Stack<Integer> s = new Stack<>();
        
        for(Integer room : graph.keySet()) {
            s.push(room);
            while(s.isEmpty() == false) {
                Integer r = s.pop();
                if (visited[r] != true) {
                    visited[r] = true;
                    for(Integer x : graph.get(r)) {
                        if (visited[x] != true)
                            s.push(x);
                    }
                }
            }
            
            for(boolean b : visited)
                if (b == false)
                    return false;
            
        }
        return true;
    }
}
