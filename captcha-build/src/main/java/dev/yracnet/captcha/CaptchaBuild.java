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

    public BufferedImage createSimpleMask(BufferedImage src);

    public BufferedImage createSimpleMask(int width, int height);

    public BufferedImage createSimpleMask(int width, int height, int type);

    public BufferedImage createEffectText(String text);

    public BufferedImage createEffectText(String text, int fontStyle, int fontSize);

    public BufferedImage createEffectText(BufferedImage src);

    public BufferedImage createEffectMask(BufferedImage src);

    public BufferedImage createEffectMask(int width, int height);

    public BufferedImage createEffectMask(int width, int height, int type);

    public BufferedImage createCaptcha(String code);

    public BufferedImage createCaptcha(String code, int fontStyle, int fontSize);

    public BufferedImage createCaptcha(BufferedImage text);

    public BufferedImage createCaptcha(BufferedImage text, BufferedImage back);

    public byte[] createCaptchaAsByteArray(String code);

    public byte[] createCaptchaAsByteArray(String code, int fontStyle, int fontSize);

    public byte[] createCaptchaAsByteArrayResize(String code, int width, int height);

    public byte[] createCaptchaAsByteArrayResize(String code, int fontStyle, int fontSize, int width, int height);

    public byte[] asByteArray(BufferedImage src, String ext);
    
    public BufferedImage resize(BufferedImage img, int width, int height);

}
