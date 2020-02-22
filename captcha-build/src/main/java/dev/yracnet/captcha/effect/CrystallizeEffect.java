/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.CrystallizeFilter;
import dev.yracnet.captcha.CaptchaConfig;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;
import dev.yracnet.captcha.CaptchaEffect;

/**
 *
 * @author Willyams Yujra
 */
public class CrystallizeEffect extends NoneEffect implements CaptchaEffect {

    @Override
    public BufferedImage applyMask(BufferedImage src, CaptchaConfig config) {
        CrystallizeFilter filter = new CrystallizeFilter();
        filter.setScale(getFloatRango(1f, 20f));
        filter.setGridType(getIntRango(0, 4));
        filter.setFadeEdges(true);
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }

    @Override
    public BufferedImage applyText(BufferedImage src, CaptchaConfig config) {
        CrystallizeFilter filter = new CrystallizeFilter();
        filter.setScale(getFloatRango(1f, 4f));
        filter.setGridType(getIntRango(1, 3));
        filter.setFadeEdges(true);
        BufferedImage clon = cloneImage(src);
        filter.filter(clon, clon);
        return clon;
    }

}
