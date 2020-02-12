/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import static dev.yracnet.captcha.CaptchaHelp.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wyujra
 */
public class CaptchaBuild {

    private static final Logger LOGGER = Logger.getLogger(CaptchaBuild.class.getName());

    private final CaptchaConfig config = new CaptchaConfig();

    public CaptchaConfig getConfig() {
        return config;
    }

    public String createCodeRandom(int size) {
        return createCodeRandom(size, true);
    }

    public String createCodeRandom(int size, boolean upper) {
        String text = Long.toHexString(new Random().nextLong());
        text = upper ? text.toUpperCase() : text;
        return (text.length() > size) ? text.substring(0, size) : text;
    }

    public BufferedImage createSimpleText(String text) {
        return createSimpleText(text, 1, 80);
    }

    public BufferedImage createSimpleText(String text, int fontStyle, int fontSize) {
        Font font = config.getTextFontRandom(fontStyle, fontSize);
        int width = 2000;
        int height = 500;
        BufferedImage src = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = src.getGraphics();
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int space = config.getSpace();
        int x0 = space;
        int y0 = fm.getAscent() + space;
        for (char c : text.toCharArray()) {
            Color color = config.getTextColorRandom();
            g.setColor(color);
            String it = c + "";
            g.drawString(it, x0, y0);
            x0 = x0 + fm.stringWidth(it) + space;
        }
        width = x0;
        height = y0 + fm.getDescent() + space;
        src = src.getSubimage(0, 0, width, height);
        return src;
    }

    public BufferedImage createSimpleBackground(BufferedImage src) {
        return createSimpleBackground(src.getWidth(), src.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    }

    public BufferedImage createSimpleBackground(int width, int height) {
        return createSimpleBackground(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    }

    public BufferedImage createSimpleBackground(int width, int height, int type) {
        BufferedImage src = config.getBackgroundImageRandom();
        int x = getIntRango(0, src.getWidth() - width - 1);
        int y = getIntRango(0, src.getHeight() - height - 1);
        try {
            src = src.getSubimage(x, y, width, height);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error get background", e);
            BufferedImage error = new BufferedImage(width, height, type);
            Graphics g = error.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            g.drawImage(src, 0, 0, null);
            src = error;
        }
        return src;
    }

    public BufferedImage createEffectText(String text) {
        BufferedImage src = createSimpleText(text);
        return createEffectText(src);
    }

    public BufferedImage createEffectText(String text, int fontStyle, int fontSize) {
        BufferedImage src = createSimpleText(text, fontStyle, fontSize);
        return createEffectText(src);
    }

    public BufferedImage createEffectText(BufferedImage src) {
        BufferedImage dest = cloneImage(src);
        int max = config.getTextEffectIterations();
        for (int i = 0; i < max; i++) {
            CaptchaEffect effect = config.getTextEffectRandom();
            dest = effect.apply(dest);
        }
        return dest;
    }

    public BufferedImage createEffectBackground(BufferedImage src) {
        return createEffectBackground(src.getWidth(), src.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    }

    public BufferedImage createEffectBackground(int width, int height) {
        return createEffectBackground(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    }

    public BufferedImage createEffectBackground(int width, int height, int type) {
        BufferedImage src = createSimpleBackground(width, height, type);
        int max = config.getBackgoundEffectIterations();
        for (int i = 0; i < max; i++) {
            CaptchaEffect effect = config.getBackgoundEffectRandom();
            src = effect.apply(src);
        }
        return src;
    }

    public BufferedImage createCaptcha(String code) {
        BufferedImage text = createEffectText(code);
        return createCaptcha(text);
    }

    public BufferedImage createCaptcha(String code, int fontStyle, int fontSize) {
        BufferedImage text = createEffectText(code, fontStyle, fontSize);
        return createCaptcha(text);
    }

    public BufferedImage createCaptcha(BufferedImage text) {
        BufferedImage back = createEffectBackground(text);
        return createCaptcha(text, back);
    }

    public BufferedImage createCaptcha(BufferedImage text, BufferedImage back) {
        back.getGraphics().drawImage(text, 0, 0, null);
        return back;
    }

}
