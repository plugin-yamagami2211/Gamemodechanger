/*
*
* GamemodeChanger
*
* */

package me.yama2211.gm.gamemodechanger;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class GamemodeChanger extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player) {
            Player player = (Player) sender;


            if (cmd.getName().equalsIgnoreCase("gm")) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "/gm <0|1|2|3> [playername]");
                }

                if (args.length == 1) {
                        /*サバイバル*/
                        if (args[0].equalsIgnoreCase("0")) {
                            if (!player.hasPermission("gamemode.survival")) {
                                player.sendMessage(ChatColor.RED + "権限がありません。");
                            }
                            else{
                                player.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Gamemode" + ".Survival")));
                            }
                        }
                        /*クリエイティブ*/
                        if (args[0].equalsIgnoreCase("1")) {
                            if (!player.hasPermission("gamemode.creative")) {
                                player.sendMessage(ChatColor.RED + "権限がありません。");
                            }
                            else{
                                player.setGameMode(GameMode.CREATIVE);
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Gamemode" + ".Creative")));
                            }
                        }
                        /*アドベンチャー*/
                        if (args[0].equalsIgnoreCase("2")) {
                            if (!player.hasPermission("gamemode.adventure")) {
                                player.sendMessage(ChatColor.RED + "権限がありません。");
                            }
                            else{
                                player.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Gamemode" + ".Adventure")));
                            }
                        }

                        /*スペクテイター*/
                        if (args[0].equalsIgnoreCase("3")) {
                            if (!player.hasPermission("gamemode.spectator")) {
                                player.sendMessage(ChatColor.RED + "権限がありません。");
                            }
                            else{
                                player.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("Gamemode" + ".Spectator")));
                            }
                        }
                }//args 1
            }//cmd.getName gm


        }//sender instanceof Player

        return true;
    }
}
