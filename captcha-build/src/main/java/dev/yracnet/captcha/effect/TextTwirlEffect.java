/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.TwirlFilter;
import dev.yracnet.captcha.CaptchaEffect;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;

/**
 *
 * @author Willyams Yujra
 */
public class TextTwirlEffect implements CaptchaEffect {

    @Override
    public BufferedImage apply(BufferedImage src) {
        BufferedImage clon = cloneImage(src);
        int size = src.getWidth() / src.getHeight();
        for (float i = 1; i <= size; i++) {
            TwirlFilter filter = new TwirlFilter();
            filter.setAngle(getFloatRango(-0.5f, 0.5f));
            //f0.setCentreY((i / size));
            filter.setCentreX((i / size));
            filter.filter(clon, clon);
        }
        
        return clon;
    }

}
