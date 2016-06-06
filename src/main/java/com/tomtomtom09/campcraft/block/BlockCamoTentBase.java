package com.tomtomtom09.campcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCamoTentBase extends Block
{
    public BlockCamoTentBase(Material material)
    {
        super(material);
    }

    public BlockCamoTentBase()
    {
        this(Material.cloth);
    }
}
