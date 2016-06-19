package com.tomtomtom09.campcraft.block;

import com.tomtomtom09.campcraft.creativetab.CCItemTab;
import com.tomtomtom09.campcraft.handler.EnumTentType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockCamoTent extends BlockCamoTentBase
{
    public BlockCamoTent(String unlocalizedName, int tentSize)
    {
        super(unlocalizedName, tentSize);
    }
}


