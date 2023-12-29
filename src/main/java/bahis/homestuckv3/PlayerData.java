package bahis.homestuckv3;

import java.util.Arrays;
import java.util.List;

public class PlayerData {
    // Serves as a look up table for the index needed for gristNum
    public List<String> gristIDs = Arrays.asList(
        "item.homestuckv3.amber",
        "item.homestuckv3.amethyst",
        "item.homestuckv3.artifact",
        "item.homestuckv3.buildgrist",
        "item.homestuckv3.caulk",
        "item.homestuckv3.chalk",
        "item.homestuckv3.cobalt",
        "item.homestuckv3.diamond",
        "item.homestuckv3.garnet",
        "item.homestuckv3.gold",
        "item.homestuckv3.iodine",
        "item.homestuckv3.marble",
        "item.homestuckv3.mercury",
        "item.homestuckv3.quartz",
        "item.homestuckv3.ruby",
        "item.homestuckv3.rust",
        "item.homestuckv3.shale",
        "item.homestuckv3.sulfur",
        "item.homestuckv3.tar",
        "item.homestuckv3.uranium",
        "item.homestuckv3.zillium"
    );
    // You know what i hate? jsons. 
    public List<Integer> gristCache = Arrays.asList( 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    
    public void addGrist(String ID, int amount) {
        int index = gristIDs.indexOf(ID);
        gristCache.set(index, gristCache.get(index) + amount);
    }

    public void removeGrist(String ID, int amount) {
        int index = gristIDs.indexOf(ID);
        gristCache.set(index, gristCache.get(index) - amount);
    }

    public List<Integer> getGristCache() {
        return gristCache;
    }

    public void setGristCache(List<Integer> newCache) {
        gristCache = newCache;
    }
    
}
