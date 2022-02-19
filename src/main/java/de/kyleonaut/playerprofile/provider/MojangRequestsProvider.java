package de.kyleonaut.playerprofile.provider;

import de.kyleonaut.playerprofile.requests.MojangRequests;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
public class MojangRequestsProvider implements Provider<MojangRequests> {
    @Override
    public MojangRequests provide() {
        return new Retrofit.Builder()
                .baseUrl("https://sessionserver.mojang.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(MojangRequests.class);
    }
}
