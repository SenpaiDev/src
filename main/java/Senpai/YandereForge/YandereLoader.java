package Senpai.YandereForge;

import Senpai.YandereForge.Handlers.KurumiHandler;
import Senpai.YandereForge.Kurumis.Hammer;
import com.darkmagician6.eventapi.EventManager;
import com.google.common.eventbus.EventBus;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

/**
 * Created by anonc on 18.03.2016.
 */
public class YandereLoader extends DummyModContainer {
    public YandereLoader() throws IllegalAccessException, InstantiationException {
        super(new ModMetadata());
        ModMetadata modMetadata = getMetadata();
        modMetadata.name = "Yandere Loader";
        modMetadata.version = "Underage";
        modMetadata.modId = "YANDERELOADAH";
        this.Init();
    }
    public YandereLoader instance;
    public KurumiHandler kurumiHandler;
    public void Init() throws InstantiationException, IllegalAccessException {
        instance = this;
        kurumiHandler = new KurumiHandler();
        MinecraftForge.EVENT_BUS.register(this);
    }
    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
    @SubscribeEvent
    public void tick(TickEvent.ClientTickEvent clientTickEvent){
        EventManager.call(new com.darkmagician6.eventapi.events.TickEvent());
    }
    @SubscribeEvent
    public void onkey(InputEvent.KeyInputEvent keyInputEvent){
        if(Keyboard.isKeyDown(Keyboard.KEY_O)){

            kurumiHandler.getKurumiByClass(Hammer.class).toggle();
        }
    }
}
