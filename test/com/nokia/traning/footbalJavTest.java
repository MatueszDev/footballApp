package com.nokia.traning;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class footbalJavTest {

    @Test
    public void ifOneYellow_thenOnePoint(){
        int points = FairPlayPointsCalculatr.calculatePoints("Kane,yellow");
        Assert.assertEquals(1,points);
    }

    @Test
    public void ifSecondYellow_thenThreePoints(){
        int points = FairPlayPointsCalculatr.calculatePoints("Kane,yellow,Kane,yellow");
        Assert.assertEquals(3,points);
    }

    @Test
    public void ifStraightRed_tenFourPoints(){
        int points = FairPlayPointsCalculatr.calculatePoints("Kane,"+FairPlayPointsCalculatr.RED);
        Assert.assertEquals(4, points);
    }

    @Test
    public void ifYellow_ThenRed_ThenFivePoints(){
        int points = FairPlayPointsCalculatr.calculatePoints("Kane,yellow,Kane,"+FairPlayPointsCalculatr.RED);
        Assert.assertEquals(5, points);
    }

    @Test
    public void test(){
        int points = FairPlayPointsCalculatr.calculatePoints("Igor,yellow,Igor,yellow,Yury,yellow");
        points += FairPlayPointsCalculatr.calculatePoints("Fydor,yellow");
        points += FairPlayPointsCalculatr.calculatePoints("Golowin,yellow");
        Assert.assertEquals(6, points);
    }
}
