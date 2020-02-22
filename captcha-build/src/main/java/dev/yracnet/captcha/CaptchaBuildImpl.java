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
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Willyams Yujra
 */
public class CaptchaBuildImpl implements CaptchaBuild {

    private static final Logger LOGGER = Logger.getLogger(CaptchaBuildImpl.class.getName());

    private final CaptchaConfig config = new CaptchaConfigImpl();

    protected CaptchaBuildImpl() {
    }

    @Override
    public CaptchaConfig getConfig() {
        return config;
    }

    @Override
    public String createCodeRandom(int size) {
        return createCodeRandom(size, true);
    }

    @Override
    public String createCodeRandom(int size, boolean upper) {
        String text = Long.toHexString(new Random().nextLong());
        text = upper ? text.toUpperCase() : text;
        return (text.length() > size) ? text.substring(0, size) : text;
    }

    @Override
    public BufferedImage createSimpleText(String text) {
        return createSimpleText(text, 1, 80);
    }

    @Override
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

    @Override
    public BufferedImage createSimpleMask(BufferedImage src) {
        return createSimpleMask(src.getWidth(), src.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    }

    @Override
    public BufferedImage createSimpleMask(int width, int height) {
        return createSimpleMask(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    }

    @Override
    public BufferedImage createSimpleMask(int width, int height, int type) {
        BufferedImage src = config.getMaskRandom();
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

    @Override
    public BufferedImage createEffectText(String text) {
        BufferedImage src = createSimpleText(text);
        return createEffectText(src);
    }

    @Override
    public BufferedImage createEffectText(String text, int fontStyle, int fontSize) {
        BufferedImage src = createSimpleText(text, fontStyle, fontSize);
        return createEffectText(src);
    }

    @Override
    public BufferedImage createEffectText(BufferedImage src) {
        BufferedImage dest = cloneImage(src);
        int max = config.getTextEffectIterations();
        for (int i = 0; i < max; i++) {
            CaptchaEffect effect = config.getTextEffectRandom();
            dest = effect.applyText(dest, config);
        }
        return dest;
    }

    @Override
    public BufferedImage createEffectMask(BufferedImage src) {
        return createEffectMask(src.getWidth(), src.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    }

    @Override
    public BufferedImage createEffectMask(int width, int height) {
        return createEffectMask(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    }

    @Override
    public BufferedImage createEffectMask(int width, int height, int type) {
        BufferedImage src = createSimpleMask(width, height, type);
        int max = config.getMaskEffectIterations();
        for (int i = 0; i < max; i++) {
            CaptchaEffect effect = config.getMaskEffectRandom();
            src = effect.applyMask(src, config);
        }
        return src;
    }

    @Override
    public BufferedImage createCaptcha(String code) {
        BufferedImage text = createEffectText(code);
        return createCaptcha(text);
    }

    @Override
    public BufferedImage createCaptcha(String code, int fontStyle, int fontSize) {
        BufferedImage text = createEffectText(code, fontStyle, fontSize);
        return createCaptcha(text);
    }

    @Override
    public BufferedImage createCaptcha(BufferedImage text) {
        BufferedImage back = createEffectMask(text);
        return createCaptcha(text, back);
    }

    @Override
    public BufferedImage createCaptcha(BufferedImage text, BufferedImage back) {
        CaptchaEffect effect = config.getMergeEffectRandom();
        return effect.applyMerge(text, back, config);
    }

    @Override
    public byte[] createCaptchaAsByteArray(String code) {
        BufferedImage src = createCaptcha(code);
        return asByteArray(src, "png");
    }

    @Override
    public byte[] createCaptchaAsByteArray(String code, int fontStyle, int fontSize) {
        BufferedImage src = createCaptcha(code, fontStyle, fontSize);
        return asByteArray(src, "png");
    }

    @Override
    public byte[] createCaptchaAsByteArrayResize(String code, int width, int height) {
        BufferedImage src = createCaptcha(code);
        src = resize(src, width, height);
        return asByteArray(src, "png");
    }

    @Override
    public byte[] createCaptchaAsByteArrayResize(String code, int fontStyle, int fontSize, int width, int height) {
        BufferedImage src = createCaptcha(code, fontStyle, fontSize);
        src = resize(src, width, height);
        return asByteArray(src, "png");
    }

    @Override
    public byte[] asByteArray(BufferedImage src, String ext) {
        byte[] result = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(src, ext, baos);
            baos.flush();
            result = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error write image as byte array", e);
        }
        return result;
    }

    @Override
    public BufferedImage resize(BufferedImage src, int width, int height) {
        Image tmp = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }

}
