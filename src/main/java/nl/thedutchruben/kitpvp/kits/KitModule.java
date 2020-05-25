package nl.thedutchruben.kitpvp.kits;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.kits.object.Kit;
import nl.thedutchruben.kitpvp.registery.Module;

import java.util.List;
import java.util.Optional;

public class KitModule extends Module {
    private List<Kit> kits;
    /**
     * Loading of the module
     * This wil be called in the onEnable of the plugin
     */
    @Override
    public void load() {
        kits = KitPvp.getInstance().getStorageModule().getStorage().loadKits();
    }

    /**
     * Unloading of the module
     * This wil be called in the onDisable of the plugin
     */
    @Override
    public void unLoad() {

    }

    public List<Kit> getKits() {
        return kits;
    }

    public Optional<Kit> getKitById(int id){
        return kits.stream().filter(kit -> kit.getId() == id).findFirst();
    }
}
