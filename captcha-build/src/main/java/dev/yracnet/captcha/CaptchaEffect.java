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
public interface CaptchaEffect {

    public BufferedImage apply(BufferedImage src);

}
