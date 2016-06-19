package com.tomtomtom09.campcraft.item;

import com.tomtomtom09.campcraft.block.BlockSleepingBag;
import com.tomtomtom09.campcraft.creativetab.CCItemTab;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSleepingBag extends ItemBed
{
    private Block block2;

    public ItemSleepingBag(Block block)
    {
        super();
        maxStackSize = 64;
        block2 = block;
        this.setCreativeTab(CCItemTab.CC_TAB);
    }
    /**
     * Called when a Block is right-clicked with this Item
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else if (side != EnumFacing.UP)
        {
            return false;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();
            boolean flag = block.isReplaceable(worldIn, pos);

            if (!flag)
            {
                pos = pos.up();
            }

            int i = MathHelper.floor_double((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            EnumFacing enumfacing = EnumFacing.getHorizontal(i);
            BlockPos blockpos = pos.offset(enumfacing);

            if (playerIn.canPlayerEdit(pos, side, stack) && playerIn.canPlayerEdit(blockpos, side, stack))
            {
                boolean flag1 = worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
                boolean flag2 = flag || worldIn.isAirBlock(pos);
                boolean flag3 = flag1 || worldIn.isAirBlock(blockpos);

                if (flag2 && flag3 && World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) && World.doesBlockHaveSolidTopSurface(worldIn, blockpos.down()))
                {
                    IBlockState iblockstate1 = block2.getDefaultState().withProperty(BlockSleepingBag.OCCUPIED, Boolean.valueOf(false)).withProperty(BlockSleepingBag.FACING, enumfacing).withProperty(BlockSleepingBag.PART, BlockSleepingBag.EnumPartType.FOOT);

                    if (worldIn.setBlockState(pos, iblockstate1, 3))
                    {
                        IBlockState iblockstate2 = iblockstate1.withProperty(BlockSleepingBag.PART, BlockSleepingBag.EnumPartType.HEAD);
                        worldIn.setBlockState(blockpos, iblockstate2, 3);
                    }

                    --stack.stackSize;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
    }
}
