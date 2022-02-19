package de.kyleonaut.playerprofile.service;

import de.kyleonaut.playerprofile.model.PlayerProfile;
import de.kyleonaut.playerprofile.repository.PlayerProfileRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
@RequiredArgsConstructor
public class PlayerProfileService {
    private final PlayerProfileRepository playerProfileRepository;

    public void getPlayerProfileByUUID(UUID uuid, Consumer<Optional<PlayerProfile>> profile) {
        CompletableFuture.runAsync(() -> {
            final Optional<PlayerProfile> playerProfileByUUID = this.playerProfileRepository.getPlayerProfileByUUID(uuid);
            if (playerProfileByUUID.isPresent()){
                profile.accept(playerProfileByUUID);
                return;
            }
            profile.accept(Optional.empty());
        });
    }
}
