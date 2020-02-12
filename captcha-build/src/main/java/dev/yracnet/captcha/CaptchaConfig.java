/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 *
 * @author Willyams Yujra
 */
public interface CaptchaConfig {

    public static final CaptchaEffect NONE_EFFECT = (BufferedImage src) -> src;

    public void addTextColor(String hex);

    public void addTextFont(URL url);

    public void addTextFont(URL url, int fontFormat);

    public void addTextEffect(CaptchaEffect effect);

    public void addBackgroundImage(URL url);

    public void addBackgroundEffect(CaptchaEffect effect);

    public Font getTextFontRandom(int fontStyle, int fontSize);

    public Color getTextColorRandom();

    public BufferedImage getBackgroundImageRandom();

    public CaptchaEffect getTextEffectRandom();

    public CaptchaEffect getBackgoundEffectRandom();

    public int getSpace();

    public int getTextEffectIterations();

    public int getBackgoundEffectIterations();

}
