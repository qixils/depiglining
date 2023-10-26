package dev.qixils.depiglining.fabric;

import dev.qixils.depiglining.Depiglining;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class DepigliningFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Depiglining.init();
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> Depiglining.stop());
    }
}