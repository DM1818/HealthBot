package prettyMuchEverything;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeneralStatsTest {

	@Test
	public void test() {
		GeneralStats stats = new GeneralStats();
		assertTrue(stats.getHeight() == 0);
		assertTrue(stats.dayReady());
		stats.nextDay();
		assertTrue(stats.getDay() == 2);
	}

}
