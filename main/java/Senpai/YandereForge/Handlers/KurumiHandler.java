package Senpai.YandereForge.Handlers;

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

    public KurumiManager() throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("senpai.Kurunmis");
        Set<Class<? extends Kurumi>> classes = reflections.getSubTypesOf(Kurumi.class);
        for (Class<? extends Kurumi> class1 : classes) {
            Kurumi kurunmi = class1.newInstance();
            if(kurunmi.getModDep().length() < 1){
                if(kurunmi.getModSetDep().length() < 1){
                    System.out.println(kurunmi.getName() + " Has no additional Settings and was fully loaded");
                } else if(Loader.isModLoaded(kurunmi.getModSetDep())){
                    System.out.println(kurunmi.getName() + " Has Additional features for the mod " + kurunmi.getModSetDep() + "they where loaded" );
                    kurunmi.setModSetDepLoaded(true);
                } else {
                    System.out.println(kurunmi.getName() + " Has additional features for the mod " + kurunmi.getModSetDep() + " You need to install this mod to use them");
                }
                System.out.println(kurunmi.getName() +", has no mod dependancys and was loaded");
                System.out.println(kurunmi.GetIsModSetDepLoaded() ? "yes" : "no");
                Kurunmis.put(kurunmi.getName(), kurunmi);
            } else if(Loader.isModLoaded(kurunmi.getModDep())){
                System.out.println(kurunmi.getName() + "'s dependency of " + kurunmi.getModDep() + " was found and loaded");
                Kurunmis.put(kurunmi.getName(), kurunmi);
            } else {
                System.out.println(kurunmi.getName() + " Is dependent on " + kurunmi.getModDep() + " Please install this mod to use this feature");
            }

        }
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
