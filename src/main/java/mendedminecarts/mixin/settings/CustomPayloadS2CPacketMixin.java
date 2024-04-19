package mendedminecarts.mixin.settings;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mendedminecarts.settings.SettingSync;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.common.CustomPayloadS2CPacket;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CustomPayloadS2CPacket.class)
public class CustomPayloadS2CPacketMixin {
    //Add the MendedMinecartsSetting to the Reader
    @WrapOperation(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    remap = false,
                    target = "Lcom/google/common/collect/ImmutableMap;builder()Lcom/google/common/collect/ImmutableMap$Builder;",
                    ordinal = 0
            )
    )
    private static ImmutableMap.Builder<Identifier, PacketByteBuf.PacketReader<?>> put_MendedMinecartsSettings(Operation<ImmutableMap.Builder<Identifier, PacketByteBuf.PacketReader<?>>> original) {
        ImmutableMap.Builder<Identifier, PacketByteBuf.PacketReader<?>> instance = original.call();
        instance.put(SettingSync.CHANNEL, SettingSync.MendedMinecartsSettingPayload::new);
        return instance;
    }
}
