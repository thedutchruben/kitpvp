package nl.thedutchruben.kitpvp.modules.kits;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.kits.Kit;
import nl.thedutchruben.kitpvp.framework.registery.Module;
import nl.thedutchruben.kitpvp.modules.kits.commands.KitCommand;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class KitModule extends Module {
    private List<Kit> kits;
    /**
     * Loading of the module
     * This wil be called in the onEnable of the plugin
     */
    @Override
    public void load() {
        //Load the kits
        kits = KitPvp.getInstance().getStorageModule().getStorage().loadKits();
        Bukkit.getLogger().log(Level.INFO,kits.size() + " kits loaded!");

        //Register command
        registerCommand(new KitCommand());
    }

    /**
     * Unloading of the module
     * This wil be called in the onDisable of the plugin
     */
    @Override
    public void unLoad() {
        kits.clear();
    }

    public List<Kit> getKits() {
        return kits;
    }

    public Optional<Kit> getKitById(int id){
        return kits.stream().filter(kit -> kit.getId() == id).findFirst();
    }
}
