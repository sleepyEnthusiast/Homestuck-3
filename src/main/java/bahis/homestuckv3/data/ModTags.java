package bahis.homestuckv3.data;

import bahis.homestuckv3.Homestuckv3;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    
    public static final TagKey<Item> gristTag = TagKey.of(RegistryKeys.ITEM, new Identifier(Homestuckv3.MOD_ID, "grist"));


    public ModTags() {
        
    }

}

