package com.tomtomtom09.campcraft.init;

import com.tomtomtom09.campcraft.item.ItemFabricDoor;
import com.tomtomtom09.campcraft.item.ItemSleepingBag;
import com.tomtomtom09.campcraft.item.ItemTentEquipment;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    /** Tent Update */
    public static Item tentEquipment, tentLargeEquipment, campHammer;
    public static Item jungleBedItem, desertBedItem, tundraBedItem, netherBedItem, pinkBedItem, yellowBedItem, brownBedItem, blackBedItem, blueBedItem, greenBedItem;
    public static Item jungleDoorItem, desertDoorItem, tundraDoorItem, netherDoorItem, pinkDoorItem, yellowDoorItem, brownDoorItem, blackDoorItem, blueDoorItem, greenDoorItem;
    /** Trap Update */
    //public static Item bearTrap;
    /** Food Update*/
    /**
    public static Item campFire, fireWood;
    public static Item strawberrySeed, teaSeed, tomatoSeed, coffeeSeed, cabbageSeed, leekSeed, lettuceSeed, broccoliSeed, cucumberSeed, onionSeed, peaSeed, radishSeed, spinachSeed, sweetcornSeed;
    public static Item strawberry, teaLeave, tomato, coffeeBean, cabbage, leek, lettuce, broccoli, cucumber, onion, peaPod, radish, spinach, sweetcorn;
    public static Item mug, appleMug, coffeeMug, chocoMug, milkMug, pumpkinMug, teaMug, watermelonMug;
    public static Item appleHotMug, coffeeHotMug, chocoHotMug, milkHotMug, pumpkinHotMug, teaHotMug, watermelonHotMug;
    public static Item milkShakeGlass, strawberryMilkShake, chocoMilkShake;
    public static Item rawSausage, rawBacon, rawHamburger;
    public static Item cookedSausage, cookedBacon, cookedHamburger;
    public static Item burntSausage, burntBacon, burntHamburger, burntPorkchop, burntSteak, burntFish, burntChicken;
    public static Item rawFishStew, rawPumpkinStew, rawDeerStew, rawRabbitStew, rawBearStew, rawMinecraftStew, rawBeefStew, rawBroccoliStew, rawRadishStew, rawTomatoStew, rawPotatoLeekStew, rawFrogStew;
    public static Item cookedFishStew, cookedPumpkinStew, cookedDeerStew, cookedRabbitStew, cookedBearStew, cookedMinecraftStew, cookedBeefStew, cookedBroccoliStew, cookedRadishStew, cookedTomatoStew, cookedPotatoLeekStew, cookedFrogStew;
    public static Item burntStew;
    public static Item campSalad;
    public static Item sausageSandwich, baconSandwich, cheeseSandwich, cheeseToastie, burntCheeseToastie, fishSandwich, hotDog, hamburgerSandwich;
    public static Item jacketPotatoBurnt, jacketPotatoCheeseRaw, jacketPotatoCheeseCooked, jacketPotatoCheeseBurnt;
    public static Item scrambledEggRaw, scrambledEggCooked, friedEggRaw, friedEggCooked, eggBurntBowl;
    public static Item pumpkinSliceRaw, pumpkinSliceCooked, pumpkinSliceBurnt;
    public static Item pizzaBase, rawCheesePizza, rawMeatPizza, rawFishPizza, rawMushroomPizza;
    public static Item cookedCheesePizza, cookedMeatPizza, cookedFishPizza, cookedMushroomPizza;
    public static Item burntMeatPizza, burntCheesePizza, burntFishPizza, burntMushroomPizza;
    public static Item chocolateCake, strawberryCake;
    public static Item donutPlain, donutSugar, donutChocolate, donutStrawberry;
    public static Item icecreamVanilla, icecreamBanana, icecreamChocolate, icecreamCoconut, icecreamStrawberry;
    public static Item marshmallow, marshmallowStickRaw, marshmallowStickCooked, marshmallowStickBurnt;
    public static Item glassJar, blackberryJar, blueberryJar, redberryJar, strawberryJar, whiteberryJar;
    public static Item sweetcornCooked, sweetcornBurnt, sweetcornEaten;
    public static Item rawRabbit,rawFrogLeg, rawTough1, rawTough2, rawVenison;
    public static Item cookedRabbit, cookedTough1, cookedTough2, cookedVenison;
    public static Item burntRabbit,burntFrogLeg, burntTough1, burntTough2, burntVenison;
    */
    public static void init()
    {
        /**Tent Update*/
        tentEquipment = new ItemTentEquipment().setUnlocalizedName("tentEquipment");
        /**Door*/
        jungleDoorItem = new ItemFabricDoor(ModBlocks.jungleDoorBlock).setUnlocalizedName("doorJungleItem");
        desertDoorItem = new ItemFabricDoor(ModBlocks.desertDoorBlock).setUnlocalizedName("doorDesertItem");
        tundraDoorItem = new ItemFabricDoor(ModBlocks.tundraDoorBlock).setUnlocalizedName("doorTundraItem");
        netherDoorItem = new ItemFabricDoor(ModBlocks.netherDoorBlock).setUnlocalizedName("doorNetherItem");
        pinkDoorItem = new ItemFabricDoor(ModBlocks.pinkDoorBlock).setUnlocalizedName("doorPinkItem");
        yellowDoorItem = new ItemFabricDoor(ModBlocks.yellowDoorBlock).setUnlocalizedName("doorYellowItem");
        brownDoorItem = new ItemFabricDoor(ModBlocks.brownDoorBlock).setUnlocalizedName("doorBrownItem");
        blackDoorItem = new ItemFabricDoor(ModBlocks.blackDoorBlock).setUnlocalizedName("doorBlackItem");
        blueDoorItem = new ItemFabricDoor(ModBlocks.blueDoorBlock).setUnlocalizedName("doorBlueItem");
        greenDoorItem = new ItemFabricDoor(ModBlocks.greenDoorBlock).setUnlocalizedName("doorGreenItem");
        /**Bed*/
        jungleBedItem = new ItemSleepingBag(ModBlocks.jungleBedBlock).setUnlocalizedName("bedJungleItem");

        desertBedItem = new ItemSleepingBag(ModBlocks.desertBedBlock).setUnlocalizedName("bedDesertItem");
        tundraBedItem = new ItemSleepingBag(ModBlocks.tundraBedBlock).setUnlocalizedName("bedTundraItem");
        netherBedItem = new ItemSleepingBag(ModBlocks.netherBedBlock).setUnlocalizedName("bedNetherItem");
        pinkBedItem = new ItemSleepingBag(ModBlocks.pinkBedBlock).setUnlocalizedName("bedPinkItem");
        yellowBedItem = new ItemSleepingBag(ModBlocks.yellowBedBlock).setUnlocalizedName("bedYellowItem");
        brownBedItem = new ItemSleepingBag(ModBlocks.brownBedBlock).setUnlocalizedName("bedBrownItem");
        blackBedItem = new ItemSleepingBag(ModBlocks.blackBedBlock).setUnlocalizedName("bedBlackItem");
        blueBedItem = new ItemSleepingBag(ModBlocks.blueBedBlock).setUnlocalizedName("bedBlueItem");
        greenBedItem = new ItemSleepingBag(ModBlocks.greenBedBlock).setUnlocalizedName("bedGreenItem");
    }

    public static void register()
    {
        /**Tent Update*/
        GameRegistry.registerItem(tentEquipment, tentEquipment.getUnlocalizedName().substring(5));
        /**Door*/
        GameRegistry.registerItem(jungleDoorItem, jungleDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(desertDoorItem, desertDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(tundraDoorItem, tundraDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(netherDoorItem, netherDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinkDoorItem, pinkDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(yellowDoorItem, yellowDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(brownDoorItem, brownDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(blackDoorItem, blackDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(blueDoorItem, blueDoorItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(greenDoorItem, greenDoorItem.getUnlocalizedName().substring(5));
        /**Bed*/
        GameRegistry.registerItem(jungleBedItem, jungleBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(desertBedItem, desertBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(tundraBedItem, tundraBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(netherBedItem, netherBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(pinkBedItem, pinkBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(yellowBedItem, yellowBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(brownBedItem, brownBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(blackBedItem, blackBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(blueBedItem, blueBedItem.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(greenBedItem, greenBedItem.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        /**Tent Update*/
        registerRenders(tentEquipment);
        /**Door*/
        registerRenders(jungleDoorItem);
        registerRenders(desertDoorItem);
        registerRenders(tundraDoorItem);
        registerRenders(netherDoorItem);
        registerRenders(pinkDoorItem);
        registerRenders(yellowDoorItem);
        registerRenders(brownDoorItem);
        registerRenders(blackDoorItem);
        registerRenders(blueDoorItem);
        registerRenders(greenDoorItem);
        /**Bed*/
        registerRenders(jungleBedItem);
        registerRenders(desertBedItem);
        registerRenders(tundraBedItem);
        registerRenders(netherBedItem);
        registerRenders(pinkBedItem);
        registerRenders(yellowBedItem);
        registerRenders(brownBedItem);
        registerRenders(blackBedItem);
        registerRenders(blueBedItem);
        registerRenders(greenBedItem);
    }

    public static void registerRenders(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}







/**
 *
 *
 *
 public static void init()
 {
 //GameRegistry.registerItem(tentEquipment, "tentEquipment");
 }
 * public static final ItemCC tentEquipment = new ItemTentEquipment();
 public static Item TentEquipment;
 public static Item TentLargeEquipment;
 //Tent Hammer
 public static Item CampHammer;
 //Sleeping Bag
 public static Item JungleSleepingBagItem;
 public static Item DesertSleepingBagItem;
 public static Item TundraSleepingBagItem;
 public static Item NetherSleepingBagItem;
 public static Item PinkSleepingBagItem;
 public static Item YellowSleepingBagItem;
 public static Item BrownSleepingBagItem;
 public static Item BlackSleepingBagItem;
 public static Item BlueSleepingBagItem;
 public static Item GreenSleepingBagItem;
 //Tent Doors Item
 public static Item JungleDoorItem;
 public static Item DesertDoorItem;
 public static Item TundraDoorItem;
 public static Item NetherDoorItem;
 public static Item PinkDoorItem;
 public static Item YellowDoorItem;
 public static Item BrownDoorItem;
 public static Item BlackDoorItem;
 public static Item BlueDoorItem;
 public static Item GreenDoorItem;
 */
