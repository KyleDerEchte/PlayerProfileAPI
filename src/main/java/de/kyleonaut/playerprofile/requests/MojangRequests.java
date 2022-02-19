package de.kyleonaut.playerprofile.requests;

import de.kyleonaut.playerprofile.model.PlayerProfile;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
public interface MojangRequests {

    @GET("session/minecraft/profile/{uuid}")
    Call<PlayerProfile> getPlayerProfileByUUID(@Path(value = "uuid") UUID uuid);
}
