package de.kyleonaut.playerprofile.api;

import de.kyleonaut.playerprofile.PlayerProfilePlugin;
import de.kyleonaut.playerprofile.model.PlayerProfile;
import de.kyleonaut.playerprofile.service.PlayerProfileService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
@RequiredArgsConstructor
public class PlayerProfileImpl implements PlayerProfileApi {
    private final PlayerProfileService playerProfileService;

    @Override
    public void getPlayerProfile(UUID uuid, Consumer<Optional<PlayerProfile>> playerProfile) {
        this.playerProfileService.getPlayerProfileByUUID(uuid, playerProfile::accept);
    }
}
