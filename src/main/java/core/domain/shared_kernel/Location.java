package core.domain.shared_kernel;

import java.util.concurrent.ThreadLocalRandom;

import lombok.Getter;


@Getter
public class Location {
    private final int x;
    private final int y;

    public static final Location MIN_LOCATION = new Location(1, 1);
    public static final Location MAX_LOCATION = new Location(10, 10);

    private Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Location create(int x, int y) {
        validateMinCoordValue(x, y);
        validateMaxCoordValue(x, y);
        return new Location(x, y);
    }

    public static Location createRandom() {
        int randomX = ThreadLocalRandom.current().nextInt(MIN_LOCATION.x, MAX_LOCATION.x + 1);
        int randomY = ThreadLocalRandom.current().nextInt(MIN_LOCATION.y, MAX_LOCATION.y + 1);
        return new Location(randomX, randomY);
    }

    public int distanceTo(Location target) {
        return Math.abs(this.x - target.x) + Math.abs(this.y - target.y);
    }

    private static void validateMinCoordValue(int x, int y) {
        if (x < MIN_LOCATION.x || y < MIN_LOCATION.y) {
            throw new IllegalArgumentException("Location coordinates must be equal or greater than MIN_LOCATION");
        }
    }

    private static void validateMaxCoordValue(int x, int y) {
        if (x > MAX_LOCATION.x || y > MAX_LOCATION.y) {
            throw new IllegalArgumentException("Location coordinates must be equal or less than MAX_LOCATION");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        return this.x == other.x && this.y == other.y;
    }
}
