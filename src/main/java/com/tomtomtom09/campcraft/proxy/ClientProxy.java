package com.tomtomtom09.campcraft.proxy;

import com.tomtomtom09.campcraft.init.ModBlocks;
import com.tomtomtom09.campcraft.init.ModItems;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenders()
    {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}
