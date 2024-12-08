package core.domain.model.courier_aggregate;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum Transport {
    PEDESTRIAN("pedestrian", 1),
    BICYCLE("bicycle", 2),
    CAR("car", 3);

    private final String name;
    private final Integer speed;

    Transport(String name, Integer speed) {
        this.name = name;
        this.speed = speed;
    }

    public Transport fromName(String name) {
        return Arrays.stream(Transport.values())
                .filter(transport -> transport.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Transport with name " + name + " not found"));
    }
}
