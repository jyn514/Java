import org.junit.Assert;
import org.junit.Test;

public class CoinCounterTest extends CoinCounter {
	
	@Test
	public final void handlesSingleTypes() {
		Assert.assertEquals(CoinCounter.calculate(25).get(25),  1);
		Assert.assertEquals(CoinCounter.calculate(10).get(10), 1);
		Assert.assertEquals(CoinCounter.calculate(5).get(5), 1);
		Assert.assertEquals(CoinCounter.calculate(1).get(1), 1);
	}
	
	@Test
	public final void handlesAllTypesAtOnce() {
		Assert.assertEquals(CoinCounter.calculate(41), new int[] {41, 1, 1, 1, 1});
	}
	
	@Test
	public final void handlesMoreThanOneCoin() {
		Assert.assertEquals(CoinCounter.calculate(11), new int[] { 11, 0, 1, 0, 1 });
	}
	
	@Test
	public final void handlesZero() {
		Assert.assertEquals(CoinCounter.calculate(0), new int[] { 0, 0, 0, 0, 0 });
	}
	
	@Test
	public final void handlesMultipleTypes() {
		Assert.assertEquals(CoinCounter.calculate(45), new int[] { 45, 1, 2, 0, 0 });
	}
	
	@Test
	public final void handlesNinetyNine() {
		Assert.assertEquals(CoinCounter.calculate(99), new int[] { 99, 3, 2, 0, 4 });
	}
}
