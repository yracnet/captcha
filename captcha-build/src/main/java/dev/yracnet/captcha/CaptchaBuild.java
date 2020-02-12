/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import java.awt.image.BufferedImage;

/**
 *
 * @author Willyams Yujra
 */
public interface CaptchaBuild {
    public static CaptchaBuild createInstance(){
        return new CaptchaBuildImpl();
    }
    
    public CaptchaConfig getConfig();

    public String createCodeRandom(int size);

    public String createCodeRandom(int size, boolean upper);

    public BufferedImage createSimpleText(String text);

    public BufferedImage createSimpleText(String text, int fontStyle, int fontSize);

    public BufferedImage createSimpleBackground(BufferedImage src);

    public BufferedImage createSimpleBackground(int width, int height);

    public BufferedImage createSimpleBackground(int width, int height, int type);

    public BufferedImage createEffectText(String text);

    public BufferedImage createEffectText(String text, int fontStyle, int fontSize);

    public BufferedImage createEffectText(BufferedImage src);

    public BufferedImage createEffectBackground(BufferedImage src);

    public BufferedImage createEffectBackground(int width, int height);

    public BufferedImage createEffectBackground(int width, int height, int type);

    public BufferedImage createCaptcha(String code);

    public BufferedImage createCaptcha(String code, int fontStyle, int fontSize);

    public BufferedImage createCaptcha(BufferedImage text);

    public BufferedImage createCaptcha(BufferedImage text, BufferedImage back);

}
