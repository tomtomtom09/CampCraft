package com.tomtomtom09.campcraft.init;

import com.tomtomtom09.campcraft.block.*;
import com.tomtomtom09.campcraft.handler.EnumFabricType;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
    /** Tent Update */
    public static Block tentFabric;
    public static Block jungleSmallTent, desertSmallTent, tundraSmallTent, netherSmallTent, pinkSmallTent, yellowSmallTent, brownSmallTent, blackSmallTent, blueSmallTent, greenSmallTent;
    public static Block jungleDoorBlock, desertDoorBlock, tundraDoorBlock, netherDoorBlock, pinkDoorBlock, yellowDoorBlock, brownDoorBlock, blackDoorBlock, blueDoorBlock, greenDoorBlock;
    public static Block jungleBedBlock, desertBedBlock, tundraBedBlock, netherBedBlock, pinkBedBlock, yellowBedBlock, brownBedBlock, blackBedBlock, blueBedBlock, greenBedBlock;

    public static void init()
    {
        /**Tent Update*/
        tentFabric = new BlockFabric("tentFabric");
        /**Small Tent*/
        jungleSmallTent = (new BlockCamoTent("smallTentJungle", 1, 1));
        desertSmallTent = (new BlockCamoTent("smallTentDesert", 1, 2));
        tundraSmallTent = (new BlockCamoTent("smallTentTundra", 1, 3));
        netherSmallTent = (new BlockCamoTent("smallTentNether", 1, 4));
        pinkSmallTent = (new BlockCamoTent("smallTentPink", 1, 5));
        yellowSmallTent = (new BlockCamoTent("smallTentYellow", 1, 6));
        brownSmallTent = (new BlockCamoTent("smallTentBrown", 1, 7));
        blackSmallTent = (new BlockCamoTent("smallTentBlack", 1, 8));
        blueSmallTent = (new BlockCamoTent("smallTentBlue", 1, 9));
        greenSmallTent = (new BlockCamoTent("smallTentGreen", 1, 10));
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
        /**Small Tent*/
        GameRegistry.registerBlock(jungleSmallTent, "smallTentJungle");
        GameRegistry.registerBlock(desertSmallTent, "smallTentDesert");
        GameRegistry.registerBlock(tundraSmallTent, "smallTentTundra");
        GameRegistry.registerBlock(netherSmallTent, "smallTentNether");
        GameRegistry.registerBlock(pinkSmallTent, "smallTentPink");
        GameRegistry.registerBlock(yellowSmallTent, "smallTentYellow");
        GameRegistry.registerBlock(brownSmallTent, "smallTentBrown");
        GameRegistry.registerBlock(blackSmallTent, "smallTentBlack");
        GameRegistry.registerBlock(blueSmallTent, "smallTentBlue");
        GameRegistry.registerBlock(greenSmallTent, "smallTentGreen");
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
        /**Fabric Blocks*/
        for(int i = 0; i < EnumFabricType.values().length; i++)
        {
            registerRender(tentFabric, i,"fabric" + EnumFabricType.values()[i].getName());
        }
        /**Small Tent*/
        registerRender(jungleSmallTent);
        registerRender(desertSmallTent);
        registerRender(tundraSmallTent);
        registerRender(netherSmallTent);
        registerRender(pinkSmallTent);
        registerRender(yellowSmallTent);
        registerRender(brownSmallTent);
        registerRender(blackSmallTent);
        registerRender(blueSmallTent);
        registerRender(greenSmallTent);
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