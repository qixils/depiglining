package dev.qixils.depiglining.fabric;

import dev.qixils.depiglining.Depiglining;
import net.fabricmc.api.ModInitializer;

public class DepigliningFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Depiglining.init();
    }
}