package bahis.homestuckv3;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectSet;

public class PlayerData {
    // Object int map, stores an instance of an item next to a number of it.
    public Object2IntMap<String> gristCache;

    public PlayerData() {    
        // initialise the grist

        gristCache = new Object2IntOpenHashMap<>();
        gristCache.defaultReturnValue(0);

        gristCache.put("item.homestuckv3.amber", 0);
        gristCache.put("item.homestuckv3.amethyst", 0);
        gristCache.put("item.homestuckv3.artifact", 0);
        gristCache.put("item.homestuckv3.buildgrist", 0);
        gristCache.put("item.homestuckv3.caulk", 0);
        gristCache.put("item.homestuckv3.chalk", 0);
        gristCache.put("item.homestuckv3.cobalt", 0);
        gristCache.put("item.homestuckv3.diamond", 0);
        gristCache.put("item.homestuckv3.garnet", 0);
        gristCache.put("item.homestuckv3.gold", 0);
        gristCache.put("item.homestuckv3.iodine", 0);
        gristCache.put("item.homestuckv3.marble", 0);
        gristCache.put("item.homestuckv3.mercury", 0);
        gristCache.put("item.homestuckv3.quartz", 0);
        gristCache.put("item.homestuckv3.ruby", 0);
        gristCache.put("item.homestuckv3.rust", 0);
        gristCache.put("item.homestuckv3.shale", 0);
        gristCache.put("item.homestuckv3.sulfur", 0);
        gristCache.put("item.homestuckv3.tar", 0);
        gristCache.put("item.homestuckv3.uranium", 0);
        gristCache.put("item.homestuckv3.zillium", 0);
    }
    


    public void addGrist(String ID, int amount) {
        gristCache.computeInt(ID, (key, value) -> (value == null) ? amount : value + amount); // i dont know i have no idea, damn technically "better" ways to do things
    }

    public void removeGrist(String ID, int amount) {
        gristCache.computeInt(ID, (key, value) -> (value == null) ? 0 : Math.max(0, value - amount));
    }
    

    public Object2IntMap<String> getGristCache() {
        return gristCache;
    }

    public int[] getValueCache() {
        return gristCache.values().toIntArray();
    }

    public String getNameCache() {
        ObjectSet<String> keySet = gristCache.keySet();
        return String.join(",", keySet);
    }

    public void setGristCache (Object2IntMap<String> newCache) {
        gristCache.clear();
        gristCache.putAll(newCache);
    }

    public void setGristCacheWithArray(String nameCache, int[] valueCache) {
        String[] nameCacheArray = nameCache.split(",");
        gristCache.clear();
        for (int x = 0; x < valueCache.length && x < nameCacheArray.length; x++) {
            gristCache.put(nameCacheArray[x], valueCache[x]);
        }
    }
    
    
}
