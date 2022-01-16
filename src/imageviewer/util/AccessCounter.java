package imageviewer.util;
import java.util.HashMap;

public class AccessCounter {
    final private HashMap<String,Integer> accesses = new HashMap<>();

    private AccessCounter() {}
    
    private static final AccessCounter instance = new AccessCounter();
    
    public static AccessCounter getInstance() {
        return instance;
    }
    
    public Integer increment (String key) {
        final Integer count;
        if(this.accesses.containsKey(key)){
            count = this.accesses.get(key)+1;
        } else {
            count = 1;
        }
        this.accesses.put(key, count);
        return count;
    }
}
