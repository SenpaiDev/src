package Senpai.YandereForge.Handlers;

import Senpai.YandereForge.Kurumis.Hammer;
import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import com.darkmagician6.eventapi.events.KeyEvent;
import net.minecraftforge.event.world.ChunkDataEvent;
import net.minecraftforge.fml.common.Loader;
import org.reflections.Reflections;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by anonc on 17.03.2016.
 */
public class KurumiHandler {
    private final TreeMap<String, Kurumi> Kurunmis = new TreeMap<String, Kurumi>(
            new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });

    public KurumiHandler() throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("Senpai.YandereForge.Kurumis");
        Set<Class<? extends Kurumi>> classes = reflections.getSubTypesOf(Kurumi.class);
        for (Class<? extends Kurumi> class1 : classes) {
            Kurumi kurumi = class1.newInstance();
            if(kurumi.getModDep().length() < 1){
                Kurunmis.put(kurumi.getName(), kurumi);
            } else if(Loader.isModLoaded(kurumi.getModDep())){
                Kurunmis.put(kurumi.getName(), kurumi);
            } else {
                System.out.println(kurumi.getName() +" Is dependent on" + kurumi.getModDep() + " And has been disabled due to it not being installed");
            }
            kurumi.InitModDeps();
        }
    }
    /*
    public void checkforaddionalsets(Kurumi kurumi){
        System.out.println("Looking for deps on " + kurumi.getName());
        if(kurumi.getModSetDepCount() < 1){
            System.out.println(kurumi.getName() + " Has no Additional settings");
            return;
        } else {
            for (int x=1; x <= kurumi.getModSetDepCount(); x++){
                if(Loader.isModLoaded(kurumi.getModSetDep(x))){
                    System.out.println(x);
                    System.out.println(kurumi.getModSetDep(x) + "Was found");
                    kurumi.setModSetDepReturned(x, true);
                } else {
                    System.out.println(x);
                    System.out.println(kurumi.getModSetDep(x) + " Was not found, features related to it has been disabled");
                }
            }
        }
    }

    */


    public Kurumi getKurumiByClass(Class<?> kurumi){
        System.out.println("Meme");
        return Kurunmis.get(kurumi.getAnnotation(Kurumi.index.class).name());
    }
    public Kurumi getKurunmiByName(String name){
        return Kurunmis.get(name);
    }
    public Collection<Kurumi> getAllKurunmis(){
        return Kurunmis.values();
    }
    public int CountKurunmis(){
        return Kurunmis.size();
    }

}
