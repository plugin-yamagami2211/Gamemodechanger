/*
*
* GamemodeChanger
*
* WebSite1: https://forum.civa.jp/viewtopic.php?f=15&t=368#p1965
* WebSite2: https://mc.yama2211.net/contents/gamemodechanger.html
* SourceCode: https://github.com/plugin-yamagami2211/Gamemodechanger
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
        if(getConfig().getBoolean("Update")){
        new UpdateChecker(this,"GamemodeChanger").getVersion(version -> {
            if (!this.getDescription().getVersion().equalsIgnoreCase(version)) {
                getLogger().info("利用可能なアップデートがあります。配布フォーラムをご確認ください。");
            }
        });
        }
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
                    player.sendMessage(ChatColor.RED + "/gm <0|1|2|3>");
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

            if (cmd.getName().equalsIgnoreCase("gmreload")) {
                if (args.length == 0) {
                    if(sender.hasPermission("gamemode.configreload")){
                        reloadConfig();
                        sender.sendMessage(ChatColor.AQUA + "[GamemodeChanger]" + ChatColor.GREEN + "Configをリロードしました。" );
                    }
                }
            }

        return true;
    }
}
