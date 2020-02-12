/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.BoxBlurFilter;
import dev.yracnet.captcha.CaptchaEffect;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;
/**
 *
 * @author Willyams Yujra
 */
public class TextBoxBlurEffect implements CaptchaEffect{

    @Override
    public BufferedImage apply(BufferedImage src) {
            BoxBlurFilter filter = new BoxBlurFilter();
            filter.setHRadius(getFloatRango(0f, 2f));
            filter.setVRadius(getFloatRango(0f, 2f));
            filter.setIterations(getIntRango(2, 10));
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }
    
}
