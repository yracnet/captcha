/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.ConvolveFilter;
import dev.yracnet.captcha.CaptchaEffect;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;
import java.awt.image.Kernel;

/**
 *
 * @author Willyams Yujra
 */
public class TextConvolveEffect implements CaptchaEffect {

    @Override
    public BufferedImage apply(BufferedImage src) {
        ConvolveFilter filter = new ConvolveFilter();
        float matrix[] = new float[]{
            getFloatRango(0.1f, 0.3f), 0, 0, 0, getFloatRango(0.1f, 0.3f),
            0,0,0,0,0,
            0,0,getFloatRango(0.3f, 0.5f),0,0,
            0,0,0,0,0,
            getFloatRango(0.1f, 0.3f), 0, 0, 0, getFloatRango(0.1f, 0.3f)
        };
        Kernel kernel = new Kernel(5, 5, matrix);
        filter.setKernel(kernel);
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }

}
