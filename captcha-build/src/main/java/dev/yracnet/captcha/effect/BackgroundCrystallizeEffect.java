/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.CrystallizeFilter;
import dev.yracnet.captcha.CaptchaEffect;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;

/**
 *
 * @author wyujra
 */
public class BackgroundCrystallizeEffect implements CaptchaEffect {

    @Override
    public BufferedImage apply(BufferedImage src) {
        CrystallizeFilter filter = new CrystallizeFilter();
        filter.setScale(getFloatRango(1f, 50f));
        filter.setGridType(getIntRango(0, 4));
        filter.setFadeEdges(true);
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }

}
