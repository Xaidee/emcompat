package xaidee.emcompat.mods;

import gg.moonflower.pollen.api.platform.Platform;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.MushroomColonyBlock;
import xaidee.emcompat.CompatHandler;
import xaidee.emcompat.CompatObjects;

import java.util.function.Supplier;

public class FarmersDelight {

    private static final BlockBehaviour.Properties CABINET = BlockBehaviour.Properties.copy(Blocks.BARREL);

    public static void init() {
        // Empty function to load class
    }

    // Cabinets
    public static final RegistryObject<Block> TOADSTOOL_CABINET = registerBlock("toadstool_cabinet", () -> new CabinetBlock(CABINET), "biomesoplenty");
    public static final RegistryObject<Block> BOP_GLOWSHROOM_CABINET = registerBlock("glowshroom_cabinet", () -> new CabinetBlock(CABINET), "biomesoplenty");

    public static final RegistryObject<Block> DD_GLOWSHROOM_CABINET = registerBlock("glowshroom_cabinet", () -> new CabinetBlock(CABINET), "darkerdepths");

    // Mushroom Colonies
    public static final RegistryObject<Block> TOADSTOOL_COLONY = registerBlock("toadstool_colony", () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(CompatObjects.TOADSTOOL.get()), CompatObjects.TOADSTOOL_ITEM), "biomesoplenty");
    public static final RegistryObject<Block> BOP_GLOWSHROOM_COLONY = registerBlock("glowshroom_colony", () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(CompatObjects.BOP_GLOWSHROOM.get()), CompatObjects.BOP_GLOWSHROOM_ITEM), "biomesoplenty");

    // TODO: Fix issue caused by the Glowshroom's "clusters" property.
    //public static final RegistryObject<Block> DD_GLOWSHROOM_COLONY = registerBlock("glowshroom_colony", () -> new MushroomColonyBlock(BlockBehaviour.Properties.copy(CompatObjects.DD_GLOWSHROOM.get()), CompatObjects.DD_GLOWSHROOM_ITEM), "darkerdepths");

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> block, String modid) {
        boolean isModLoaded = Platform.isModLoaded(modid);
        return CompatHandler.registerBlock(modid + "/" + name, block, isModLoaded ? vectorwing.farmersdelight.FarmersDelight.CREATIVE_TAB : null);
    }
}
