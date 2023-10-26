package dev.qixils.depiglining.forge;

import dev.qixils.depiglining.Depiglining;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;

@Mod(Depiglining.MOD_ID)
public class DepigliningForge {
    public DepigliningForge() {
        Depiglining.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStopping(FMLServerStoppingEvent event) {
        Depiglining.stop();
    }
}