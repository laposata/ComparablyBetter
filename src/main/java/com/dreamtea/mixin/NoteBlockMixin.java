package com.dreamtea.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.NoteBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import static com.dreamtea.events.NoteBlockPlays.noteToComparator;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {

  public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
    return noteToComparator(state.get(NoteBlock.NOTE));
  }
  public boolean hasComparatorOutput(BlockState state) {
    return true;
  }

}
