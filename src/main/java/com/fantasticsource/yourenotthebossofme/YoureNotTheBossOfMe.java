package com.fantasticsource.yourenotthebossofme;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.entity.living.AnimalTameEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = YoureNotTheBossOfMe.MODID, name = YoureNotTheBossOfMe.NAME, version = YoureNotTheBossOfMe.VERSION)
public class YoureNotTheBossOfMe
{
    public static final String MODID = "yourenotthebossofme";
    public static final String NAME = "You're Not the Boss of Me";
    public static final String VERSION = "1.12.2.002";

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(YoureNotTheBossOfMe.class);
    }

    @SubscribeEvent
    public static void saveConfig(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(MODID)) ConfigManager.sync(MODID, Config.Type.INSTANCE);
    }

    @SubscribeEvent
    public static void tame(AnimalTameEvent event)
    {
        if (Data.untamables.contains(event.getEntity().getClass()))
        {
            event.getTamer().sendMessage(new TextComponentString("§4" + event.getEntity().getName() + " is not tamable!"));
            event.setCanceled(true);
        }
    }
}
