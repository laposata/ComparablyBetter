package com.dreamtea.mixin;

import com.dreamtea.events.NoteBlockPlays;
import net.minecraft.block.entity.SculkSensorBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.GameEventListener;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SculkSensorBlockEntity.class)
public class SculkSensorBlockEntityMixin {

  @Shadow
  private int lastVibrationFrequency;

  @Inject(method = "accept", at= @At(value = "INVOKE", target = "Lnet/minecraft/block/SculkSensorBlock;setActive(Lnet/minecraft/entity/Entity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)V"))
  public void addNoteBlockVariance(ServerWorld world, GameEventListener listener, BlockPos pos, GameEvent event, Entity entity, Entity sourceEntity, float distance, CallbackInfo ci){
    this.lastVibrationFrequency = NoteBlockPlays.addNoteBlockVariance(world, pos, event);
  }
}
