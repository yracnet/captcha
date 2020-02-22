/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha;

import dev.yracnet.captcha.CaptchaBuild;
import dev.yracnet.captcha.effect.*;
import static dev.yracnet.captcha.CaptchaHelp.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Willyams Yujra
 */
public class CaptchaRun extends JPanel {

    private final CaptchaBuild build;

    public CaptchaRun() {
        build = CaptchaBuild.createInstance();
        CaptchaConfig config = build.getConfig();
        config.addTextFont(urlFromName("/default/font1.ttf"));
        config.addTextFont(urlFromName("/default/font2.ttf"));
        config.addTextFont(urlFromName("/default/font3.ttf"));
        config.addTextColor("#30106c");
        config.addTextColor("#0093d6");
        config.addTextColor("#feda00");
        config.addTextColor("#e72849");
        config.addTextColor("#5094ff");
        config.addTextColor("#dfdfe3");
        config.addTextColor("#eaf871");
        config.addTextColor("#fffcf7");
        config.addTextColor("#11476d");
        config.addMaskImage(urlFromName("/default/back1.jpg"));
        config.addMaskEffect(CaptchaConfig.NONE_EFFECT);
//        config.addMaskImage(urlFromName("/default/back2.jpg"));
//        config.addMaskImage(urlFromName("/default/back3.jpg"));
//        config.addTextEffect(new TextEmbossEffect());
//        config.addTextEffect(new TextBoxBlurEffect());
//        config.addTextEffect(new TextRippleEffect());
//        config.addTextEffect(new TextTwirlEffect());
//        config.addTextEffect(new TextConvolveEffect());
//        config.addTextEffect(new TextCrystallizeEffect());
//        config.addTextEffect(CaptchaConfig.NONE_EFFECT);
//        config.addMaskEffect(new BackgroundBoxBlurEffect());
//        config.addMaskEffect(new BackgroundCrystallizeEffect());
//        config.addMaskEffect(new BackgroundTwirlEffect());
//        config.addMergeEffect(CaptchaConfig.MERGE_EFFECT);
//        config.addMergeEffect(new HalftoneEffect());
        config.addMergeEffect(new DiffusionEffect());

    }

    @Override
    public void paint(Graphics g) {
        String code = build.createCodeRandom(5);
        BufferedImage text = build.createEffectText(code, 1, 60);
        int h = text.getHeight();
        int y = 0;
        g.drawImage(text, 0, y, this);
        y = y + h;
        BufferedImage back = build.createEffectMask(text);
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
