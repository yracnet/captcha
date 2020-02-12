/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import static dev.yracnet.captcha.CaptchaHelp.*;
import dev.yracnet.captcha.effect.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author wyujra
 */
public class CaptchaRun extends JPanel {

    private final CaptchaBuild build;

    public CaptchaRun() {
        build = new CaptchaBuild();
        CaptchaConfig config = build.getConfig();
        config.addTextColor("#0093d6");
        config.addTextColor("#feda00");
        config.addTextColor("#eaf871");
        config.addTextColor("#fffcf7");
        config.addTextColor("#11476d");
        config.addBackgroundImage(urlFromName("/custom/back1.jpg"));
        config.addBackgroundImage(urlFromName("/custom/back2.jpg"));
        config.addBackgroundImage(urlFromName("/custom/back3.jpg"));
        config.addTextEffect(new TextBoxBlurEffect());
        config.addTextEffect(new TextConvolveEffect());
        config.addTextEffect(CaptchaConfig.NONE_EFFECT);
        config.addBackgroundEffect(new BackgroundBoxBlurEffect());
        config.addBackgroundEffect(new BackgroundTwirlEffect());
        config.addBackgroundEffect(CaptchaConfig.NONE_EFFECT);
    }

    @Override
    public void paint(Graphics g) {
        String code = build.createCodeRandom(5);
        BufferedImage text = build.createEffectText(code, 1, 60);
        int h = text.getHeight();
        int y = 0;
        g.drawImage(text, 0, y, this);
        y = y + h;
        BufferedImage back = build.createEffectBackground(text);
        g.drawImage(back, 0, y, this);
        y = y + h;
        BufferedImage catpcha = build.createCaptcha(text, back);
        g.drawImage(catpcha, 0, y, this);
        y = y + h;
        catpcha = build.createCaptcha(code, 1, 90);
        g.drawImage(catpcha, 0, y, this);
        y = y + h;

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Run Captcha");
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        Container c = frame.getContentPane();
        c.add(new CaptchaRun());
        c.repaint();
    }

}
