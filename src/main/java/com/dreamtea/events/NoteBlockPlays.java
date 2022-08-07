package com.dreamtea.events;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SculkSensorBlock;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.listener.GameEventListener;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.NoteBlock.NOTE;
import static net.minecraft.world.event.GameEvent.NOTE_BLOCK_PLAY;

public class NoteBlockPlays {

  public static int addNoteBlockVariance(ServerWorld world, BlockPos pos, GameEvent event) {
    if (event.equals(NOTE_BLOCK_PLAY)) {
      BlockState block = world.getBlockState(pos);
      if (block.isOf(Blocks.NOTE_BLOCK)) {
        return noteToComparator(block.get(NOTE));
      }
    }
    return SculkSensorBlock.FREQUENCIES.getInt(event);
  }

  public static int noteToComparator(int note){
    return (note) % 12 + 1;
  }
}
