package Senpai.YandereForge.Kurumis;

import Senpai.YandereForge.Handlers.Kurumi;
import Senpai.YandereForge.Handlers.KurumiUtils;
import Senpai.YandereForge.Yandere;
import net.minecraftforge.fml.common.Loader;

/**
 * Created by anonc on 17.03.2016.
 */
@Kurumi.index(name = "Hammer", neko = Kurumi.Nekos.combat, desc = "Hammer")
public class Hammer extends Kurumi {
    @Override
    public void InitModDeps() {
        if(Loader.isModLoaded("tconstruct"))
            System.out.println("Tinkers construct loaded");
        super.InitModDeps();
    }
}
