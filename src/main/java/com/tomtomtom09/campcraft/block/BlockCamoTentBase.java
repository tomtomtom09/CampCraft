package com.tomtomtom09.campcraft.block;

import com.tomtomtom09.campcraft.creativetab.CCItemTab;
import com.tomtomtom09.campcraft.init.ModBlocks;
import com.tomtomtom09.campcraft.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCamoTentBase extends BlockDirectional
{
    public int TentSize;
    public int TentType;
    public int[] areaId;
    
    public BlockCamoTentBase(String unlocalizedName, int tentSize, int tentType)
    {
        super(Material.cloth);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CCItemTab.CC_TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        TentSize = tentSize;
        TentType = tentType;
        if (TentSize == 1)
        {
            //Lvl0Id = new int[24];
            areaId = new int[51];//51 = 26
        }
    }

    /**Gets the Fabric block for tents*/
    public int getFabricType(int tentType)
    {
        if(tentType == 1) {return 0;}
        else if(tentType == 2) {return 1;}
        else if(tentType == 3) {return 2;}
        else if(tentType == 4) {return 3;}
        else if(tentType == 5) {return 4;}
        else if(tentType == 6) {return 5;}
        else if(tentType == 7) {return 6;}
        else if(tentType == 8) {return 7;}
        else if(tentType == 9) {return 8;}
        else if(tentType == 10) {return 9;}
        return 0;
    }

    /**Gets the Door block for tents*/
    public Block getDoorType(int tentType)
    {
        if(tentType == 1) {return ModBlocks.jungleDoorBlock;}
        else if(tentType == 2) {return ModBlocks.desertDoorBlock;}
        else if(tentType == 3) {return ModBlocks.tundraDoorBlock;}
        else if(tentType == 4) {return ModBlocks.netherDoorBlock;}
        else if(tentType == 5) {return ModBlocks.pinkDoorBlock;}
        else if(tentType == 6) {return ModBlocks.yellowDoorBlock;}
        else if(tentType == 7) {return ModBlocks.brownDoorBlock;}
        else if(tentType == 8) {return ModBlocks.blackDoorBlock;}
        else if(tentType == 9) {return ModBlocks.blueDoorBlock;}
        else if(tentType == 10) {return ModBlocks.greenDoorBlock;}
        return ModBlocks.jungleDoorBlock;
    }

    /**Gets the Sleeping Bag for tents*/
    public Block getBedType(int tentType)
    {
        if(tentType == 1) {return ModBlocks.jungleBedBlock;}
        else if(tentType == 2) {return ModBlocks.desertBedBlock;}
        else if(tentType == 3) {return ModBlocks.tundraBedBlock;}
        else if(tentType == 4) {return ModBlocks.netherBedBlock;}
        else if(tentType == 5) {return ModBlocks.pinkBedBlock;}
        else if(tentType == 6) {return ModBlocks.yellowBedBlock;}
        else if(tentType == 7) {return ModBlocks.brownBedBlock;}
        else if(tentType == 8) {return ModBlocks.blackBedBlock;}
        else if(tentType == 9) {return ModBlocks.blueBedBlock;}
        else if(tentType == 10) {return ModBlocks.greenBedBlock;}
        return ModBlocks.jungleBedBlock;
    }

    /**Scans the foundation to make sure tent can be placed on flat land.*/
    public boolean scanFoundation(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn)
    {
        EnumFacing tentMeta = state.getValue(FACING);

        int y = pos.getY() - 1;
        boolean Test = true;
        if (TentSize == 1)
        {
            if (tentMeta == EnumFacing.NORTH) //North Tent
            {
                for (int x = pos.getX() + 3; x > pos.getX() - 4; x--)
                {
                    for (int z = pos.getZ() - 2; z < pos.getZ() + 2; z++)
                    {
                        if (x == pos.getX() + 3 && z == pos.getZ() - 2 || x == pos.getX() + 3 && z == pos.getZ() + 1 || x == pos.getX() - 3 && z == pos.getZ() - 2 || x == pos.getX() - 3 && z == pos.getZ() + 1)
                        {
                            continue;
                        } else
                        {
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() == Material.grass || block.getMaterial() == Material.ground || block.getMaterial() == Material.rock || block.getMaterial() == Material.cloth || block.getMaterial() == Material.sand || block.getMaterial() == Material.ice || block.getMaterial() == Material.packedIce || block.getMaterial() == Material.snow || block.getMaterial() == Material.clay)
                            {
                                 
                                continue;
                            } else
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.foundation", new Object[0]));
                                Test = false;
                                continue;
                            }
                        }
                    }
                }
            }
            else if (tentMeta == EnumFacing.EAST) //North Tent
            {
                for (int x = pos.getX() + 2; x > pos.getX() - 2; x--)
                {
                    for (int z = pos.getZ() - 3; z < pos.getZ() + 4; z++)
                    {
                        if (x == pos.getX() + 2 && z == pos.getZ() - 3 || x == pos.getX() + 2 && z == pos.getZ() + 3 || x == pos.getX() - 1 && z == pos.getZ() - 3 || x == pos.getX() - 1 && z == pos.getZ() + 3)
                        {
                            continue;
                        } else
                        {
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() == Material.grass || block.getMaterial() == Material.ground || block.getMaterial() == Material.rock || block.getMaterial() == Material.cloth || block.getMaterial() == Material.sand || block.getMaterial() == Material.ice || block.getMaterial() == Material.packedIce || block.getMaterial() == Material.snow || block.getMaterial() == Material.clay)
                            {
                                 
                                continue;
                            } else
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.foundation", new Object[0]));
                                Test = false;
                                continue;
                            }
                        }
                    }
                }
            }
            else if (tentMeta == EnumFacing.SOUTH) //North Tent
            {
                for (int x = pos.getX() + 3; x > pos.getX() - 4; x--)
                {
                    for (int z = pos.getZ() - 1; z < pos.getZ() + 3; z++)
                    {
                        if (x == pos.getX() + 3 && z == pos.getZ() - 1 || x == pos.getX() + 3 && z == pos.getZ() + 2 || x == pos.getX() - 3 && z == pos.getZ() - 1 || x == pos.getX() - 3 && z == pos.getZ() + 2)
                        {
                            continue;
                        } else
                        {
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() == Material.grass || block.getMaterial() == Material.ground || block.getMaterial() == Material.rock || block.getMaterial() == Material.cloth || block.getMaterial() == Material.sand || block.getMaterial() == Material.ice || block.getMaterial() == Material.packedIce || block.getMaterial() == Material.snow || block.getMaterial() == Material.clay)
                            {
                                 
                                continue;
                            } else
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.foundation", new Object[0]));
                                Test = false;
                                continue;
                            }
                        }
                    }
                }
            }
            else if (tentMeta == EnumFacing.WEST) //North Tent
            {
                for (int x = pos.getX() + 1; x > pos.getX() - 3; x--)
                {
                    for (int z = pos.getZ() - 3; z < pos.getZ() + 4; z++)
                    {
                        if (x == pos.getX() + 1 && z == pos.getZ() - 3 || x == pos.getX() + 1 && z == pos.getZ() + 3 || x == pos.getX() - 2 && z == pos.getZ() - 3 || x == pos.getX() - 2 && z == pos.getZ() + 3)
                        {
                            continue;
                        } else
                        {
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() == Material.grass || block.getMaterial() == Material.ground || block.getMaterial() == Material.rock || block.getMaterial() == Material.cloth || block.getMaterial() == Material.sand || block.getMaterial() == Material.ice || block.getMaterial() == Material.packedIce || block.getMaterial() == Material.snow || block.getMaterial() == Material.clay)
                            {
                                continue;
                            } else
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.foundation", new Object[0]));
                                Test = false;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return Test;
    }

    /**checks to see if area is free on different levels to make tents*/
    public boolean ScanArea(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn)
    {
        EnumFacing tentMeta = state.getValue(FACING);
        boolean Test = true;
        
        if (TentSize == 1)
        {
            if (tentMeta == EnumFacing.NORTH) //North Tent
            {
                for (int y = pos.getY(); y < pos.getY() + 4; y++)
                {
                    //Check Level 1
                    if (y == pos.getY())
                    {
                        for (int x = pos.getX() + 3; x > pos.getX() - 4; x--)
                        {
                            for (int z = pos.getZ() - 2; z < pos.getZ() + 2; z++)
                            {
                                if (x == pos.getX() + 3 && z == pos.getZ() - 2 || x == pos.getX() + 3 && z == pos.getZ() + 1 || x == pos.getX() - 3 && z == pos.getZ() - 2 || x == pos.getX() - 3 && z == pos.getZ() + 1 || x == pos.getX() && z == pos.getZ())
                                {
                                    continue;
                                } else
                                {
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() == Material.air)
                                    {
                                        continue;
                                    } else
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl1", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 2
                    else if (y == pos.getY() + 1)
                    {
                        for (int x = pos.getX() + 2; x > pos.getX() - 3; x--)
                        {
                            for (int z = pos.getZ() - 2; z < pos.getZ() + 2; z++)
                            {
                                if (x == pos.getX() + 2 && z == pos.getZ() - 2 || x == pos.getX() + 2 && z == pos.getZ() + 1 || x == pos.getX() - 2 && z == pos.getZ() - 2 || x == pos.getX() - 2 && z == pos.getZ() + 1)
                                {
                                    continue;
                                } else
                                {
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl2", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 3
                    else if (y == pos.getY() + 2)
                    {
                        for (int x = pos.getX() + 1; x > pos.getX() - 2; x--)
                        {
                            for (int z = pos.getZ() - 2; z < pos.getZ() + 2; z++)
                            {
                                if (x == pos.getX() + 1 && z == pos.getZ() - 2 || x == pos.getX() + 1 && z == pos.getZ() + 1 || x == pos.getX() - 1 && z == pos.getZ() - 2 || x == pos.getX() - 1 && z == pos.getZ() + 1)
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl3", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 4
                    else if (y == pos.getY() + 3)
                    {
                        int x = pos.getX();
                        int z = pos.getZ() - 1;
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air)
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                        z++;
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air) {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                    }
                }
            } else if (tentMeta == EnumFacing.EAST) //East Tent
            {
                for (int y = pos.getY(); y < pos.getY() + 4; y++)
                {
                    //Check Level 1
                    if (y == pos.getY())
                    {
                        for (int x = pos.getX() + 2; x > pos.getX() - 2; x--)
                        {
                            for (int z = pos.getZ() - 3; z < pos.getZ() + 4; z++)
                            {
                                if (x == pos.getX() + 2 && z == pos.getZ() - 3 || x == pos.getX() + 2 && z == pos.getZ() + 3 || x == pos.getX() - 1 && z == pos.getZ() - 3 || x == pos.getX() - 1 && z == pos.getZ() + 3 || x == pos.getX() && z == pos.getZ())
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        if (block == Blocks.snow_layer)
                                        {
                                            continue;
                                        } else
                                        {
                                            playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl1", new Object[0]));
                                            Test = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 2
                    else if (y == pos.getY() + 1)
                    {
                        for (int x = pos.getX() + 2; x > pos.getX() - 2; x--)
                        {
                            for (int z = pos.getZ() - 2; z < pos.getZ() + 3; z++)
                            {
                                if (x == pos.getX() + 2 && z == pos.getZ() - 2 || x == pos.getX() + 2 && z == pos.getZ() + 2 || x == pos.getX() - 1 && z == pos.getZ() - 2 || x == pos.getX() - 1 && z == pos.getZ() + 2)
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl2", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 3
                    else if (y == pos.getY() + 2)
                    {
                        for (int x = pos.getX() + 2; x > pos.getX() - 2; x--)
                        {
                            for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++)
                            {
                                if (x == pos.getX() + 2 && z == pos.getZ() - 1 || x == pos.getX() + 2 && z == pos.getZ() + 1 || x == pos.getX() - 1 && z == pos.getZ() - 1 || x == pos.getX() - 1 && z == pos.getZ() + 1)
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl3", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 4
                    else if (y == pos.getY() + 3)
                    {
                        int x = pos.getX() + 1;
                        int z = pos.getZ();
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air)
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                        x--;
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air) {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                    }
                }
            } else if (tentMeta == EnumFacing.SOUTH) //South Tent
            {
                for (int y = pos.getY(); y < pos.getY() + 4; y++)
                {
                    //Check Level 1
                    if (y == pos.getY())
                    {
                        for (int x = pos.getX() + 3; x > pos.getX() - 4; x--)
                        {
                            for (int z = pos.getZ() - 1; z < pos.getZ() + 3; z++)
                            {
                                if (x == pos.getX() + 3 && z == pos.getZ() - 1 || x == pos.getX() + 3 && z == pos.getZ() + 2 || x == pos.getX() - 3 && z == pos.getZ() - 1 || x == pos.getX() - 3 && z == pos.getZ() + 2 || x == pos.getX() && z == pos.getZ())
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        if (block == Blocks.snow_layer)
                                        {
                                            continue;
                                        } else
                                        {
                                            playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl1", new Object[0]));
                                            Test = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 2
                    else if (y == pos.getY() + 1)
                    {
                        for (int x = pos.getX() + 2; x > pos.getX() - 3; x--)
                        {
                            for (int z = pos.getZ() - 1; z < pos.getZ() + 3; z++)
                            {
                                if (x == pos.getX() + 2 && z == pos.getZ() - 1 || x == pos.getX() + 2 && z == pos.getZ() + 2 || x == pos.getX() - 2 && z == pos.getZ() - 1 || x == pos.getX() - 2 && z == pos.getZ() + 2)
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl2", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 3
                    else if (y == pos.getY() + 2)
                    {
                        for (int x = pos.getX() + 1; x > pos.getX() - 2; x--)
                        {
                            for (int z = pos.getZ() - 1; z < pos.getZ() + 3; z++)
                            {
                                if (x == pos.getX() + 1 && z == pos.getZ() - 1 || x == pos.getX() + 1 && z == pos.getZ() + 2 || x == pos.getX() - 1 && z == pos.getZ() - 1 || x == pos.getX() - 1 && z == pos.getZ() + 2)
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl3", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 4
                    else if (y == pos.getY() + 3)
                    {
                        int x = pos.getX();
                        int z = pos.getZ() + 1;
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air)
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                        z--;
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air) {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                    }
                }
            } else if (tentMeta == EnumFacing.WEST) //West Tent
            {
                for (int y = pos.getY(); y < pos.getY() + 4; y++)
                {
                    //Check Level 1
                    if (y == pos.getY())
                    {
                        for (int x = pos.getX() + 1; x > pos.getX() - 3; x--)
                        {
                            for (int z = pos.getZ() - 3; z < pos.getZ() + 4; z++)
                            {
                                if (x == pos.getX() + 1 && z == pos.getZ() - 3 || x == pos.getX() + 1 && z == pos.getZ() + 3 || x == pos.getX() - 2 && z == pos.getZ() - 3 || x == pos.getX() - 2 && z == pos.getZ() + 3 || x == pos.getX() && z == pos.getZ())
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        if (block == Blocks.snow_layer)
                                        {
                                            continue;
                                        } else
                                        {
                                            playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl1", new Object[0]));
                                            Test = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 2
                    else if (y == pos.getY() + 1)
                    {
                        for (int x = pos.getX() + 1; x > pos.getX() - 3; x--)
                        {
                            for (int z = pos.getZ() - 2; z < pos.getZ() + 3; z++)
                            {
                                if (x == pos.getX() + 1 && z == pos.getZ() - 2 || x == pos.getX() + 1 && z == pos.getZ() + 2 || x == pos.getX() - 2 && z == pos.getZ() - 2 || x == pos.getX() - 2 && z == pos.getZ() + 2)
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl2", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 3
                    else if (y == pos.getY() + 2)
                    {
                        for (int x = pos.getX() + 1; x > pos.getX() - 3; x--)
                        {
                            for (int z = pos.getZ() - 1; z < pos.getZ() + 2; z++)
                            {
                                if (x == pos.getX() + 1 && z == pos.getZ() - 1 || x == pos.getX() + 1 && z == pos.getZ() + 1 || x == pos.getX() - 2 && z == pos.getZ() - 1 || x == pos.getX() - 2 && z == pos.getZ() + 1)
                                {
                                    continue;
                                } else
                                {
                                     
                                    Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                                    if (block.getMaterial() != Material.air)
                                    {
                                        playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl3", new Object[0]));
                                        Test = false;
                                    }
                                }
                            }
                        }
                    }
                    //Check Level 4
                    else if (y == pos.getY() + 3)
                    {
                        int x = pos.getX() - 1;
                        int z = pos.getZ();
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air)
                            {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                        x++;
                        {
                             
                            Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
                            if (block.getMaterial() != Material.air) {
                                playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.lvl4", new Object[0]));
                                Test = false;
                            }
                        }
                    }
                }
            }
        }
        return Test;
    }

    //TODO improve the check block code. Add check for equipment(bed/workbench/torch)
    /**checks to make sure all tent blocks are not missing*/
    public boolean ScanFoldup(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn)
    {
        EnumFacing tentMeta = state.getValue(FACING);
        boolean Test = true;
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));
        int y = pos.getY() + 0;

        if(TentSize == 1)
        {
            if(tentMeta == EnumFacing.NORTH)
            {
                /**Check Level 1*/
                Block fabBlock1 = worldIn.getBlockState(new BlockPos(pos.getX() + 3,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock2 = worldIn.getBlockState(new BlockPos(pos.getX() + 3,pos.getY() - 2,pos.getZ() - 0)).getBlock();
                Block fabBlock3 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock4 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock5 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() - 0)).getBlock();
                Block fabBlock6 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock7 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock8 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock9 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock10 = worldIn.getBlockState(new BlockPos(pos.getX() - 3,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock11 = worldIn.getBlockState(new BlockPos(pos.getX() - 3,pos.getY() - 2,pos.getZ() - 0)).getBlock();
                Block fabBlock12 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock13 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock14 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() - 0)).getBlock();
                Block fabBlock15 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock16 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock17 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                /**Check Level 2*/
                Block fabBlock18 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock19 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() - 0)).getBlock();
                Block fabBlock20 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() - 2)).getBlock();
                Block fabBlock21 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                Block fabBlock22 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock23 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() - 0)).getBlock();
                Block fabBlock24 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() - 2)).getBlock();
                Block fabBlock25 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                /**Check Level 3*/
                Block fabBlock26 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                Block fabBlock27 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 0)).getBlock();
                Block fabBlock28 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 2)).getBlock();
                Block fabBlock29 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                Block fabBlock30 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock31 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                Block fabBlock32 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 0)).getBlock();
                /**Check Level 4*/
                Block fabBlock33 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() - 1)).getBlock();
                Block fabBlock34 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() - 0)).getBlock();
                
                if (fabBlock1 != fabric || fabBlock2 != fabric || fabBlock3 != fabric || fabBlock4 != fabric || fabBlock5 != fabric || fabBlock6 != fabric || fabBlock7 != fabric || fabBlock8 != fabric || fabBlock9 != fabric || fabBlock10 != fabric || fabBlock11 != fabric || fabBlock12 != fabric || fabBlock13 != fabric || fabBlock14 != fabric || fabBlock15 != fabric || fabBlock16 != fabric || fabBlock17 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl1", new Object[0]));
                    Test = false;
                }
                else if (fabBlock18 != fabric || fabBlock19 != fabric || fabBlock20 != fabric || fabBlock21 != fabric || fabBlock22 != fabric || fabBlock23 != fabric || fabBlock24 != fabric || fabBlock25 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl2", new Object[0]));
                    Test = false;
                }
                else if (fabBlock26 != fabric || fabBlock27 != fabric || fabBlock28 != fabric || fabBlock29 != fabric || fabBlock30 != fabric || fabBlock31 != fabric || fabBlock32 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl3", new Object[0]));
                    Test = false;
                }
                else if (fabBlock33 != fabric || fabBlock34 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl4", new Object[0]));
                    Test = false;
                }
            }
            else if(tentMeta == EnumFacing.EAST)
            {
                /**Check Level 1*/
                Block fabBlock1 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() + 3)).getBlock();
                Block fabBlock2 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() + 3)).getBlock();
                Block fabBlock3 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock4 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock5 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock6 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock7 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock8 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock9 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() + 0)).getBlock();
                Block fabBlock10 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock11 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock12 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock13 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock14 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock15 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock16 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() - 3)).getBlock();
                Block fabBlock17 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() - 3)).getBlock();
                /**Check Level 2*/
                Block fabBlock18 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 1,pos.getZ() + 2)).getBlock();
                Block fabBlock19 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() + 2)).getBlock();
                Block fabBlock20 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                Block fabBlock21 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                Block fabBlock22 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock23 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock24 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 1,pos.getZ() - 2)).getBlock();
                Block fabBlock25 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() - 2)).getBlock();
                /**Check Level 3*/
                Block fabBlock26 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock27 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock28 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                Block fabBlock29 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                Block fabBlock30 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                Block fabBlock31 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                Block fabBlock32 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                /**Check Level 4*/
                Block fabBlock33 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 0)).getBlock();
                Block fabBlock34 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 0)).getBlock();

                if (fabBlock1 != fabric || fabBlock2 != fabric || fabBlock3 != fabric || fabBlock4 != fabric || fabBlock5 != fabric || fabBlock6 != fabric || fabBlock7 != fabric || fabBlock8 != fabric || fabBlock9 != fabric || fabBlock10 != fabric || fabBlock11 != fabric || fabBlock12 != fabric || fabBlock13 != fabric || fabBlock14 != fabric || fabBlock15 != fabric || fabBlock16 != fabric || fabBlock17 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl1", new Object[0]));
                    Test = false;
                }
                else if (fabBlock18 != fabric || fabBlock19 != fabric || fabBlock20 != fabric || fabBlock21 != fabric || fabBlock22 != fabric || fabBlock23 != fabric || fabBlock24 != fabric || fabBlock25 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl2", new Object[0]));
                    Test = false;
                }
                else if (fabBlock26 != fabric || fabBlock27 != fabric || fabBlock28 != fabric || fabBlock29 != fabric || fabBlock30 != fabric || fabBlock31 != fabric || fabBlock32 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl3", new Object[0]));
                    Test = false;
                }
                else if (fabBlock33 != fabric || fabBlock34 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl4", new Object[0]));
                    Test = false;
                }
            }
            else if(tentMeta == EnumFacing.SOUTH)
            {
                /**Check Level 1*/
                Block fabBlock1 = worldIn.getBlockState(new BlockPos(pos.getX() - 3,pos.getY() - 2,pos.getZ() + 0)).getBlock();
                Block fabBlock2 = worldIn.getBlockState(new BlockPos(pos.getX() - 3,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock3 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock4 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock5 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() + 0)).getBlock();
                Block fabBlock6 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock7 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock8 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock9 = worldIn.getBlockState(new BlockPos(pos.getX() - 0,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock10 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock11 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock12 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock13 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock14 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() + 0)).getBlock();
                Block fabBlock15 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock16 = worldIn.getBlockState(new BlockPos(pos.getX() + 3,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock17 = worldIn.getBlockState(new BlockPos(pos.getX() + 3,pos.getY() - 2,pos.getZ() + 0)).getBlock();
                /**Check Level 2*/
                Block fabBlock18 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() + 0)).getBlock();
                Block fabBlock19 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                Block fabBlock20 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() + 2)).getBlock();
                Block fabBlock21 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock22 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() + 2)).getBlock();
                Block fabBlock23 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock24 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() + 0)).getBlock();
                Block fabBlock25 = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                /**Check Level 3*/
                Block fabBlock26 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                Block fabBlock27 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock28 = worldIn.getBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 0,pos.getZ() + 2)).getBlock();
                Block fabBlock29 = worldIn.getBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock30 = worldIn.getBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                Block fabBlock31 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock32 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                /**Check Level 4*/
                Block fabBlock33 = worldIn.getBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 1,pos.getZ() + 0)).getBlock();
                Block fabBlock34 = worldIn.getBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 1,pos.getZ() + 1)).getBlock();

                if (fabBlock1 != fabric || fabBlock2 != fabric || fabBlock3 != fabric || fabBlock4 != fabric || fabBlock5 != fabric || fabBlock6 != fabric || fabBlock7 != fabric || fabBlock8 != fabric || fabBlock9 != fabric || fabBlock10 != fabric || fabBlock11 != fabric || fabBlock12 != fabric || fabBlock13 != fabric || fabBlock14 != fabric || fabBlock15 != fabric || fabBlock16 != fabric || fabBlock17 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl1", new Object[0]));
                    Test = false;
                }
                else if (fabBlock18 != fabric || fabBlock19 != fabric || fabBlock20 != fabric || fabBlock21 != fabric || fabBlock22 != fabric || fabBlock23 != fabric || fabBlock24 != fabric || fabBlock25 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl2", new Object[0]));
                    Test = false;
                }
                else if (fabBlock26 != fabric || fabBlock27 != fabric || fabBlock28 != fabric || fabBlock29 != fabric || fabBlock30 != fabric || fabBlock31 != fabric || fabBlock32 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl3", new Object[0]));
                    Test = false;
                }
                else if (fabBlock33 != fabric || fabBlock34 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl4", new Object[0]));
                    Test = false;
                }
            }
            else if(tentMeta == EnumFacing.WEST)
            {
                /**Check Level 1*/
                Block fabBlock1 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() + 3)).getBlock();
                Block fabBlock2 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() + 3)).getBlock();
                Block fabBlock3 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock4 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock5 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock6 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() + 2)).getBlock();
                Block fabBlock7 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock8 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() + 1)).getBlock();
                Block fabBlock9 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() + 0)).getBlock();
                Block fabBlock10 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock11 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() - 1)).getBlock();
                Block fabBlock12 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock13 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock14 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock15 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 2,pos.getZ() - 2)).getBlock();
                Block fabBlock16 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 2,pos.getZ() - 3)).getBlock();
                Block fabBlock17 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 2,pos.getZ() - 3)).getBlock();
                /**Check Level 2*/
                Block fabBlock18 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 1,pos.getZ() + 2)).getBlock();
                Block fabBlock19 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() + 2)).getBlock();
                Block fabBlock20 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                Block fabBlock21 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() + 1)).getBlock();
                Block fabBlock22 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock23 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() - 1)).getBlock();
                Block fabBlock24 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 1,pos.getZ() - 2)).getBlock();
                Block fabBlock25 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() - 1,pos.getZ() - 2)).getBlock();
                /**Check Level 3*/
                Block fabBlock26 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock27 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 1)).getBlock();
                Block fabBlock28 = worldIn.getBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                Block fabBlock29 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                Block fabBlock30 = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 0)).getBlock();
                Block fabBlock31 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                Block fabBlock32 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 1)).getBlock();
                /**Check Level 4*/
                Block fabBlock33 = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 0)).getBlock();
                Block fabBlock34 = worldIn.getBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 0)).getBlock();

                if (fabBlock1 != fabric || fabBlock2 != fabric || fabBlock3 != fabric || fabBlock4 != fabric || fabBlock5 != fabric || fabBlock6 != fabric || fabBlock7 != fabric || fabBlock8 != fabric || fabBlock9 != fabric || fabBlock10 != fabric || fabBlock11 != fabric || fabBlock12 != fabric || fabBlock13 != fabric || fabBlock14 != fabric || fabBlock15 != fabric || fabBlock16 != fabric || fabBlock17 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl1", new Object[0]));
                    Test = false;
                }
                else if (fabBlock18 != fabric || fabBlock19 != fabric || fabBlock20 != fabric || fabBlock21 != fabric || fabBlock22 != fabric || fabBlock23 != fabric || fabBlock24 != fabric || fabBlock25 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl2", new Object[0]));
                    Test = false;
                }
                else if (fabBlock26 != fabric || fabBlock27 != fabric || fabBlock28 != fabric || fabBlock29 != fabric || fabBlock30 != fabric || fabBlock31 != fabric || fabBlock32 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl3", new Object[0]));
                    Test = false;
                }
                else if (fabBlock33 != fabric || fabBlock34 != fabric)
                {
                    playerIn.addChatMessage(new ChatComponentTranslation("tile.tent.miss.lvl4", new Object[0]));
                    Test = false;
                }
            }
        }
        return Test;
    }

    /**Build Small Tent North*/
    public boolean buildNorthSmall(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        /**Add Tent Block*/
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 2,pos.getZ()), this.getDefaultState());
        /**Add Fabric Blocks lvl 1*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY(),pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY(),pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY(),pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY(),pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 1), fabricState);
        /**Add Fabric Blocks lvl 2*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 1), fabricState);
        /**Add Fabric Blocks lvl 3*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 0), fabricState);
        /**Add Fabric Blocks lvl 4*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 0), fabricState);
        /**Add Doors*/
        /**Checks for ice under door*/
        Block block = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 1,pos.getZ() - 2)).getBlock();
        if (block.getMaterial() == Material.ice || block == Blocks.snow || block == Blocks.ice)
        {
            worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() - 1,pos.getZ() - 2), Blocks.snow.getDefaultState());
        }
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() - 2), this.getDoorType(TentType).getStateFromMeta(1));
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 1,pos.getZ() - 2), this.getDoorType(TentType).getStateFromMeta(9));
        /**Add Windows*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 1), Blocks.glass_pane.getDefaultState());
        /**Removes Tent Block*/
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), Blocks.air.getDefaultState());
        return true;
    }

    /**Build Small Tent East*/
    public boolean buildEastSmall(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));
        
        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 2,pos.getZ()), this.getDefaultState());
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 3),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() + 3),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() - 3),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() - 3),fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() - 2),fabricState);
        //Tent lvl 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 1),fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 0),fabricState);
        /**Add Doors*/
        /**Checks for ice under door*/
        Block block = worldIn.getBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() + 0)).getBlock();
        if (block.getMaterial() == Material.ice || block == Blocks.snow || block == Blocks.ice)
        {
            worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() - 1,pos.getZ() + 0), Blocks.snow.getDefaultState());
        }
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY(),pos.getZ() + 0), this.getDoorType(TentType).getStateFromMeta(2));
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 0), this.getDoorType(TentType).getStateFromMeta(10));
        /**Add Windows*/
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 0), Blocks.glass_pane.getDefaultState());
        /**Removes Tent Block*/
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), Blocks.air.getDefaultState());
        return true;
    }

    /**Build Small Tent South*/
    public boolean buildSouthSmall(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 2,pos.getZ()), this.getDefaultState());
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 0,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 0),fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 1),fabricState);
        //Tent lvl 3
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 2,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 2,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 2,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 0),fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 3,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 3,pos.getZ() + 1),fabricState);
        /**Add Doors*/
        /**Checks for ice under door*/
        Block block = worldIn.getBlockState(new BlockPos(pos.getX() + 0,pos.getY() - 1,pos.getZ() + 2)).getBlock();
        if (block.getMaterial() == Material.ice || block == Blocks.snow || block == Blocks.ice)
        {
            worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() - 1,pos.getZ() + 2), Blocks.snow.getDefaultState());
        }
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ() + 2), this.getDoorType(TentType).getStateFromMeta(3));
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 1,pos.getZ() + 2), this.getDoorType(TentType).getStateFromMeta(11));
        /**Add Windows*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() - 1), Blocks.glass_pane.getDefaultState());
        /**Removes Tent Block*/
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), Blocks.air.getDefaultState());
        return true;
    }

    /**Build Small Tent West*/
    public boolean buildWestSmall(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 2,pos.getZ()), this.getDefaultState());
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 3),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 3),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 3),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 3),fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() - 2),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() - 2),fabricState);
        //Tent lvl 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 1),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 1),fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 0),fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 0),fabricState);
        /**Add Doors*/
        /**Checks for ice under door*/
        Block block = worldIn.getBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() + 0)).getBlock();
        if (block.getMaterial() == Material.ice || block == Blocks.snow || block == Blocks.ice)
        {
            worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() - 1,pos.getZ() + 0), Blocks.snow.getDefaultState());
        }
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY(),pos.getZ() + 0), this.getDoorType(TentType).getStateFromMeta(0));
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 0), this.getDoorType(TentType).getStateFromMeta(8));
        /**Add Windows*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 0), Blocks.glass_pane.getDefaultState());
        /**Removes Tent Block*/
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY(),pos.getZ()), Blocks.air.getDefaultState());
        return true;
    }

    /**Build Small Tent Equipment*/
    public boolean buildNorthSmallEquipment(World worldIn, BlockPos pos)
    {
        /**Add Equipment*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() - 1), Blocks.chest.getStateFromMeta(4));//Add Chest
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() - 0), Blocks.crafting_table.getDefaultState());	//Add Workbench
        /**Add Lantern/Torches*/
        //worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ()), ModBlocks.Lantern.blockID, 4, 2);//Add Lantern 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ()), Blocks.torch.getStateFromMeta(2));//Add Torch 1 2
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ()), Blocks.torch.getStateFromMeta(1));//Add Torch 2 1
        /**Add Sleeping Bag*/
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 1), this.getBedType(TentType).getStateFromMeta(0)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 0), this.getBedType(TentType).getStateFromMeta(8)); //Add Bed Head
        return true;
    }

    /**Build Small Tent Equipment East*/
    public boolean buildEastSmallEquipment(World worldIn, BlockPos pos)
    {
        /**Add Equipment*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1), Blocks.chest.getStateFromMeta(2));//Add Chest
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() + 1), Blocks.crafting_table.getDefaultState());	//Add Workbench
        /**Add Lantern/Torches*/
        //worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ()), ModBlocks.Lantern.blockID, 4, 2);//Add Lantern 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 1), Blocks.torch.getStateFromMeta(4));//Add Torch 1 2
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 1,pos.getZ() - 1), Blocks.torch.getStateFromMeta(3));//Add Torch 2 1
        /**Add Sleeping Bag*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() - 1), this.getBedType(TentType).getStateFromMeta(9)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() - 1), this.getBedType(TentType).getStateFromMeta(1)); //Add Bed Head
        return true;
    }

    /**Build Small Tent Equipment*/
    public boolean buildSouthSmallEquipment(World worldIn, BlockPos pos)
    {
        /**Add Equipment*/
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 1), Blocks.chest.getStateFromMeta(5));//Add Chest
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 0), Blocks.crafting_table.getDefaultState());	//Add Workbench
        /**Add Lantern/Torches*/
        //worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ()), ModBlocks.Lantern.blockID, 4, 2);//Add Lantern 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ()), Blocks.torch.getStateFromMeta(2));//Add Torch 1 2
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ()), Blocks.torch.getStateFromMeta(1));//Add Torch 2 1
        /**Add Sleeping Bag*/
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 0), this.getBedType(TentType).getStateFromMeta(10)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY(),pos.getZ() + 1), this.getBedType(TentType).getStateFromMeta(2)); //Add Bed Head
        return true;
    }

    /**Build Small Tent Equipment*/
    public boolean buildWestSmallEquipment(World worldIn, BlockPos pos)
    {
        /**Add Equipment*/
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() - 1), Blocks.chest.getStateFromMeta(4));//Add Chest
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() - 1), Blocks.crafting_table.getDefaultState());	//Add Workbench
        /**Add Lantern/Torches*/
        //worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ()), ModBlocks.Lantern.blockID, 4, 2);//Add Lantern 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 1), Blocks.torch.getStateFromMeta(4));//Add Torch 1 2
        worldIn.setBlockState(new BlockPos(pos.getX() - 0,pos.getY() + 1,pos.getZ() - 1), Blocks.torch.getStateFromMeta(3));//Add Torch 2 1
        /**Add Sleeping Bag*/
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY(),pos.getZ() + 1), this.getBedType(TentType).getStateFromMeta(3)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY(),pos.getZ() + 1), this.getBedType(TentType).getStateFromMeta(11)); //Add Bed Head

        /**Place different beds into the world*//*
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY(),pos.getZ() + 0), this.getBedType(TentType).getStateFromMeta(0)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 5,pos.getY(),pos.getZ() + 0), this.getBedType(TentType).getStateFromMeta(1)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 7,pos.getY(),pos.getZ() + 0), this.getBedType(TentType).getStateFromMeta(2)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 9,pos.getY(),pos.getZ() + 0), this.getBedType(TentType).getStateFromMeta(3)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 11,pos.getY(),pos.getZ() + 0), this.getBedType(TentType).getStateFromMeta(4)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY(),pos.getZ() + 2), this.getBedType(TentType).getStateFromMeta(5)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 5,pos.getY(),pos.getZ() + 2), this.getBedType(TentType).getStateFromMeta(6)); //Add Bed Foot
        worldIn.setBlockState(new BlockPos(pos.getX() + 7,pos.getY(),pos.getZ() + 2), this.getBedType(TentType).getStateFromMeta(7)); //Add Bed Foot

        worldIn.setBlockState(new BlockPos(pos.getX() + 9,pos.getY(),pos.getZ() + 2), this.getBedType(TentType).getStateFromMeta(8)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 11,pos.getY(),pos.getZ() + 2), this.getBedType(TentType).getStateFromMeta(9)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY(),pos.getZ() + 4), this.getBedType(TentType).getStateFromMeta(10)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 5,pos.getY(),pos.getZ() + 4), this.getBedType(TentType).getStateFromMeta(11)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 7,pos.getY(),pos.getZ() + 4), this.getBedType(TentType).getStateFromMeta(12)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 9,pos.getY(),pos.getZ() + 4), this.getBedType(TentType).getStateFromMeta(13)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 11,pos.getY(),pos.getZ() + 4), this.getBedType(TentType).getStateFromMeta(14)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 13,pos.getY(),pos.getZ() + 4), this.getBedType(TentType).getStateFromMeta(15)); //Add Bed Head
        worldIn.setBlockState(new BlockPos(pos.getX() + 15,pos.getY(),pos.getZ() + 4), this.getBedType(TentType).getStateFromMeta(16)); //Add Bed Head
        */
        return true;
    }

    /**Build Medium Tent North*/
    public boolean buildNorthMedium(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 3,pos.getZ()), this.getDefaultState());
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 2), fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        //Tent lvl 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 2), fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        //Tent lvl 5
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        return true;
    }

    /**Build Medium Tent East*/
    public boolean buildEastMedium(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 3,pos.getZ()), this.getDefaultState());
        //Level 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        //Level 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() - 4), fabricState);
        //Level 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 3), fabricState);
        //Level 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        //Level 5
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        return true;
    }

    /**Build Medium Tent South*/
    public boolean buildSouthMedium(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 3,pos.getZ()), this.getDefaultState());
        //Level 1
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        //Level 2
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() - 1), fabricState);
        //Level 3
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() - 1), fabricState);
        //Level 4
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        //Level 5
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        return true;
    }

    /**Build Medium Tent South*/
    public boolean buildWestMedium(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 3,pos.getZ()), this.getDefaultState());
        //Level 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        //Level 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 1,pos.getZ() - 4), fabricState);
        //Level 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 1), fabricState);
        //worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 3), fabricState);
        //Level 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 2), fabricState);
        //Tent Level 5
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 1), fabricState);
        return true;
    }

    /**Build Large Tent North*/
    public boolean buildNorthLarge(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 4), fabricState);

        //Add Tent Block
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        //Tent lvl 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 4), fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        //Tent lvl 5
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        //Tent lvl 6
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        return true;
    }

    /**Build Large Tent East*/
    public boolean buildEastLarge(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 4,pos.getZ()), this.getDefaultState());
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        //Tent lvl 3
        //replaced Doors
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() + 1), fabricState);

        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        //Tent lvl 5
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        //Tent lvl 6
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        return true;
    }

    /**Build Large Tent South*/
    public boolean buildSouthLarge(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 4,pos.getZ()), this.getDefaultState());
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        //Tent lvl 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 2,pos.getZ() + 4), fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        //Tent lvl 5
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        //Tent lvl 6
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        return true;
    }

    /**Build Large Tent West*/
    public boolean buildWestLarge(World worldIn, BlockPos pos)
    {
        Block fabric = ModBlocks.tentFabric;
        IBlockState fabricState = fabric.getStateFromMeta(getFabricType(TentType));

        //Add Tent Block
        worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() + 4,pos.getZ()), this.getDefaultState());
        //Tent lvl 1
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 0,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 0,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 0,pos.getZ() + 4), fabricState);
        //Tent lvl 2
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 1,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 1,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 1,pos.getZ() + 4), fabricState);
        //Tent lvl 3
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 2,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 2,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 2,pos.getZ() + 4), fabricState);
        //Tent lvl 4
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 3,pos.getZ() + 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 4,pos.getY() + 3,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 3,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 3,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() - 4), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 3,pos.getZ() + 4), fabricState);
        //Tent lvl 5
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 4,pos.getZ() + 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 3,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 2,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 3), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() - 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 2), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 4,pos.getZ() + 3), fabricState);
        //Tent lvl 6
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() + 0,pos.getY() + 5,pos.getZ() + 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 1), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() - 0), fabricState);
        worldIn.setBlockState(new BlockPos(pos.getX() - 1,pos.getY() + 5,pos.getZ() + 1), fabricState);
        return true;
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && World.doesBlockHaveSolidTopSurface(worldIn, pos.down());
    }

    /**
     * Called by ItemBlockspos.getY()ust before a block is actually set in the world, to allow for adjustments to the
     * IBlockstate
     */
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }

    /**Camp Hammer is in hand*/
    public static boolean CampHammerEquipped(EntityPlayer playerIn)
    {
        ItemStack itemstack = playerIn.getCurrentEquippedItem();
        return itemstack != null && itemstack.getItem() == ModItems.campHammer;
    }

}


