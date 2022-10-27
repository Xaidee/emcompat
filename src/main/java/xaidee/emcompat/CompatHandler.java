package xaidee.emcompat;

import gg.moonflower.pollen.api.platform.Platform;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xaidee.emcompat.EMCompatibilities;
import xaidee.emcompat.mods.BiomesOPlenty;
import xaidee.emcompat.mods.DarkerDepths;
import xaidee.emcompat.mods.FarmersDelight;

import java.util.function.Supplier;

public class CompatHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EMCompatibilities.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EMCompatibilities.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, EMCompatibilities.MOD_ID);

    public static final boolean
            farmersdelight = isLoaded("farmersdelight"),
            biomesoplenty = isLoaded("biomesoplenty"),
            darkerdepths = isLoaded("darkerdepths");

    private static boolean isLoaded(String name) {
        return Platform.isModLoaded(name);
    }

    public static void initOptionalRegistries() {
        if (biomesoplenty) BiomesOPlenty.init();
        if (darkerdepths) DarkerDepths.init();

        if (farmersdelight) FarmersDelight.init();
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> block, CreativeModeTab tab) {
        RegistryObject<B> blocks = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(blocks.get(), new Item.Properties().tab(tab)));
        return blocks;
    }
}
