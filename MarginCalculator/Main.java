import java.math.BigDecimal;

public class Main {
	/* Main Method */
	public static void main(String[] args) {
		// Create Revenue object
		Revenue revenueCalc = new Revenue();
		/* Hard code the values here
		 * ( marginPercentage, costOfGoods )
		 * Percentage must be represented as a decimal
		 */
		BigDecimal revenue = revenueCalc.calculateRevenue(new BigDecimal("0.0"), new BigDecimal("800"));
		// Prints answer to the console
		System.out.print(revenue);
	}
}