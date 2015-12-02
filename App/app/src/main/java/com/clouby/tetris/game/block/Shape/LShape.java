package com.clouby.tetris.game.block.Shape;

import android.graphics.Color;

import com.clouby.tetris.R;

//"L" Shape
public class LShape extends Shape {
    public LShape() {
        //four rotations of "L" shape
        super(new int[]{0x6220, 0x1700, 0x2230, 0x0740});
        setColor(Color.DKGRAY);
    }
}
