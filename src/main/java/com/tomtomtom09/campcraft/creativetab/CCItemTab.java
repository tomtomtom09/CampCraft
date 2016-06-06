package com.tomtomtom09.campcraft.creativetab;


import com.tomtomtom09.campcraft.init.ModItems;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CCItemTab
{
    public static final CreativeTabs EE3_TAB = new CreativeTabs(Reference.LOWERCASE_MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.tentEquipment;
        }
    };
}
