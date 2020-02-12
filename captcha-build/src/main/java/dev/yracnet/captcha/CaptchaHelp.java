/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import dev.yracnet.captcha.effect.BackgroundBoxBlurEffect;
import dev.yracnet.captcha.effect.BackgroundCrystallizeEffect;
import dev.yracnet.captcha.effect.BackgroundTwirlEffect;
import dev.yracnet.captcha.effect.TextBoxBlurEffect;
import dev.yracnet.captcha.effect.TextConvolveEffect;
import dev.yracnet.captcha.effect.TextCrystallizeEffect;
import dev.yracnet.captcha.effect.TextRippleEffect;
import dev.yracnet.captcha.effect.TextTwirlEffect;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 *
 * @author wyujra
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
        CaptchaBuild build = new CaptchaBuild();
        CaptchaConfig config = build.getConfig();
        config.addTextFont(urlFromName("/default/font1.ttf"));
        config.addTextFont(urlFromName("/default/font2.ttf"));
        config.addTextFont(urlFromName("/default/font3.ttf"));
        config.addTextColor("#0093d6");
        config.addTextColor("#feda00");
        config.addTextColor("#e72849");
        config.addTextColor("#5094ff");
        config.addTextColor("#ffffff");
        config.addTextColor("#eaf871");
        config.addTextColor("#fffcf7");
        config.addTextColor("#11476d");
        config.addBackgroundImage(urlFromName("/default/back1.jpg"));
        config.addBackgroundImage(urlFromName("/default/back2.jpg"));
        config.addBackgroundImage(urlFromName("/default/back3.jpg"));
        config.addTextEffect(new TextBoxBlurEffect());
        config.addTextEffect(new TextRippleEffect());
        config.addTextEffect(new TextTwirlEffect());
        config.addTextEffect(new TextConvolveEffect());
        config.addTextEffect(new TextCrystallizeEffect());
        config.addTextEffect(CaptchaConfig.NONE_EFFECT);
        config.addBackgroundEffect(new BackgroundBoxBlurEffect());
        config.addBackgroundEffect(new BackgroundCrystallizeEffect());
        config.addBackgroundEffect(new BackgroundTwirlEffect());
        config.addBackgroundEffect(CaptchaConfig.NONE_EFFECT);
        return build;
    }

}
