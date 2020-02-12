/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.RippleFilter;
import dev.yracnet.captcha.CaptchaEffect;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;

/**
 *
 * @author Willyams Yujra
 */
public class TextRippleEffect implements CaptchaEffect {

    @Override
    public BufferedImage apply(BufferedImage src) {
        RippleFilter filter = new RippleFilter();
        filter.setXAmplitude(getFloatRango(6f, 18f));
        filter.setYAmplitude(getFloatRango(2f, 10f));
        filter.setXWavelength(getFloatRango(10f, 20f));
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }

}
