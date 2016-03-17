package Senpai.YandereForge.Kurumis;

import Senpai.YandereForge.Handlers.Kurumi;
import Senpai.YandereForge.Handlers.KurumiUtils;
import Senpai.YandereForge.Yandere;

/**
 * Created by anonc on 17.03.2016.
 */
@Kurumi.index(name = "Hammer", neko = Kurumi.Nekos.combat, desc = "Hammer")
public class Hammer extends Kurumi {
    @Override
    public void InitModDeps() {
        System.out.println("Mod Inisiated: Hammer");
        super.InitModDeps();
    }
}
