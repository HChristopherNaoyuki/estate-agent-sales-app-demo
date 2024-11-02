package JAVA;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EstateAgentTest
{
    private EstateAgent estateAgent;

    @Before
    public void setUp()
    {
        estateAgent = new EstateAgent();
    }

    @Test
    public void testCalculateTotalSales()
    {
        // Sample property prices for 2 agents over 3 months
        double[][] propertyPrices = {
            {100000, 150000, 200000}, // Joe Bloggs
            {120000, 130000, 140000}  // Jane Doe
        };
        
        // Calculate total sales for each agent separately
        double totalSalesJoe = estateAgent.calculateTotalSales(propertyPrices, 0);
        double totalSalesJane = estateAgent.calculateTotalSales(propertyPrices, 1);
        
        // Assert totals
        assertEquals("Total sales for Joe Bloggs should be 450000", 450000.0, totalSalesJoe, 0.001);
        assertEquals("Total sales for Jane Doe should be 390000", 390000.0, totalSalesJane, 0.001);
    }

    @Test
    public void testCalculateCommission()
    {
        double totalSales = 500000; // Example total sales
        double commissionRate = 2;   // 2%

        double commission = estateAgent.calculateCommission(totalSales, commissionRate);
        assertEquals("Commission should be 10000", 10000.0, commission, 0.001);
    }

    @Test
    public void testDetermineTopAgent()
    {
        double[][] propertyPrices = {
            {100000, 150000, 200000}, // Joe Bloggs
            {120000, 130000, 140000}  // Jane Doe
        };
        String[] agents = { "Joe Bloggs", "Jane Doe" };

        String topAgent = estateAgent.determineTopAgent(propertyPrices, agents);
        assertEquals("Top agent should be Joe Bloggs", "Joe Bloggs", topAgent);
    }

    @Test
    public void testDetermineTopAgentWithEqualSales()
    {
        double[][] propertyPrices = {
            {100000, 150000, 200000}, // Joe Bloggs
            {100000, 150000, 200000}  // Jane Doe (equal sales)
        };
        String[] agents = { "Joe Bloggs", "Jane Doe" };

        String topAgent = estateAgent.determineTopAgent(propertyPrices, agents);
        assertEquals("Top agent should be Joe Bloggs (first in case of tie)", "Joe Bloggs", topAgent);
    }
}
