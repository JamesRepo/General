import java.math.BigDecimal;
import java.math.RoundingMode;
/*
 * ==== Revenue ====
 * Class to calculate revenue when given margin and cost
 * 
 */
public class Revenue implements RevenueCalculator {

	public Revenue() {}
	
	/* Method implemented from RevenueCalculator */
	@Override
	public BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {
		/* Prints an error message if:
		 * - Margin is over 100% or below 0%
		 * - Cost of goods is less than or equal to 0
		 */
		if (marginPercentage.compareTo(BigDecimal.ONE) == 1 || marginPercentage.compareTo(BigDecimal.ZERO) == -1 || costOfGoods.compareTo(BigDecimal.ZERO) == -1 || costOfGoods.compareTo(BigDecimal.ZERO) == 0) {
			System.out.println("ERROR");
			return null;
		}
		/* Calculation below.
		 * 
		 * Revenue = Cost of Goods / ( 100% - Margin Percentage )
		 * 
		 * Scale is set to 2 as its money being represented so 2 decimal points
		 * Rounds everything >5 up
		 * 
		 */
		BigDecimal revenue = costOfGoods.divide(new BigDecimal("1.0").subtract(marginPercentage), 2, RoundingMode.HALF_UP);
		// Return
		return revenue;
	}
}