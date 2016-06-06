package com.tomtomtom09.campcraft.block;

import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCC extends Block
{
    public BlockCC(Material material)
    {
        super(material);
    }

    public BlockCC()
    {
        this(Material.cloth);
    }

    /**
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
    //Textures.RESOURCE_PREFIX

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    /**
     @Override
     @SideOnly(Side.CLIENT)
     public void registerBlockIcons(IIconRegister iconRegister)
     {
     blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
     }*/
}
