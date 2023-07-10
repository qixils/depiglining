package dev.qixils.depiglining.mixin;

import dev.qixils.depiglining.Depiglining;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.WorldGenLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldGenRegion.class)
public abstract class WorldGenRegionMixin implements WorldGenLevel {

    @Inject(method = "addFreshEntity", at=@At("HEAD"), cancellable = true)
    public void addEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (Depiglining.TO_REMOVE.remove(entity.getUUID())) {
            cir.setReturnValue(false);
            entity.remove();
        }
    }
}
