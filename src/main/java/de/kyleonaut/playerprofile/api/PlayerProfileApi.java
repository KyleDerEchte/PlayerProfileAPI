package de.kyleonaut.playerprofile.api;

import de.kyleonaut.playerprofile.PlayerProfilePlugin;
import de.kyleonaut.playerprofile.model.PlayerProfile;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
public interface PlayerProfileApi {
    /**
     * Get a PlayerProfile by the given UUID
     *
     * @param uuid          The UUID of the player
     * @param playerProfile The consumer with the given profile
     */
    void getPlayerProfile(UUID uuid, Consumer<Optional<PlayerProfile>> playerProfile);

    static PlayerProfileApi getInstance() {
        return PlayerProfilePlugin.getPlugin(PlayerProfilePlugin.class).getPlayerProfileApi();
    }
}
