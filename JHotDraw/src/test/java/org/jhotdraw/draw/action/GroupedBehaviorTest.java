/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.action.GivenFiguresToGroup;
import org.jhotdraw.draw.action.ThenFiguresGrouped;
import org.jhotdraw.draw.action.WhenGrouping;
import org.junit.Test;

/**
 *
 * @author Zed V2
 */
public class GroupedBehaviorTest extends ScenarioTest<GivenDrawingView, WhenAUserCanCreateATextObejct, ThenUserCanSeeTheText> {
    
    @Test
    public void GroupedBehaviorTest() {
        given().Drawing_View();
        when().AUserCreatesATextFigure();
        then().TheUserCanEditTheText();
    }
    
}
