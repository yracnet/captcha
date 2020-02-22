/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import dev.yracnet.captcha.effect.NoneEffect;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 *
 * @author Willyams Yujra
 */
public interface CaptchaConfig {

    public static final CaptchaEffect NONE_EFFECT = new NoneEffect();

    public void addTextColor(String hex);

    public void addTextFont(URL url);

    public void addTextFont(URL url, int fontFormat);

    public void addMaskImage(URL url);

    public void addCaptchaEffect(CaptchaEffect effect);

    public void addCaptchaEffect(CaptchaEffect effect, boolean isMask, boolean isText, boolean isMerge);

    public void addTextEffect(CaptchaEffect effect);

    public void addMaskEffect(CaptchaEffect effect);

    public void addMergeEffect(CaptchaEffect effect);

    public Font getTextFontRandom(int fontStyle, int fontSize);

    public Color getTextColorRandom();

    public BufferedImage getMaskRandom();

    public CaptchaEffect getTextEffectRandom();

    public CaptchaEffect getMaskEffectRandom();

    public CaptchaEffect getMergeEffectRandom();

    public int getSpace();

    public void setSpace(int value);

    public int getTextEffectIterations();

    public void setTextEffectIterations(int value);

    public int getMaskEffectIterations();

    public void setMaskEffectIterations(int value);

}
