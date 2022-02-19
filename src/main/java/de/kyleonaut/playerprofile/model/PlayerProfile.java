package de.kyleonaut.playerprofile.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * @author kyleonaut
 * @version 1.0.0
 * created at 19.02.2022
 */
@Data
@NoArgsConstructor
public class PlayerProfile {
    private String id;
    private String name;
    private List<Property> properties;

    public UUID getUUID() {
        return UUID.fromString(this.id.replaceAll(
                "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",
                "$1-$2-$3-$4-$5"));
    }
}
