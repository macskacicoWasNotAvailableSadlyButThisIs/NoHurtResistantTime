package com.macskacico.nohurtresistancetime;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import static com.macskacico.nohurtresistancetime.NoHurtResistantTime.playerHurtResistantTime;
import static com.macskacico.nohurtresistancetime.NoHurtResistantTime.extraHurtResistantTime;

public class ServerTickHandler {

    private Minecraft mc;

    public ServerTickHandler(Minecraft mc) {
        this.mc = mc;
    }


    @SubscribeEvent
    public void Hit(LivingAttackEvent event) {
        if (playerHurtResistantTime) {
            if (!(event.entity instanceof EntityPlayer))
                if (extraHurtResistantTime) {
                    if (event.source.getDamageType() != DamageSource.lava.getDamageType()
                            && event.source.getDamageType() != DamageSource.inFire.damageType
                            && event.source.getDamageType() != DamageSource.outOfWorld.getDamageType()
                            && event.source.getDamageType() != DamageSource.inWall.getDamageType()
                            && event.source.getDamageType() != DamageSource.cactus.getDamageType())
                        event.entity.hurtResistantTime = 0;
                } else event.entity.hurtResistantTime = 0;
        } else {
            if (extraHurtResistantTime) {
                if (event.source.getDamageType() != DamageSource.lava.getDamageType()
                        && event.source.getDamageType() != DamageSource.inFire.damageType
                        && event.source.getDamageType() != DamageSource.outOfWorld.getDamageType()
                        && event.source.getDamageType() != DamageSource.inWall.getDamageType()
                        && event.source.getDamageType() != DamageSource.cactus.getDamageType())
                    event.entity.hurtResistantTime = 0;
            } else event.entity.hurtResistantTime = 0;
        }
    }
}
