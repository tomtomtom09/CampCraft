package com.tomtomtom09.campcraft.block;

import com.tomtomtom09.campcraft.creativetab.CCItemTab;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFabricDoor extends BlockDoor
{
    public BlockFabricDoor(String unlocalizedName)
    {
        super(Material.cloth);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CCItemTab.CC_TAB);
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
}