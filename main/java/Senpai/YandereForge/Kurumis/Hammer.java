package Senpai.YandereForge.Kurumis;

import Senpai.YandereForge.Handlers.Kurumi;
import Senpai.YandereForge.Handlers.KurumiUtils;
import Senpai.YandereForge.Yandere;
import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

/**
 * Created by anonc on 17.03.2016.
 */
@Kurumi.index(name = "Hammer", neko = Kurumi.Nekos.combat, desc = "Hammer", keybind = Keyboard.KEY_I)
public class Hammer extends Kurumi {
    @Override
    public void InitModDeps() {
        if(Loader.isModLoaded("tconstruct"))
            System.out.println("Tinkers construct loaded I can now do seettings spesific :D");
    }

    @Override
    public void onEnable() {
        EventManager.register(this);
    }

    @Override
    public void onDisable() {
        EventManager.unregister(this);
        super.onDisable();
    }
    @EventTarget
    public void onTick(TickEvent event){
        System.out.println("Tick");
    }
}
