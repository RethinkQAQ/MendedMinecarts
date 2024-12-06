package mendedminecarts.mixin.settings;

import mendedminecarts.settings.SettingSync;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.packet.s2c.common.CustomPayloadS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mixin(CustomPayloadS2CPacket.class)
public class CustomPayloadS2CPacketMixin {
    //Add the MendedMinecartsSetting to the Reader
    @ModifyArg(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/network/packet/CustomPayload;createCodec(Lnet/minecraft/network/packet/CustomPayload$CodecFactory;Ljava/util/List;)Lnet/minecraft/network/codec/PacketCodec;"
            )
    )
    private static List<?> put_MendedMinecartsSettings(List<CustomPayload.Type<?,?>> types) {
        types = new ArrayList<>(types);
        types.add(new CustomPayload.Type<>(SettingSync.MendedMinecartsSettingPayload.ID, SettingSync.MendedMinecartsSettingPayload.CODEC));
        return Collections.unmodifiableList(types);
    }
}
