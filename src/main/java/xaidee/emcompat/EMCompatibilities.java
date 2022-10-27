package xaidee.emcompat;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xaidee.emcompat.data.EMCLang;

@Mod(EMCompatibilities.MOD_ID)
public class EMCompatibilities {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "emcompat";
    public static final String MOD_NAME = "Enhanced Mushrooms: Compatibilities";

    public EMCompatibilities() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::gatherData);

        DeferredRegister<?>[] registers = {
                CompatHandler.ITEMS,
                CompatHandler.BLOCKS,
                CompatHandler.ENTITIES
        };

        for (DeferredRegister<?> register : registers) {
            register.register(modEventBus);
        }

        CompatHandler.initOptionalRegistries();
    }

    private void setup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }

    private void clientSetup(FMLClientSetupEvent event) {

    }

    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        if(event.includeClient()) {
            generator.addProvider(new EMCLang(generator));
        }
        if(event.includeServer()) {
            
        }
    }
}
