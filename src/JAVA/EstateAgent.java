package JAVA;

public class EstateAgent
{
    // Calculate total sales for a specific agent
    public double calculateTotalSales(double[][] propertyPrices, int agentIndex)
    {
        double totalSales = 0.0;
        
        for (int j = 0; j < propertyPrices[agentIndex].length; j++)
        {
            totalSales += propertyPrices[agentIndex][j];
        }
        
        return totalSales;
    }

    // Calculate commission based on total sales
    public double calculateCommission(double totalSales, double commissionRate)
    {
        return totalSales * (commissionRate / 100);
    }

    // Determine the top agent based on total sales
    public String determineTopAgent(double[][] propertyPrices, String[] agents)
    {
        double maxSales = 0;
        String topAgent = "";
        
        for (int i = 0; i < propertyPrices.length; i++)
        {
            double totalSales = calculateTotalSales(propertyPrices, i);
            if (totalSales > maxSales)
            {
                maxSales = totalSales;
                topAgent = agents[i];
            }
        }
        
        return topAgent;
    }
}
