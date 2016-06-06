package com.tomtomtom09.campcraft.handler;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler
{
    public static Configuration configuration;

    public static void init(File configFile)
    {
        Configuration configuration = new Configuration();

        try
        {
            configuration.load();
            boolean configValues = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "").getBoolean(true);
        }
        catch(Exception e)
        {

        }
        finally
        {
            if (configuration.hasChanged())
            {
                configuration.save();
            }
        }
    }
}
