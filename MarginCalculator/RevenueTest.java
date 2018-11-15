import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;

/*
 * ==== Revenue Test ====
 * List of JUnit tests for Margin Calculator program
 */
public class RevenueTest {
	
	private Revenue revCalc;
	// Called to set up before each test
	@BeforeEach
	public void setUp() {
		revCalc = new Revenue();
	}
	// Tests a simple revenue calculation
	@Test
	public void testRevCalc() {
		BigDecimal margin = new BigDecimal("0.2");
		BigDecimal cost = new BigDecimal("400");
		BigDecimal expected = new BigDecimal("500.00");
		assertEquals(expected, revCalc.calculateRevenue(margin, cost));
	}
	// Tests a larger revenue calculation
	@Test
	public void testLargeRevCalc() {
		BigDecimal margin = new BigDecimal("0.8");
		BigDecimal cost = new BigDecimal("850000");
		BigDecimal expected = new BigDecimal("4250000.00");
		assertEquals(expected, revCalc.calculateRevenue(margin, cost));
	}
	// Tests we get the correct answer if the margin is set to 0
	@Test
	public void testNoMargin() {
		BigDecimal margin = new BigDecimal("0.0");
		BigDecimal cost = new BigDecimal("800");
		BigDecimal expected = new BigDecimal("800.00");
		assertEquals(expected, revCalc.calculateRevenue(margin, cost));
	}
	// Tests an unacceptable margin
	@Test
	public void testMarginError() {
		BigDecimal margin = new BigDecimal("1.5");
		BigDecimal cost = new BigDecimal("400");
		assertNull(revCalc.calculateRevenue(margin, cost));
	}
	// Tests an unacceptable cost
	@Test
	public void testCostError() {
		BigDecimal margin = new BigDecimal("0.2");
		BigDecimal cost = new BigDecimal("-50");
		assertNull(revCalc.calculateRevenue(margin, cost));
	}
}