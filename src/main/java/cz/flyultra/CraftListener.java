package cz.flyultra;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {
    private Main plugin;

    public CraftListener() {
        this.plugin = Main.getInstance();
    }

    /**
     *
     * This event block all prepare of craft
     * And response with message "§7Never say ever!"
     *
     * @param event PrepareItemCraftEvent
     */
    @EventHandler
    public void onInventoryClick(PrepareItemCraftEvent event) {
        Player player = (Player) event.getView().getPlayer();

        if (event.getInventory().getMatrix() == null) {
            return;
        }

        if (event.getInventory().getContents() == null) {
            return;
        }

        for (ItemStack itemStack : event.getInventory().getContents()) {

            if (itemStack == null || itemStack.getItemMeta() == null) {
                continue;
            }

            player.sendMessage("§7Never say ever!");
            player.closeInventory();
        }

    }

}
