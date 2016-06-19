package com.tomtomtom09.campcraft.init;

import com.tomtomtom09.campcraft.block.*;
import com.tomtomtom09.campcraft.handler.EnumFabricType;
import com.tomtomtom09.campcraft.handler.EnumTentType;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
    /** Tent Update */
    public static Block tentFabric;
    public static Block camoSmallTent;
    public static Block jungleDoorBlock, desertDoorBlock, tundraDoorBlock, netherDoorBlock, pinkDoorBlock, yellowDoorBlock, brownDoorBlock, blackDoorBlock, blueDoorBlock, greenDoorBlock;
    public static Block jungleBedBlock, desertBedBlock, tundraBedBlock, netherBedBlock, pinkBedBlock, yellowBedBlock, brownBedBlock, blackBedBlock, blueBedBlock, greenBedBlock;

    public static void init()
    {
        /**Tent Update*/
        tentFabric = new BlockFabric("tentFabric");
        camoSmallTent = new BlockCamoTent("camoSmallTent", 1);
        /**Door*/
        jungleDoorBlock = (new BlockFabricDoor("doorJungle"));
        desertDoorBlock = (new BlockFabricDoor("doorDesert"));
        tundraDoorBlock = (new BlockFabricDoor("doorTundra"));
        netherDoorBlock = (new BlockFabricDoor("doorNether"));
        pinkDoorBlock = (new BlockFabricDoor("doorPink"));
        yellowDoorBlock = (new BlockFabricDoor("doorYellow"));
        brownDoorBlock = (new BlockFabricDoor("doorBrown"));
        blackDoorBlock = (new BlockFabricDoor("doorBlack"));
        blueDoorBlock = (new BlockFabricDoor("doorBlue"));
        greenDoorBlock = (new BlockFabricDoor("doorGreen"));
        /**Bed*/
        jungleBedBlock = (new BlockSleepingBag());
        desertBedBlock = (new BlockSleepingBag());
        tundraBedBlock = (new BlockSleepingBag());
        netherBedBlock = (new BlockSleepingBag());
        pinkBedBlock = (new BlockSleepingBag());
        yellowBedBlock = (new BlockSleepingBag());
        brownBedBlock = (new BlockSleepingBag());
        blackBedBlock = (new BlockSleepingBag());
        blueBedBlock = (new BlockSleepingBag());
        greenBedBlock = (new BlockSleepingBag());
    }

    public static void register()
    {
        /**Tent Update*/
        GameRegistry.registerBlock(tentFabric, ItemBlockMeta.class, "tentFabric");
        GameRegistry.registerBlock(camoSmallTent, ItemBlockMeta.class, "camoSmallTent");
        /**Door*/
        GameRegistry.registerBlock(jungleDoorBlock, "doorJungle");
        GameRegistry.registerBlock(desertDoorBlock, "doorDesert");
        GameRegistry.registerBlock(tundraDoorBlock, "doorTundra");
        GameRegistry.registerBlock(netherDoorBlock, "doorNether");
        GameRegistry.registerBlock(pinkDoorBlock, "doorPink");
        GameRegistry.registerBlock(yellowDoorBlock, "doorYellow");
        GameRegistry.registerBlock(brownDoorBlock, "doorBrown");
        GameRegistry.registerBlock(blackDoorBlock, "doorBlack");
        GameRegistry.registerBlock(blueDoorBlock, "doorBlue");
        GameRegistry.registerBlock(greenDoorBlock, "doorGreen");
        /**Bed*/
        GameRegistry.registerBlock(jungleBedBlock, "bedJungle");
        GameRegistry.registerBlock(desertBedBlock, "bedDesert");
        GameRegistry.registerBlock(tundraBedBlock, "bedTundra");
        GameRegistry.registerBlock(netherBedBlock, "bedNether");
        GameRegistry.registerBlock(pinkBedBlock, "bedPink");
        GameRegistry.registerBlock(yellowBedBlock, "bedYellow");
        GameRegistry.registerBlock(brownBedBlock, "bedBrown");
        GameRegistry.registerBlock(blackBedBlock, "bedBlack");
        GameRegistry.registerBlock(blueBedBlock, "bedBlue");
        GameRegistry.registerBlock(greenBedBlock, "bedGreen");
    }

    public  static void registerRenders()
    {
        /**Small Tent*/
        for(int i = 0; i < EnumTentType.values().length; i++)
        {
            registerRender(camoSmallTent, i,"small" + EnumTentType.values()[i].getName());
        }
        /**Fabric Blocks*/
        for(int i = 0; i < EnumFabricType.values().length; i++)
        {
            registerRender(tentFabric, i,"fabric" + EnumFabricType.values()[i].getName());
        }
        /**Doors*/
        registerRender(jungleDoorBlock);
        registerRender(desertDoorBlock);
        registerRender(tundraDoorBlock);
        registerRender(netherDoorBlock);
        registerRender(pinkDoorBlock);
        registerRender(yellowDoorBlock);
        registerRender(brownDoorBlock);
        registerRender(blackDoorBlock);
        registerRender(blueDoorBlock);
        registerRender(greenDoorBlock);
        /**Bed*/
        registerRender(jungleBedBlock);
        registerRender(desertBedBlock);
        registerRender(tundraBedBlock);
        registerRender(netherBedBlock);
        registerRender(pinkBedBlock);
        registerRender(yellowBedBlock);
        registerRender(brownBedBlock);
        registerRender(blackBedBlock);
        registerRender(blueBedBlock);
        registerRender(greenBedBlock);
    }

    private static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName(), "inventory"));
    }

    private static void registerRender(Block block, int meta, String fileName)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,meta,
                new ModelResourceLocation(Reference.MOD_ID + ":" + fileName, "inventory"));
    }
}