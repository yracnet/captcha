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
 * @author wyujra
 */
public class BackgroundTwirlEffect implements CaptchaEffect {

    @Override
    public BufferedImage apply(BufferedImage src) {
        TwirlFilter filter = new TwirlFilter();
        filter.setAngle(getFloatRango(-1.2f, 1.2f));
        filter.setRadius(getFloatRango(100f, 500f));
        filter.setCentreY(getFloatRango(0.2f, 0.8f));
        filter.setCentreX(getFloatRango(0.2f, 0.8f));
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }

}
