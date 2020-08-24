package nl.thedutchruben.kitpvp.framework.storage.exeptions;

import nl.thedutchruben.kitpvp.KitPvp;
import org.bukkit.Bukkit;

public class StorageTypeNotValidException extends Exception{

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public StorageTypeNotValidException() {
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public StorageTypeNotValidException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        System.out.println(getMessage() + " is not a database type of the KitPvp plugin.");
        Bukkit.getPluginManager().disablePlugin(KitPvp.getInstance());
        super.printStackTrace();
    }
}
