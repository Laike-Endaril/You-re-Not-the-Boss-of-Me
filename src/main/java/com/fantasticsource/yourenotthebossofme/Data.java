package com.fantasticsource.yourenotthebossofme;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;

public class Data
{
    public static ArrayList<Class<? extends Entity>> untamables = new ArrayList<>();

    static
    {
        EntityEntry entry;
        for (String string : NoBossConfig.untamableEntities)
        {
            if (string.equals("player")) untamables.add(EntityPlayerMP.class);
            else
            {
                entry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(string));
                if (entry == null) System.err.println("ResourceLocation for entity \"" + string + "\" not found!");
                else untamables.add(entry.getEntityClass());
            }
        }
    }
}
