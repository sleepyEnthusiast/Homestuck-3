package bahis.homestuckv3;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import bahis.homestuckv3.data.*;
import bahis.homestuckv3.util.ModEventListeners;

public class Homestuckv3 implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "homestuckv3";
    public static final Logger LOGGER = LoggerFactory.getLogger("homestuckv3");

	public static final Identifier INITIAL_SYNC = new Identifier(MOD_ID, "initial_sync");


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            PlayerData playerState = StateSaverAndLoader.getPlayerState(handler.getPlayer());
            PacketByteBuf data = PacketByteBufs.create();

			int[] gristCacheArray = playerState.getGristCache().stream()
                .mapToInt(Integer::intValue)
                .toArray();
			data.writeIntArray(gristCacheArray);
            server.execute(() -> {
                ServerPlayNetworking.send(handler.getPlayer(), INITIAL_SYNC, data);
            });
        });

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModEventListeners.RegisterPickupItem();

		//LOGGER.info("Hello Fabric world!");
	}
}