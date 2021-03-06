/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.cdcRole;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.plot.DefaultDrawingSupplier;

/**
 *
 * @author Dev
 */
public class ChartDrawingSupplier extends DefaultDrawingSupplier  {

    public Paint[] paintSequence;
    public int paintIndex;
    public int fillPaintIndex;

    {
        paintSequence =  new Paint[] {
                new Color(227, 26, 28),
                new Color(000,102, 204),
                new Color(102,051,153),
                new Color(102,51,0),
                new Color(156,136,48),
                new Color(153,204,102),
                new Color(153,51,51),
                new Color(102,51,0),
                new Color(204,153,51),
                new Color(0,51,0),
        };
    }

    @Override
    public Paint getNextPaint() {
        Paint result
        = paintSequence[paintIndex % paintSequence.length];
        paintIndex++;
        return result;
    }


    @Override
    public Paint getNextFillPaint() {
        Paint result
        = paintSequence[fillPaintIndex % paintSequence.length];
        fillPaintIndex++;
        return result;
    }   
}
