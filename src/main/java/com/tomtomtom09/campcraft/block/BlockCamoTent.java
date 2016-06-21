package com.tomtomtom09.campcraft.block;

import com.tomtomtom09.campcraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

public class BlockCamoTent extends BlockCamoTentBase
{
    private int TentType = 0;

    public BlockCamoTent(String unlocalizedName, int tentSize, int tentType)
    {
        super(unlocalizedName, tentSize, tentType);
        TentType = tentType;
    }

    /**Gets the Fabric block for tents*/
    public int getTentType(int tentType)
    {
        if(tentType == 1) {return 0;}
        else if(tentType == 2) {return 1;}
        else if(tentType == 3) {return 2;}
        else if(tentType == 4) {return 3;}
        else if(tentType == 5) {return 4;}
        else if(tentType == 6) {return 5;}
        else if(tentType == 7) {return 6;}
        else if(tentType == 8) {return 7;}
        else if(tentType == 9) {return 8;}
        else if(tentType == 10) {return 9;}
        return 0;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState blockstate = fabric.getStateFromMeta(getTentType(TentType));
        
        /**Add Fabric Blocks lvl 1*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY(),pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY(),pos.getZ() - 0), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 2), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 0), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() + 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() - 2), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() + 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY(),pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY(),pos.getZ() - 0), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() - 2), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() - 0), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() + 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 2), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 1), blockstate);
        /**Add Fabric Blocks lvl 2*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 0), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() - 2), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 0), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() - 2), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 1), blockstate);
        /**Add Fabric Blocks lvl 3*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 0), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 2), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 0), blockstate);
        /**Add Fabric Blocks lvl 4*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 1), blockstate);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 0), blockstate);
        return false;
    }
}