package com.tomtomtom09.campcraft;

import com.tomtomtom09.campcraft.handler.ConfigurationHandler;
import com.tomtomtom09.campcraft.init.ModBlocks;
import com.tomtomtom09.campcraft.init.ModItems;
import com.tomtomtom09.campcraft.proxy.CommonProxy;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class CampCraft
{
    @Mod.Instance(Reference.MOD_ID)
    public static CampCraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        /** Config Changed Event */
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        /** Initialize mod blocks*/
        ModBlocks.init();
        ModBlocks.register();
        /** Initialize mod items*/
        ModItems.init();
        ModItems.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }


}
