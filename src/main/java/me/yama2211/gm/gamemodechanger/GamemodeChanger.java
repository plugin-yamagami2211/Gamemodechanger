package me.yama2211.gm.gamemodechanger;

import org.bukkit.Bukkit;
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
        if(sender instanceof Player){
            Player player = (Player) sender;
            String targetName = args[1];
            Player targetPlayer = Bukkit.getPlayer(targetName);
            /* /gm <0|1|2|3> */
            if(targetPlayer == null){
                /*サバイバル*/
                if(cmd.getName().equalsIgnoreCase("0")){
                    if(player.hasPermission("gamemode.survival")){
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("Gamemode"+".Survival")));
                    }
            }
                /*クリエイティブ*/
                if(cmd.getName().equalsIgnoreCase("1")){
                    if(player.hasPermission("gamemode.creative")){
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("Gamemode"+".Creative")));
                    }
            }
                /*アドベンチャー*/
                if(cmd.getName().equalsIgnoreCase("2")){
                    if(player.hasPermission("gamemode.adventure")){
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("Gamemode"+".Adventure")));
                    }
                }

                /*スペクテイター*/
                if(cmd.getName().equalsIgnoreCase("3")){
                    if(player.hasPermission("gamemode.spectator")){
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("Gamemode"+".Spectator")));
                    }
                }
        }
            /* /gm <0|1|2|3> [playername] */
            if(cmd.getName().equalsIgnoreCase("0")){
                /* サバイバル */
                if(player.hasPermission("gamemode.survival")) {
                    targetPlayer.setGameMode(GameMode.SURVIVAL);
                    String ChSu = getConfig().getString("Gamemode" + ".Player" + ".Survival");
                    ChSu = ChSu.replaceAll("%player", targetPlayer.getName());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChSu));
                    targetPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', ChSu));
                }
            }

            if(cmd.getName().equalsIgnoreCase("1")){
                /* クリエイティブ */
                if(player.hasPermission("gamemode.creative")) {
                    targetPlayer.setGameMode(GameMode.CREATIVE);
                    String ChCr = getConfig().getString("Gamemode" + ".Player" + ".Creative");
                    ChCr = ChCr.replaceAll("%player", targetPlayer.getName());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChCr));
                    targetPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', ChCr));
                }
            }

            if(cmd.getName().equalsIgnoreCase("2")){
                /* アドベンチャー */
                if(player.hasPermission("gamemode.adventure")) {
                    targetPlayer.setGameMode(GameMode.ADVENTURE);
                    String ChAd = getConfig().getString("Gamemode" + ".Player" + ".Adventure");
                    ChAd = ChAd.replaceAll("%player", targetPlayer.getName());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChAd));
                    targetPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', ChAd));
                }
            }

            if(cmd.getName().equalsIgnoreCase("3")){
                /* スペクテイター */
                if(player.hasPermission("gamemode.spectator")) {
                    targetPlayer.setGameMode(GameMode.SPECTATOR);
                    String ChSp = getConfig().getString("Gamemode" + ".Player" + ".Spectator");
                    ChSp = ChSp.replaceAll("%player", targetPlayer.getName());
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChSp));
                    targetPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', ChSp));
                }
            }

        }

        return true;
    }
}
