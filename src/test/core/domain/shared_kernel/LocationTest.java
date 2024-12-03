package core.domain.shared_kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocationTest {

    @Test
    public void testCreateLocation() {
        Assertions.assertEquals(5, Location.create(5, 9).getX());
        Assertions.assertEquals(9, Location.create(5, 9).getY());
    }

    @Test
    public void testCreateLocation__incorrectCoordinates() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Location.create(15, 9)
        );

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Location.create(8, 11)
        );

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Location.create(0, 4)
        );

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Location.create(5, -1)
        );
    }

    @Test
    public void testCreateRandomLocation() {
        Location randomLocation = Location.createRandom();
        Assertions.assertTrue(randomLocation.getX() > 0 && randomLocation.getX() < 11);
        Assertions.assertTrue(randomLocation.getY() > 0 && randomLocation.getY() < 11);
    }

    @Test
    public void testDistanceTo() {
        Location sourceLocation = Location.create(1, 3);
        Location targetLocation = Location.create(5, 6);
        Assertions.assertEquals(7, sourceLocation.distanceTo(targetLocation));
    }

    @Test
    public void equalLocations() {
        Location sourceLocation = Location.create(1, 3);
        Location targetLocation = Location.create(1, 3);
        Assertions.assertEquals(sourceLocation, targetLocation);

        sourceLocation = Location.create(3, 1);
        targetLocation = Location.create(3, 1);
        Assertions.assertEquals(sourceLocation, targetLocation);

        sourceLocation = Location.create(3, 1);
        targetLocation = Location.create(1, 3);
        Assertions.assertNotEquals(sourceLocation, targetLocation);
    }
}
