/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import dev.yracnet.captcha.effect.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 *
 * @author Willyams Yujra
 */
public class CaptchaHelp {

    public static BufferedImage cloneImage(BufferedImage src) {
        BufferedImage clon = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
        clon.getGraphics().drawImage(src, 0, 0, null);
        return clon;
    }

    public static float getFloatRango(float min, float max) {
        double r = Math.random();
        double diff = max - min;
        return (float) (min + diff * r);
    }

    public static int getIntRango(int min, int max) {
        double r = Math.random();
        double diff = max - min;
        return (int) (min + diff * r);
    }

    public static <T> T getRandom(T... values) {
        int size = values.length;
        double r = Math.random();
        int index = (int) (size * r);
        return values[index];
    }

    public static URL urlFromName(String name) {
        return CaptchaHelp.class.getResource(name);
    }

    public static CaptchaBuild createCaptchaDefault() {
        CaptchaBuild build = CaptchaBuild.createInstance();
        CaptchaConfig config = build.getConfig();
        config.addTextFont(urlFromName("/default/font1.ttf"));
//        config.addTextFont(urlFromName("/default/font2.ttf"));
//        config.addTextFont(urlFromName("/default/font3.ttf"));
        config.addTextColor("#30106c");
//        config.addTextColor("#0093d6");
//        config.addTextColor("#feda00");
//        config.addTextColor("#e72849");
//        config.addTextColor("#5094ff");
//        config.addTextColor("#dfdfe3");
//        config.addTextColor("#eaf871");
//        config.addTextColor("#fffcf7");
        config.addTextColor("#11476d");
        config.addMaskImage(urlFromName("/default/back1.jpg"));
//        config.addMaskImage(urlFromName("/default/back2.jpg"));
//        config.addMaskImage(urlFromName("/default/back3.jpg"));
//        config.addTextEffect(new TextEmbossEffect());
//        config.addTextEffect(new TextBoxBlurEffect());
//        config.addTextEffect(new TextRippleEffect());
//        config.addTextEffect(new TextTwirlEffect());
//        config.addTextEffect(new TextConvolveEffect());
//        config.addTextEffect(new TextCrystallizeEffect());
        config.addTextEffect(CaptchaConfig.NONE_EFFECT);
//        config.addMaskEffect(new BackgroundBoxBlurEffect());
//        config.addMaskEffect(new BackgroundCrystallizeEffect());
//        config.addMaskEffect(new BackgroundTwirlEffect());
        config.addMaskEffect(CaptchaConfig.NONE_EFFECT);
//        config.addMergeEffect(CaptchaConfig.MERGE_EFFECT);
        config.addMergeEffect(new HalftoneEffect());
        return build;
    }

}
