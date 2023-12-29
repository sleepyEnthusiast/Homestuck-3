package bahis.homestuckv3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bahis.homestuckv3.util.ModEventListeners;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.text.Text;

public class Homestuckv3Client implements ClientModInitializer {

	public static PlayerData playerData = new PlayerData();
	
	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(Homestuckv3.INITIAL_SYNC, (client, handler, buf, responseSender) -> {
            List<Integer> newCache = Arrays.stream(buf.readIntArray()).boxed().collect(Collectors.toList());
            playerData.setGristCache(newCache);

            client.execute(() -> {
                client.player.sendMessage(Text.literal("Grist Cache: " + playerData.getGristCache().toString()));
            });
        });
		
		ClientPlayNetworking.registerGlobalReceiver(ModEventListeners.GRIST_PICKUP, (client, handler, buf, responseSender) -> {
			List<Integer> newCache = Arrays.stream(buf.readIntArray()).boxed().collect(Collectors.toList());
            playerData.setGristCache(newCache);
 
            client.execute(() -> {
                client.player.sendMessage(Text.literal("Grist Cache: " + playerData.getGristCache().toString()));
            });
        });
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}