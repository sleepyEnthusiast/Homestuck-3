package bahis.homestuckv3.util;

import bahis.homestuckv3.Homestuckv3;
import bahis.homestuckv3.PlayerData;
import bahis.homestuckv3.StateSaverAndLoader;
import bahis.homestuckv3.data.ModTags;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;


public class ModEventListeners {
    /*
        * Callback for picking up an item.
        * Called before the item is picked up.
        * Upon return:
        * - SUCCESS cancels further processing and continues with normal behaviour.
        * - PASS falls back to further processing and defaults to SUCCESS if no other listeners are available
        * - FAIL cancels further processing and deletes the item, NEED TO IMPLEMENT ADDING TO GRIST CACHE.
    */

    public static final Identifier GRIST_PICKUP = new Identifier(Homestuckv3.MOD_ID, "grist_pickup");
    
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
                item.discard(); // delete item entity

                PlayerData playerState = StateSaverAndLoader.getPlayerState(player);
                // add grist by amount in stack
                playerState.addGrist(currentItem.getTranslationKey(), currentItem.getCount());
                
                
                // Send a packet to the client
                MinecraftServer server = player.getServer();
 
                PacketByteBuf data = PacketByteBufs.create();
                int[] gristCacheArray = playerState.getGristCache().stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
                
                data.writeIntArray(gristCacheArray);
 
                ServerPlayerEntity playerEntity = server.getPlayerManager().getPlayer(player.getUuid());
                server.execute(() -> {
                    ServerPlayNetworking.send(playerEntity, GRIST_PICKUP, data);
                });

                return ActionResult.FAIL;
            }
            
            return ActionResult.SUCCESS;
        });
    }

    
}
