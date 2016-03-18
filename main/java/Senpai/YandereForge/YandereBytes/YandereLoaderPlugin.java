package Senpai.YandereForge.YandereBytes;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * Created by anonc on 18.03.2016.
 */
@IFMLLoadingPlugin.TransformerExclusions("Senpai.YandereForge")
public class YandereLoaderPlugin implements IFMLLoadingPlugin {

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                ""
        };
    }

    @Override
    public String getModContainerClass() {
        return "Senpai.YandereForge.YandereLoader";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
