package xaidee.emcompat.mods;

import biomesoplenty.common.util.CreativeModeTabBOP;
import com.teamaurora.enhanced_mushrooms.core.registry.util.Woodset;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import xaidee.emcompat.CompatHandler;

import java.util.function.Supplier;

public class DarkerDepths {

    public static void init() {
        // Empty function to load class
    }

    // Glowshroom
    private static final Woodset GLOWSHROOM = new Woodset(MaterialColor.WOOL, MaterialColor.COLOR_CYAN);

    public static final RegistryObject<Block> GLOWSHROOM_STEM = registerBlock("glowshroom_stem", GLOWSHROOM::log);
    public static final RegistryObject<Block> GLOWSHROOM_HYPHAE = registerBlock("glowshroom_hyphae", GLOWSHROOM::wood);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_STEM = registerBlock("stripped_glowshroom_stem", GLOWSHROOM::stripped_log);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_HYPHAE = registerBlock("stripped_glowshroom_hyphae", GLOWSHROOM::stripped_wood);

    public static final RegistryObject<Block> GLOWSHROOM_PLANKS = registerBlock("glowshroom_planks", GLOWSHROOM::planks);
    public static final RegistryObject<Block> GLOWSHROOM_SLAB = registerBlock("glowshroom_slab", GLOWSHROOM::slab);
    public static final RegistryObject<Block> GLOWSHROOM_STAIRS = registerBlock("glowshroom_stairs", () -> GLOWSHROOM.stairs(GLOWSHROOM_PLANKS));
    public static final RegistryObject<Block> GLOWSHROOM_PRESSURE_PLATE = registerBlock("glowshroom_pressure_plate", GLOWSHROOM::pressurePlate);
    public static final RegistryObject<Block> GLOWSHROOM_BUTTON = registerBlock("glowshroom_button", GLOWSHROOM::button);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE = registerBlock("glowshroom_fence", GLOWSHROOM::fence);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE_GATE = registerBlock("glowshroom_fence_gate", GLOWSHROOM::fenceGate);
    public static final RegistryObject<Block> GLOWSHROOM_DOOR = registerBlock("glowshroom_door", GLOWSHROOM::door);
    public static final RegistryObject<Block> GLOWSHROOM_TRAPDOOR = registerBlock("glowshroom_trapdoor", GLOWSHROOM::trapdoor);

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> block) {
        return CompatHandler.registerBlock("darkerdepths/" + name, block, CreativeModeTabBOP.INSTANCE);
    }
}