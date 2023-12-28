package bahis.homestuckv3.data;

import java.util.*;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import bahis.homestuckv3.Homestuckv3;

public class ModItems {
    // Grist
    public static final Item amber = registerItem("amber", new Item(new FabricItemSettings()));
    public static final Item amethyst = registerItem("amethyst", new Item(new FabricItemSettings()));
    public static final Item artifact = registerItem("artifact", new Item(new FabricItemSettings()));
    public static final Item buildgrist = registerItem("buildgrist", new Item(new FabricItemSettings()));
    public static final Item caulk = registerItem("caulk", new Item(new FabricItemSettings()));
    public static final Item chalk = registerItem("chalk", new Item(new FabricItemSettings()));
    public static final Item cobalt = registerItem("cobalt", new Item(new FabricItemSettings()));
    public static final Item diamond = registerItem("diamond", new Item(new FabricItemSettings()));
    public static final Item garnet = registerItem("garnet", new Item(new FabricItemSettings()));
    public static final Item gold = registerItem("gold", new Item(new FabricItemSettings()));
    public static final Item iodine = registerItem("iodine", new Item(new FabricItemSettings()));
    public static final Item marble = registerItem("marble", new Item(new FabricItemSettings()));
    public static final Item mercury = registerItem("mercury", new Item(new FabricItemSettings()));
    public static final Item quartz = registerItem("quartz", new Item(new FabricItemSettings()));
    public static final Item ruby = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item rust = registerItem("rust", new Item(new FabricItemSettings()));
    public static final Item shale = registerItem("shale", new Item(new FabricItemSettings()));
    public static final Item sulfur = registerItem("sulfur", new Item(new FabricItemSettings()));
    public static final Item tar = registerItem("tar", new Item(new FabricItemSettings()));
    public static final Item uranium = registerItem("uranium", new Item(new FabricItemSettings()));
    public static final Item zillium = registerItem("zillium", new Item(new FabricItemSettings()));
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Homestuckv3.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Homestuckv3.LOGGER.info("Registering Mod Items for " + Homestuckv3.MOD_ID);

    }
}

