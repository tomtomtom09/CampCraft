package com.tomtomtom09.campcraft.item;

import com.tomtomtom09.campcraft.creativetab.CCItemTab;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCC extends Item
{
    public ItemCC()
    {
        super();
        this.setCreativeTab(CCItemTab.CC_TAB);
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
