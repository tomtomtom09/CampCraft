package com.tomtomtom09.campcraft.init;

import com.tomtomtom09.campcraft.block.BlockCC;
import com.tomtomtom09.campcraft.block.BlockCamoTent;
import com.tomtomtom09.campcraft.block.BlockFabric;
import com.tomtomtom09.campcraft.reference.Names;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    //blocks to make tent with
    public static Block tentFabric;
    //Tent Camo
    public static Block camoSmallTent;


    public static void init()
    {
        tentFabric = new BlockFabric().setUnlocalizedName("tentFabric");
        camoSmallTent = new BlockCamoTent().setUnlocalizedName("camoSmallTent");
    }

    public static void register()
    {
        GameRegistry.registerBlock(tentFabric, tentFabric.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(camoSmallTent, camoSmallTent.getUnlocalizedName().substring(5));
    }

    public  static void registerRenders()
    {
        registerRender(tentFabric);
        registerRender(camoSmallTent);
    }

    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
