package com.dreamtea.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.LavaCauldronBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LavaCauldronBlock.class)
public class LavaCauldronMixin {
	@Inject(at = @At("RETURN"), method = "getComparatorOutput", cancellable = true)
	private void comparatorOutput(BlockState state, World world, BlockPos pos, CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(15);
	}
}
