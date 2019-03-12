package com.fantasticsource.yourenotthebossofme;

import net.minecraftforge.common.config.Config;

@Config(modid = YoureNotTheBossOfMe.MODID)
public class NoBossConfig
{
    @Config.Name("Untamables")
    @Config.RequiresMcRestart
    public static String[] untamableEntities = {};
}
