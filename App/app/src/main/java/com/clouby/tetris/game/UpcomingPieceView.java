package com.clouby.tetris.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.clouby.tetris.game.block.Shape;

public class UpcomingPieceView extends SurfaceView implements SurfaceHolder.Callback, BoardViewListener {
    private UpcomingPiecePanel upcomingPiecePanel;

    public UpcomingPieceView(Context context) {
        super(context);
        init();

    }

    public UpcomingPieceView(Context context, AttributeSet attr) {
        super(context, attr);
        init();

    }


    private void init() {
        //add the callback to the surfaceHolder to intercept events
        getHolder().addCallback(this);
        //make gamePanel focusable so it can handle events
        setFocusable(true);

        this.setZOrderOnTop(true);    // necessary
        SurfaceHolder sfhTrackHolder = this.getHolder();
        sfhTrackHolder.setFormat(PixelFormat.TRANSPARENT);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        upcomingPiecePanel = new UpcomingPiecePanel(16, 4);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        upcomingPiecePanel.draw(canvas, true);
    }

    @Override
    public void playEnd(BoardPanel boardPanel){
        boardPanel.makeActiveShape(upcomingPiecePanel.getNextPiece());
    }
    public void gameOver(int score){

    }

    public Shape getNextPiece() {
        return upcomingPiecePanel.getNextPiece();
    }

}

