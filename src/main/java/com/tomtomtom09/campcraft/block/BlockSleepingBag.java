package com.tomtomtom09.campcraft.block;

import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSleepingBag extends BlockBed
{
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        this.setBedBounds();
    }

    private void setBedBounds()
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
    }
}
