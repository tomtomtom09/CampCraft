package com.tomtomtom09.campcraft.block;

import com.tomtomtom09.campcraft.creativetab.CCItemTab;
import com.tomtomtom09.campcraft.handler.EnumTentType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockCamoTentBase extends Block implements IMetaBlockName
{
    public static final PropertyEnum TENTTYPE = PropertyEnum.create("type", EnumTentType.class);
    private int[] Lvl0Id;
    private int[] areaId;

    public BlockCamoTentBase(String unlocalizedName, int tentSize)
    {
        super(Material.cloth);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CCItemTab.CC_TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TENTTYPE, EnumTentType.JUNGLE));
        if (tentSize == 1)
        {	Lvl0Id = new int[24];
            areaId = new int[51]; }
        if (tentSize == 2)
        {	Lvl0Id = new int[41];
            areaId = new int[144];}
        if (tentSize == 3)
        {	Lvl0Id = new int[69];
            areaId = new int[311];}
    }

    @Override @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list)
    {
        for(EnumTentType enumtenttype : EnumTentType.values())
        {
            list.add(new ItemStack(item, 1, enumtenttype.getMetadata()));
        }
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {TENTTYPE});
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TENTTYPE, EnumTentType.byMetaData(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumTentType)state.getValue(TENTTYPE)).getMetadata();
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(state);
    }

    @Override
    public String getSpecialName(ItemStack stack)
    {
        if(stack.getItemDamage() == 0)
        {
            return "Jungle";
        }
        if(stack.getItemDamage() == 1)
        {
            return "Desert";
        }
        if(stack.getItemDamage() == 2)
        {
            return "Tundra";
        }
        if(stack.getItemDamage() == 3)
        {
            return "Nether";
        }
        if(stack.getItemDamage() == 4)
        {
            return "Pink";
        }
        if(stack.getItemDamage() == 5)
        {
            return "Yellow";
        }
        if(stack.getItemDamage() == 6)
        {
            return "Brown";
        }
        if(stack.getItemDamage() == 7)
        {
            return "Black";
        }
        if(stack.getItemDamage() == 8)
        {
            return "Blue";
        }
        if(stack.getItemDamage() == 9)
        {
            return "Green";
        }
        if(stack.getItemDamage() == 10)
        {
            return "Converter";
        }
        return "Jungle";
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }
}


