package Senpai.YandereForge.Kurumis;

import Senpai.YandereForge.Handlers.Kurumi;
import Senpai.YandereForge.Handlers.KurumiUtils;
import Senpai.YandereForge.Yandere;

/**
 * Created by anonc on 17.03.2016.
 */
@Kurumi.index(name = "Hammer", neko = Kurumi.Nekos.combat, desc = "Hammer", ModSetDepCount = 2, ModSetDep = "tconstruct : buildcraft")
public class Hammer extends Kurumi {
    public void hammer(){
        if(Yandere.instance.kurumiHandler.getKurunmiByName("Hammer").getModSetDepReturned(1)){

        }
    }

}
