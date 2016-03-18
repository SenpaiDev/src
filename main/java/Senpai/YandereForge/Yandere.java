package Senpai.YandereForge;

import Senpai.YandereForge.Handlers.KurumiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import scala.tools.cmd.Instance;
import scala.tools.cmd.Opt;
import sun.security.jca.GetInstance;

/**
 * Created by anonc on 17.03.2016.
 */
@Mod(name = "YandereForge", version = "1", modid = "audauid")
public class Yandere {
    public KurumiHandler kurumiHandler;
    public static Yandere instance;

    @Mod.EventHandler
    public void Preinit(FMLPreInitializationEvent fmlInitializationEvent) {
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent fmlInitializationEvent) throws InstantiationException, IllegalAccessException {
        kurumiHandler = new KurumiHandler();
    }
    @SubscribeEvent
    public void tickevent (TickEvent.ClientTickEvent clientTickEvent){

    }

}
