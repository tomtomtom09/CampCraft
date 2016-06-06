package com.tomtomtom09.campcraft.init;

import com.tomtomtom09.campcraft.item.ItemTentEquipment;
import com.tomtomtom09.campcraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    /** Tent Update */
    public static Item tentEquipment, tentLargeEquipment, campHammer;
    public static Item jungleBed, desertBed, tundraBed, netherBed, pinkBed, yellowBed, brownBed, blackBed, blueBed, greenBed;
    public static Item jungleDoor, desertDoor, tundraDoor, netherDoor, pinkDoor, yellowDoor, brownDoor, blackDoor, blueDoor, greenDoor;
    /** Trap Update */
    public static Item bearTrap;
    /** Food Update*/
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
    public static Item jar, blackberryJar, blueberryJar, redberryJar, strawberryJar, whiteberryJar;
    public static Item sweetcornCooked, sweetcornBurnt, sweetcornEaten;
    public static Item rawRabbit,rawFrogLeg, rawTough1, rawTough2, rawVenison;
    public static Item cookedRabbit, cookedTough1, cookedTough2, cookedVenison;
    public static Item burntRabbit,burntFrogLeg, burntTough1, burntTough2, burntVenison;
    
    public static void init()
    {
        tentEquipment = new ItemTentEquipment().setUnlocalizedName("tentEquipment");
    }

    public static void register()
    {
        GameRegistry.registerItem(tentEquipment, tentEquipment.getUnlocalizedName().substring(5));
    }

    public static void registerRenders()
    {
        registerRenders(tentEquipment);
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
