package com.tomtomtom09.campcraft.proxy;

import com.tomtomtom09.campcraft.init.ModBlocks;
import com.tomtomtom09.campcraft.init.ModItems;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenders()
    {
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void registerModelBakeryStuff()
    {
        //ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.camoSmallTent), new ResourceLocation("campcraft:smallJungle"), new ResourceLocation("campcraft:smallDesert"), new ResourceLocation("campcraft:smallTundra"), new ResourceLocation("campcraft:smallNether"), new ResourceLocation("campcraft:smallPink"), new ResourceLocation("campcraft:smallYellow"), new ResourceLocation("campcraft:smallBrown"), new ResourceLocation("campcraft:smallBlack"), new ResourceLocation("campcraft:smallBlue"), new ResourceLocation("campcraft:smallGreen"), new ResourceLocation("campcraft:smallConverter"));
        ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.tentFabric), new ResourceLocation("campcraft:fabricJungle"), new ResourceLocation("campcraft:fabricDesert"), new ResourceLocation("campcraft:fabricTundra"), new ResourceLocation("campcraft:fabricNether"), new ResourceLocation("campcraft:fabricPink"), new ResourceLocation("campcraft:fabricYellow"), new ResourceLocation("campcraft:fabricBrown"), new ResourceLocation("campcraft:fabricBlack"), new ResourceLocation("campcraft:fabricBlue"), new ResourceLocation("campcraft:fabricGreen"));
    }
}
