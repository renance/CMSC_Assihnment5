public class HolidayBonus {

    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    public static double[] calculateHolidayBonus(double[][] salesData) {
        double[] bonuses = new double[salesData.length]; // Array to store holiday bonuses for each store

        for (int i = 0; i < salesData.length; i++) {
            double highestSales = TwoDimRaggedArrayUtility.getHighestInRow(salesData, i);
            double lowestSales = TwoDimRaggedArrayUtility.getHighestInRow(salesData, i);
            double totalSales = TwoDimRaggedArrayUtility.getRowTotal(salesData, i);

            if (totalSales <= 0) {
                // No bonus if no sales or negative sales
                bonuses[i] = 0.0;
            } else if (highestSales == lowestSales) {
                // Only one store sold in this category, so it gets the highest bonus
                bonuses[i] = HIGHEST_BONUS;
            } else {
                // Calculate bonus based on highest, lowest, and total sales
                bonuses[i] = (highestSales == totalSales) ? HIGHEST_BONUS :
                        (lowestSales == totalSales) ? LOWEST_BONUS : OTHER_BONUS;
            }
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] salesData) {
        double totalBonus = 0.0;

        for (double[] storeSales : salesData) {
            totalBonus += calculateHolidayBonus(storeSales);
        }

        return totalBonus;
    }

	private static double calculateHolidayBonus(double[] storeSales) {
		// TODO Auto-generated method stub
		return 0;
	}

  
}
