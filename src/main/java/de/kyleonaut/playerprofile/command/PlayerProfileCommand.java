package de.kyleonaut.playerprofile.command;

import de.kyleonaut.playerprofile.api.PlayerProfileApi;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
public class PlayerProfileCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("playerprofileapi.command")) {
            sender.sendMessage("§cInsufficient permissions");
            return false;
        }
        if (args.length != 1) {
            sender.sendMessage("§cSyntax error! Please use §4/playerprofile <uuid>");
            return false;
        }
        try {
            final UUID uuid = UUID.fromString(args[0]);
            PlayerProfileApi.getInstance().getPlayerProfile(uuid, playerProfile -> {
                if (playerProfile.isEmpty()) {
                    sender.sendMessage("§cNo profile found with the provided UUID!");
                    return;
                }
                sender.sendMessage("§7Name: §e" + playerProfile.get().getName());
                sender.sendMessage("§7UUID: §e" + playerProfile.get().getUUID());
                final TextComponent textComponent = new TextComponent("§7Skin-Value: §e" + playerProfile.get().getProperties().get(0).getValue());
                textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, playerProfile.get().getProperties().get(0).getValue()));
                textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§7Click to copy!")));
                sender.spigot().sendMessage(textComponent);
            });
            return true;
        } catch (Exception e) {
            sender.sendMessage("§cThe provided UUID is not valid!");
            return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 1) {
            final List<String> uuids = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                uuids.add(player.getUniqueId().toString());
            }
            return uuids;
        }
        return new ArrayList<>();
    }
}
