package com.tomtomtom09.campcraft.item;

import com.tomtomtom09.campcraft.creativetab.CCItemTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;

public class ItemFabricDoor extends ItemDoor
{
    public ItemFabricDoor(Block block)
    {
        super(block);
        this.setCreativeTab(CCItemTab.CC_TAB);
    }
}
