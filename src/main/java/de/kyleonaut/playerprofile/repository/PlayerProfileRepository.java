package de.kyleonaut.playerprofile.repository;

import de.kyleonaut.playerprofile.model.PlayerProfile;
import de.kyleonaut.playerprofile.requests.MojangRequests;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
@RequiredArgsConstructor
public class PlayerProfileRepository {
    private final MojangRequests mojangRequests;

    public Optional<PlayerProfile> getPlayerProfileByUUID(UUID uuid){
        try{
            final Response<PlayerProfile> response = this.mojangRequests.getPlayerProfileByUUID(uuid).execute();
            if (response.isSuccessful() && response.body() != null){
                return Optional.of(response.body());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
