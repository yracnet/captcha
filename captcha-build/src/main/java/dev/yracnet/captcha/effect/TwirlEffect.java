/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.TwirlFilter;
import dev.yracnet.captcha.CaptchaConfig;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;
import dev.yracnet.captcha.CaptchaEffect;

/**
 *
 * @author Willyams Yujra
 */
public class TwirlEffect extends NoneEffect implements CaptchaEffect {

    @Override
    public BufferedImage applyMask(BufferedImage src, CaptchaConfig config) {
        TwirlFilter filter = new TwirlFilter();
        filter.setAngle(getFloatRango(-1.2f, 1.2f));
        filter.setRadius(getFloatRango(100f, 500f));
        filter.setCentreY(getFloatRango(0.2f, 0.8f));
        filter.setCentreX(getFloatRango(0.2f, 0.8f));
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }

    @Override
    public BufferedImage applyText(BufferedImage src, CaptchaConfig config) {
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
