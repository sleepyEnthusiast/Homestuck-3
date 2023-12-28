package bahis.homestuckv3.data;

import java.util.concurrent.CompletableFuture;

import bahis.homestuckv3.Homestuckv3;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    
    public static final TagKey<Item> gristTag = TagKey.of(RegistryKeys.ITEM, new Identifier(Homestuckv3.MOD_ID, "grist"));


    public ModTags() {
        
    }

}

