package senpai;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import senpai.loli.KurumiManager;

/**
 * Created by frostbyte on 3/16/16.
 */
@Mod(version = "Baka senpai", modid = "Someweebshit", name = "Yandere")
public class Yandere {
    public KurumiManager kurunmis;
    @Mod.EventHandler
    public static void PreInit (FMLPreInitializationEvent fmlPreInitializationEvent){
        System.out.println("Pre");
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent fmlInitializationEvent) throws InstantiationException, IllegalAccessException {
        System.out.println("init");
        kurunmis = new KurumiManager();
        if(Loader.isModLoaded("tconstruct")){
            System.out.println("Init found the mod this is noice");
        }
    }
    @Mod.EventHandler
    public static void PostInit (FMLPostInitializationEvent fmlPostInitializationEvent) {

    }
}
