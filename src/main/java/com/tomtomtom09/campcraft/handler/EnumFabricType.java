package com.tomtomtom09.campcraft.handler;

import net.minecraft.util.IStringSerializable;

public enum EnumFabricType implements IStringSerializable
{
    JUNGLE(0, "Jungle"),
    DESERT(1, "Desert"),
    TUNDRA(2, "Tundra"),
    NETHER(3, "Nether"),
    PINK(4, "Pink"),
    YELLOW(5, "Yellow"),
    BROWN(6, "Brown"),
    BLACK(7, "Black"),
    BLUE(8, "Blue"),
    GREEN(9, "Green");

    private static final EnumFabricType[] META_LOOKUP = new EnumFabricType[values().length];
    private int meta;
    private String name;

    private EnumFabricType(int meta, String name)
    {
        this.meta = meta;
        this.name = name;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public static EnumFabricType byMetaData(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }
        return META_LOOKUP[meta];
    }

    public String getName()
    {
        return this.name;
    }


    @Override
    public String toString()
    {
        return getName();
    }

    static
    {
        for(EnumFabricType enumfabrictype : values())
        {
            META_LOOKUP[enumfabrictype.getMetadata()] = enumfabrictype;
        }
    }
}

