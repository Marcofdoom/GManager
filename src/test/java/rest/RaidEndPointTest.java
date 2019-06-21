package rest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RaidEndPointTest {

	@InjectMocks
	private RaidEndPoint raidEndPoint;

	@Test
	public void addRaidTest() {
		assertTrue(raidEndPoint.addRaid() == null);
	}
}