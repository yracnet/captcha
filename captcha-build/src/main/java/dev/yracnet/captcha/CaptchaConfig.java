/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import static dev.yracnet.captcha.CaptchaHelp.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Willyams Yujra
 */
@lombok.Getter
@lombok.Setter
public class CaptchaConfig {

    private static final Logger LOGGER = Logger.getLogger(CaptchaConfig.class.getName());
    public static final CaptchaEffect NONE_EFFECT = (BufferedImage src) -> src;

    private final List<BufferedImage> backgoundImages = new ArrayList<>();
    private final List<CaptchaEffect> backgoundEffects = new ArrayList<>();
    private final List<Color> textColors = new ArrayList<>();
    private final List<Font> textFonts = new ArrayList<>();
    private final List<CaptchaEffect> textEffects = new ArrayList<>();
    private int space = 10;
    private int textEffectIterations = 1;
    private int backgoundEffectIterations = 1;

    public void addTextColor(String hex) {
        textColors.add(Color.decode(hex));
    }

    public void addTextFont(URL url) {
        addTextFont(url, Font.PLAIN);
    }

    public void addTextFont(URL url, int fontFormat) {
        try {
            Font font = Font.createFont(fontFormat, url.openStream());
            textFonts.add(font);
        } catch (FontFormatException | IOException e) {
            LOGGER.log(Level.SEVERE, "Error load font", e);
        }
    }

    public void addTextEffect(CaptchaEffect effect) {
        textEffects.add(effect);
    }

    public void addBackgroundImage(URL url) {
        try {
            BufferedImage image = ImageIO.read(url);
            backgoundImages.add(image);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error load image", e);
        }
    }

    public void addBackgroundEffect(CaptchaEffect effect) {
        backgoundEffects.add(effect);
    }

    public Font getTextFontRandom(int fontStyle, int fontSize) {
        if (textFonts.isEmpty()) {
            return new Font("", fontStyle, fontSize);
        }
        int index = getIntRango(0, textFonts.size());
        Font font = textFonts.get(index);
        LOGGER.log(Level.FINE, "Font name: {0}", font.getFontName());
        return font.deriveFont(fontStyle, fontSize);
    }

    public Color getTextColorRandom() {
        if (textColors.isEmpty()) {
            return getRandom(Color.BLACK, Color.BLUE, Color.RED);
        }
        int index = getIntRango(0, textColors.size());
        return textColors.get(index);
    }

    public BufferedImage getBackgroundImageRandom() {
        if (backgoundImages.isEmpty()) {
            int width = 1000, height = 1000;
            BufferedImage src = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
            Graphics g = src.getGraphics();
            g.setColor(getRandom(Color.GRAY, Color.MAGENTA, Color.ORANGE));
            g.fillRect(0, 0, width, height);
            return src;
        }
        int index = getIntRango(0, backgoundImages.size());
        BufferedImage src = backgoundImages.get(index);
        return cloneImage(src);
    }

    public CaptchaEffect getTextEffectRandom() {
        if (textEffects.isEmpty()) {
            return NONE_EFFECT;
        }
        int index = getIntRango(0, textEffects.size());
        return textEffects.get(index);
    }

    public CaptchaEffect getBackgoundEffectRandom() {
        if (backgoundEffects.isEmpty()) {
            return NONE_EFFECT;
        }
        int index = getIntRango(0, backgoundEffects.size());
        return backgoundEffects.get(index);
    }

}
