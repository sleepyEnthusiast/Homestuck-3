package bahis.homestuckv3.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import bahis.homestuckv3.util.ModEventListeners.PickupItemCallBack;

@Mixin(ItemEntity.class)
public class PickupMixin {
    @Inject(at = @At(value = "INVOKE", target = "net/minecraft/entity/player/PlayerInventory.insertStack (Lnet/minecraft/item/ItemStack;)Z"), method = "onPlayerCollision", cancellable = true)
    private void onPickup(final PlayerEntity player, CallbackInfo info) {
        ActionResult result = PickupItemCallBack.EVENT.invoker().interact(player, (ItemEntity) (Object) this);

        if (result == ActionResult.FAIL) {
            info.cancel();
        }
    }
}
