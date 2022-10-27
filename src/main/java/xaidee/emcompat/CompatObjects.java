package xaidee.emcompat;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CompatObjects {

    public static final Supplier<Block> TOADSTOOL = makeCompatObject("biomesoplenty:toadstool", Registry.BLOCK);
    public static final Supplier<Item> TOADSTOOL_ITEM = makeCompatObject("biomesoplenty:toadstool", Registry.ITEM);
    public static final Supplier<Block> BOP_GLOWSHROOM = makeCompatObject("biomesoplenty:glowshroom", Registry.BLOCK);
    public static final Supplier<Item> BOP_GLOWSHROOM_ITEM = makeCompatObject("biomesoplenty:glowshroom", Registry.ITEM);

    public static final Supplier<Block> DD_GLOWSHROOM = makeCompatObject("darkerdepths:glowshroom", Registry.BLOCK);
    public static final Supplier<Item> DD_GLOWSHROOM_ITEM = makeCompatObject("darkerdepths:glowshroom", Registry.ITEM);

    private static <T> Supplier<@Nullable T> makeCompatObject(String name, Registry<T> registry) {
        return Suppliers.memoize(() -> registry.getOptional(new ResourceLocation(name)).orElse(null));
    }
}
