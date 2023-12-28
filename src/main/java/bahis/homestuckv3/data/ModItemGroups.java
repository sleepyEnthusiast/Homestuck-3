package bahis.homestuckv3.data;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import bahis.homestuckv3.Homestuckv3;

public class ModItemGroups {
    public static final ItemGroup Grist = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Homestuckv3.MOD_ID, "buildgrist"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.grist"))
                    .icon(() -> new ItemStack(ModItems.buildgrist)).entries((displayContext, entries) -> {
                        entries.add(ModItems.amber);
                        entries.add(ModItems.amethyst);
                        entries.add(ModItems.artifact);
                        entries.add(ModItems.buildgrist);
                        entries.add(ModItems.caulk);
                        entries.add(ModItems.chalk);
                        entries.add(ModItems.cobalt);
                        entries.add(ModItems.diamond);
                        entries.add(ModItems.garnet);
                        entries.add(ModItems.gold);
                        entries.add(ModItems.iodine);
                        entries.add(ModItems.marble);
                        entries.add(ModItems.mercury);
                        entries.add(ModItems.quartz);
                        entries.add(ModItems.ruby);
                        entries.add(ModItems.rust);
                        entries.add(ModItems.shale);
                        entries.add(ModItems.sulfur);
                        entries.add(ModItems.tar);
                        entries.add(ModItems.uranium);
                        entries.add(ModItems.zillium);
                        
                        // add more items here
                    }).build());


    public static void registerItemGroups() {
        Homestuckv3.LOGGER.info("Registering Item Groups for " + Homestuckv3.MOD_ID);
    }
}