package com.tomtomtom09.campcraft.handler;

import net.minecraft.util.IStringSerializable;

public enum EnumTentType implements IStringSerializable
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
    GREEN(9, "Green"),
    CONVERTER(10, "Converter");

    private static final EnumTentType[] META_LOOKUP = new EnumTentType[values().length];
    private int meta;
    private String name;

    private EnumTentType(int meta, String name)
    {
        this.meta = meta;
        this.name = name;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public static EnumTentType byMetaData(int meta)
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
        for(EnumTentType enumtenttype : values())
        {
            META_LOOKUP[enumtenttype.getMetadata()] = enumtenttype;
        }
    }
}

