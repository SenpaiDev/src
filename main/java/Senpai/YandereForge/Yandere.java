package Senpai.YandereForge;

import Senpai.YandereForge.Handlers.KurumiHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by anonc on 17.03.2016.
 */
@Mod(name = "YandereForge", version = "1", modid = "audauid")
public class Yandere {

    public KurumiHandler kurumiHandler;

    @Mod.EventHandler
    public void Init(FMLInitializationEvent fmlInitializationEvent){
        kurumiHandler = new KurumiHandler();
    }
}
