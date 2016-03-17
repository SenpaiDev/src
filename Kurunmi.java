package senpai.loli;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frostbyte on 3/16/16.
 */
public class Kurunmi {
    private final String name = getClass().getAnnotation(index.class).name();
    private final String desc = getClass().getAnnotation(index.class).desc();
    private final Nekos neko = getClass().getAnnotation(index.class).neko();
    private final String tags = getClass().getAnnotation(index.class).tags();
    private final String syntax = getClass().getAnnotation(index.class).syntax();
    private final String help = getClass().getAnnotation(index.class).help();
    private  final String ModDep = getClass().getAnnotation(index.class).ModDep();
    private final String[] ModSetDep = getClass().getAnnotation(index.class).ModSetDep();
    private ArrayList<String> ModSetDeps = getClass().getAnnotation(index.class).ModSetDeps();
    private boolean IsModSetDepLoaded = getClass().getAnnotation(index.class).IsmodSetDepLoaded();
    public enum Nekos{
        testing,
        combat;
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface index{
        String name();
        String desc();
        Nekos neko();
        String tags() default "";
        String syntax() default "NØN";
        String help() default "NØN";
        // Does the meme require a mod to work at all
        String ModDep() default "";
        // Features for the mod requierd by hacks
        String[] ModSetDep() default "";
        ArrayList<String> ModSetDeps() default ModSetDeps().add("d", "d");
        boolean IsmodSetDepLoaded() default false;

    }

    public Nekos getNeko() {
        return neko;
    }

    public String getDesc() {
        return desc;
    }

    public String getHelp() {
        return help;
    }

    public String getName() {
        return name;
    }

    public String getSyntax() {
        return syntax;
    }

    public String getModDep() {
        return ModDep;
    }

    public String getTags() {
        return tags;
    }

    public String[] getModSetDep() {
        return ModSetDep;
    }


    public boolean GetIsModSetDepLoaded(){
        return IsModSetDepLoaded;
    }

    public void setModSetDepLoaded(boolean modSetDepLoaded) {
        IsModSetDepLoaded = modSetDepLoaded;
    }
}
