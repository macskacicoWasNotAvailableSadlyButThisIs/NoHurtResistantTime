package com.macskacico.nohurtresistancetime;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;


@Mod(modid = NoHurtResistantTime.MODID, version = NoHurtResistantTime.VERSION)
public class NoHurtResistantTime
{
    public static final String MODID = "NoHurtResistantTime";
    public static final String VERSION = "1.1";
    public static boolean playerHurtResistantTime = false;
    public static boolean extraHurtResistantTime = false;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ServerTickHandler(null));
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        try {
            config.load();

            Property playerHurtResistantTimeProp = config.get(Configuration.CATEGORY_GENERAL,"Player Hurt Resistant Time", false, "set true if you want players to have Hurt Resistance time.");
            Property extraHurtResistantTimeProp = config.get(Configuration.CATEGORY_GENERAL,"Extra Hurt Resistant Time", false, "set true if you want Hurt Resistance Time on lava, cactus, standing in fire, for being in the void and from sufficating inside blocks");

            playerHurtResistantTime = playerHurtResistantTimeProp.getBoolean();
            extraHurtResistantTime = extraHurtResistantTimeProp.getBoolean();
            */
        } catch (Exception e) {
        } finally {
            if (config.hasChanged()) config.save();


        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
