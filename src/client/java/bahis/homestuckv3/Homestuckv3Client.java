package bahis.homestuckv3;

import java.util.Arrays;

import bahis.homestuckv3.util.ModEventListeners;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.text.Text;

public class Homestuckv3Client implements ClientModInitializer {

	public static PlayerData playerData = new PlayerData();
	
	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(Homestuckv3.INITIAL_SYNC, (client, handler, buf, responseSender) -> {
            String nameCache = buf.readString();
			int[] valueCache = buf.readIntArray();
			playerData.setGristCacheWithArray(nameCache, valueCache);

			client.execute(() -> { // Prevents error on sending player message before player is initialised, better to queue it so it can be executed when player is created.
                client.player.sendMessage(Text.literal("Grist Cache: " + Arrays.toString(playerData.getValueCache())));
            });
            
        });
		
		ClientPlayNetworking.registerGlobalReceiver(ModEventListeners.GRIST_PICKUP, (client, handler, buf, responseSender) -> {
            String nameCache = buf.readString();
			int[] valueCache = buf.readIntArray();
			playerData.setGristCacheWithArray(nameCache, valueCache);
            
			client.player.sendMessage(Text.literal("Grist Cache: " + Arrays.toString(playerData.getValueCache())));
        });
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}	
}