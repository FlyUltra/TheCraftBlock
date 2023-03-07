package cz.flyultra;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        registerListener(new CraftListener());
    }

    @Override
    public void onDisable() {

    }

    public void registerCommand(CommandExecutor commandExecutor, String cmd) {
        Objects.requireNonNull(getCommand(cmd)).setExecutor(commandExecutor);}

    public void registerTabCompleter(TabCompleter commandExecutor, String cmd) {
        Objects.requireNonNull(getCommand(cmd)).setTabCompleter(commandExecutor);}

    public void registerListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }


    public static Main getInstance() {
        return instance;
    }

}