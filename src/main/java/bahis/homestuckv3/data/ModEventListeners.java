package bahis.homestuckv3.data;

import java.util.*;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;

public class ModEventListeners {
    /*
        * Callback for picking up an item.
        * Called before the item is picked up.
        * Upon return:
        * - SUCCESS cancels further processing and continues with normal behaviour.
        * - PASS falls back to further processing and defaults to SUCCESS if no other listeners are available
        * - FAIL cancels further processing and deletes the item, NEED TO IMPLEMENT ADDING TO GRIST CACHE.
    */

    public interface PickupItemCallBack {
        Event<PickupItemCallBack> EVENT = EventFactory.createArrayBacked(PickupItemCallBack.class, 
            (listeners) -> (player, item) -> {
                for (PickupItemCallBack listener : listeners) {
                    ActionResult result = listener.interact(player, item);
    
                    if (result != ActionResult.PASS) {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });
    
        ActionResult interact(PlayerEntity player, ItemEntity item); 
    }
    

    public static void RegisterPickupItem () {
        PickupItemCallBack.EVENT.register((player, item) -> {
            ItemStack currentItem = item.getStack();
            TagKey<Item> gristTag = ModTags.gristTag;

            if (currentItem.isIn(gristTag))
            {
                item.discard();
                return ActionResult.FAIL;
            }
            
            return ActionResult.SUCCESS;
        });
    }

    
}
