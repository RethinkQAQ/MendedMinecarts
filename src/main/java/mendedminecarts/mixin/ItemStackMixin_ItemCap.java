package mendedminecarts.mixin;

import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemStack.class)
public class ItemStackMixin_ItemCap {
    //TODO: Add support to 1.21

//    @Inject(
//            method = "<init>(Lnet/minecraft/nbt/NbtCompound;)V",
//            at = @At("RETURN")
//    )
//    private void readCustomCount(NbtCompound nbt, CallbackInfo ci) {
//        if (MendedMinecartsMod.NO_CART_ITEM_CAP.isEnabled()) {
//            if (nbt.contains("CustomCount")) {
//                this.count = nbt.getInt("CustomCount");
//            }
//        }
//    }
//    @Inject(
//            method = "writeNbt(Lnet/minecraft/nbt/NbtCompound;)Lnet/minecraft/nbt/NbtCompound;",
//            at = @At("RETURN")
//    )
//    private void writeCustomCount(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
//        if (MendedMinecartsMod.NO_CART_ITEM_CAP.isEnabled()) {
//            if (this.count != (byte)this.count) {
//                nbt.putInt("CustomCount", this.count);
//            }
//        }
//    }
}
