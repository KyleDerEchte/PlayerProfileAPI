package de.kyleonaut.playerprofile;

import de.kyleonaut.playerprofile.api.PlayerProfileApi;
import de.kyleonaut.playerprofile.api.PlayerProfileImpl;
import de.kyleonaut.playerprofile.command.PlayerProfileCommand;
import de.kyleonaut.playerprofile.provider.MojangRequestsProvider;
import de.kyleonaut.playerprofile.repository.PlayerProfileRepository;
import de.kyleonaut.playerprofile.requests.MojangRequests;
import de.kyleonaut.playerprofile.service.PlayerProfileService;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
public class PlayerProfilePlugin extends JavaPlugin {
    @Getter
    private MojangRequests mojangRequests;

    @Getter
    private PlayerProfileApi playerProfileApi;

    @SneakyThrows
    @Override
    public void onEnable() {
        this.mojangRequests = MojangRequestsProvider.class.getConstructor().newInstance().provide();
        PlayerProfileRepository playerProfileRepository = new PlayerProfileRepository(this.mojangRequests);
        PlayerProfileService playerProfileService = new PlayerProfileService(playerProfileRepository);
        this.playerProfileApi = new PlayerProfileImpl(playerProfileService);

        Bukkit.getLogger().log(Level.INFO, "§a================");
        Bukkit.getLogger().log(Level.INFO, "§2PlayerProfileAPI by kyleonaut");
        Bukkit.getLogger().log(Level.INFO, "§a================");

        Objects.requireNonNull(getCommand("playerprofile")).setExecutor(new PlayerProfileCommand());
        Objects.requireNonNull(getCommand("playerprofile")).setTabCompleter(new PlayerProfileCommand());
    }
}
