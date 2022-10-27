package xaidee.emcompat.mods;

import biomesoplenty.common.util.CreativeModeTabBOP;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import xaidee.emcompat.CompatHandler;
import xaidee.emcompat.Woodset;

import java.util.function.Supplier;

public class BiomesOPlenty {

    public static void init() {
        // Empty function to load class
    }

    // Toadstool
    private static final Woodset TOADSTOOL = new Woodset(MaterialColor.WOOL, MaterialColor.COLOR_ORANGE);

    public static final RegistryObject<Block> TOADSTOOL_STEM = registerBlock("toadstool_stem", TOADSTOOL::log);
    public static final RegistryObject<Block> TOADSTOOL_HYPHAE = registerBlock("toadstool_hyphae", TOADSTOOL::wood);
    public static final RegistryObject<Block> STRIPPED_TOADSTOOL_STEM = registerBlock("stripped_toadstool_stem", TOADSTOOL::stripped_log);
    public static final RegistryObject<Block> STRIPPED_TOADSTOOL_HYPHAE = registerBlock("stripped_toadstool_hyphae", TOADSTOOL::stripped_wood);

    public static final RegistryObject<Block> TOADSTOOL_PLANKS = registerBlock("toadstool_planks", TOADSTOOL::planks);
    public static final RegistryObject<Block> TOADSTOOL_SLAB = registerBlock("toadstool_slab", TOADSTOOL::slab);
    public static final RegistryObject<Block> TOADSTOOL_STAIRS = registerBlock("toadstool_stairs", () -> TOADSTOOL.stairs(TOADSTOOL_PLANKS));
    public static final RegistryObject<Block> TOADSTOOL_PRESSURE_PLATE = registerBlock("toadstool_pressure_plate", TOADSTOOL::pressurePlate);
    public static final RegistryObject<Block> TOADSTOOL_BUTTON = registerBlock("toadstool_button", TOADSTOOL::button);
    public static final RegistryObject<Block> TOADSTOOL_FENCE = registerBlock("toadstool_fence", TOADSTOOL::fence);
    public static final RegistryObject<Block> TOADSTOOL_FENCE_GATE = registerBlock("toadstool_fence_gate", TOADSTOOL::fenceGate);
    public static final RegistryObject<Block> TOADSTOOL_DOOR = registerBlock("toadstool_door", TOADSTOOL::door);
    public static final RegistryObject<Block> TOADSTOOL_TRAPDOOR = registerBlock("toadstool_trapdoor", TOADSTOOL::trapdoor);

    // Glowshroom
    private static final Woodset GLOWSHROOM = new Woodset(MaterialColor.TERRACOTTA_CYAN, MaterialColor.COLOR_LIGHT_BLUE, 5);

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
        return CompatHandler.registerBlock("biomesoplenty/" + name, block, CreativeModeTabBOP.INSTANCE);
    }
}
