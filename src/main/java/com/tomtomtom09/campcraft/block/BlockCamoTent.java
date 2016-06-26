package com.tomtomtom09.campcraft.block;

import com.tomtomtom09.campcraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCamoTent extends BlockCamoTentBase
{

    public BlockCamoTent(String unlocalizedName, int tentSize, int tentType)
    {
        super(unlocalizedName, tentSize, tentType);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(worldIn.isRemote)
        {
            return true;
        }
        boolean Open = false;
        Block block = worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock();
        EnumFacing tentMeta = state.getValue(FACING);
        //System.out.println(areaId);
        if (block.getMaterial() == null)
        {
            Open = true;
        }
        if (Open)
        {
            if (TentSize == 1)
            {
                new BlockPos(pos.getX(), pos.getY() - 2, pos.getZ());
            }
            //else if (TentSize == 2) { j = j - 3; }
            //else if (TentSize == 3) { j = j - 4; }
        }
        if (CampHammerEquipped(playerIn))
        {
            if (!Open)
            {
                if (this.scanFoundation(worldIn, pos, state, playerIn) && this.ScanArea(worldIn, pos, state, playerIn))
                {
                    if (TentSize == 1)
                    {
                        if (tentMeta == EnumFacing.NORTH) //North Tent
                        {
                            this.buildNorthSmall(worldIn, pos);
                            this.buildNorthSmallEquipment(worldIn, pos);
                        } else if (tentMeta == EnumFacing.EAST) //East Tent
                        {
                            this.buildEastSmall(worldIn, pos);
                            this.buildEastSmallEquipment(worldIn, pos);
                        } else if (tentMeta == EnumFacing.SOUTH) //South Tent
                        {
                            this.buildSouthSmall(worldIn, pos);
                            this.buildSouthSmallEquipment(worldIn, pos);
                        } else if (tentMeta == EnumFacing.WEST) //West Tent
                        {
                            this.buildWestSmall(worldIn, pos);
                            this.buildWestSmallEquipment(worldIn, pos);
                        }
                    }
                }
            }
        }
            return true;
    }
}