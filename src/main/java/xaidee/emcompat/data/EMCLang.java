package xaidee.emcompat.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;
import xaidee.emcompat.CompatHandler;
import xaidee.emcompat.EMCompatibilities;

import java.util.function.Supplier;

public class EMCLang extends LanguageProvider {

    public EMCLang(DataGenerator generator) {
        super(generator, EMCompatibilities.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (Supplier<? extends Block> block : CompatHandler.BLOCKS.getEntries())
            putIfAbsent(block);
        for (Supplier<? extends Item> item : CompatHandler.ITEMS.getEntries())
            putIfAbsent(item);
    }

    private void putIfAbsent(Supplier<? extends ForgeRegistryEntry<?>> registryEntry) {
        String key = registryEntry.get().getRegistryName().getPath();
        String value = formatString(key);
        try {
            add(key, value);
        } catch (Exception ignored) {}
    }

    private String formatString(String key) {
        String[] strArr = key.split("_");
        StringBuffer res = new StringBuffer();
        for (String str : strArr) {
            char[] stringArray = str.trim().toCharArray();
            stringArray[0] = Character.toUpperCase(stringArray[0]);
            str = new String(stringArray);

            res.append(str).append(" ");
        }
        return res.toString().trim();
    }
}
