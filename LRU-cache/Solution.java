class LRUCache {

    Map<Integer, Integer> cache;
    List<Integer> order;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        order = new ArrayList<>();
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        // update usage
        //System.out.println("Get " + key + " " + order.toString());
        if (order.contains(key)) {
            order.remove(order.indexOf(key));
            order.add(key);
            //System.out.println("Appended " + key + " " + order.toString());
        }
        
        if (cache.get(key) != null)
            return cache.get(key);
        return -1;
    }
    
    public void put(int key, int value) {
        //System.out.println(order.toString());
        //System.out.println(cache.toString());
        
        if (cache.get(key) == null && cache.size() < capacity) {
            order.add(key);
            cache.put(key, value);
            return;
        }
        
        if (cache.get(key) != null && cache.size() < capacity) {
            int temp = order.get(order.indexOf(key));
            order.remove(order.indexOf(key));
            order.add(key);
            cache.put(key, value);
        }
        
        // check order (remove least used IFF size > capacity)
        if (cache.size() == capacity && cache.get(key) == null) {
            // we'll add new one and remove least used (0)
            int leastUsed = order.get(0);
            order.remove(0);
            cache.remove(leastUsed);
            order.add(key);
            //System.out.println("Removed: " + leastUsed);
            cache.put(key, value);
        }

        // updating existing
        else if (cache.size() == capacity && cache.get(key) != null) {
            // remove it, add it as last used
            
            int temp = order.get(order.indexOf(key));
            //System.out.println("Timeout here");
            order.remove(order.indexOf(key));
            order.add(key);
            cache.put(key, value);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
