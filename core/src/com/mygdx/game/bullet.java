package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

public class bullet extends Rectangle {


    static final double Xspeed = 20, Yspeed = 20;

    // bullet parameters
    float x;
    float y;
    int width, height;
    Rectangle hitBox;
    Texture bullet;
    Texture outputTexture;
    ObjectAnimation bullet_animation;


    public bullet (float x, float y){

        this.x = x;
        this.y = y;

        width = 100;
        height = 100;

        hitBox = new Rectangle(x, y, width, height);

        bullet_animation = new ObjectAnimation();
        bullet_animation.loadAnimation("bullet_",4);
        bullet = new Texture(Gdx.files.internal("bullet_1"));

        outputTexture = bullet;
    }
    public Texture render(float delta, Array<MapObject> Walls){

        // updates bullets position;
        x += Xspeed;
        y += Yspeed;

        hitBox.x = x;
        hitBox.y = y;

        hitBox.x += Xspeed;
        hitBox.y += Yspeed;

        for (MapObject i_wall : Walls) {

            if (hitBox.overlaps(i_wall.hitBox)) {
                bullet_animation.dispose();
                bullet.dispose();
            }
        }


        outputTexture = bullet_animation.getFrame(delta);




        return outputTexture;
    }


}
