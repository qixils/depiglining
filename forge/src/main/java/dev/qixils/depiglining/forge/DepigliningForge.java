package dev.qixils.depiglining.forge;

import dev.qixils.depiglining.Depiglining;
import net.minecraftforge.fml.common.Mod;

@Mod(Depiglining.MOD_ID)
public class DepigliningForge {
    public DepigliningForge() {
        Depiglining.init();
    }
}