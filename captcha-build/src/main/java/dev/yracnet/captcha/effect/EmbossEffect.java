/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.*;
import dev.yracnet.captcha.CaptchaConfig;
import java.awt.image.BufferedImage;
import static dev.yracnet.captcha.CaptchaHelp.*;
import dev.yracnet.captcha.CaptchaEffect;

/**
 *
 * @author Willyams Yujra
 */
public class EmbossEffect extends NoneEffect  implements CaptchaEffect {

    @Override
    public BufferedImage applyText(BufferedImage src, CaptchaConfig config) {
        BufferedImage clon = cloneImage(src);
        //LightFilter filter = new LightFilter();
        //ShapeFilter filter = new ShapeFilter();
        //ChromeFilter filter = new ChromeFilter();
        //StampFilter filter = new StampFilter();
        //filter.setRadius(-20f);
        //filter.setSoftness(20f);
        //filter.setThreshold(20f);
        //filter.setUseAlpha(true);
        //TextureFilter filter = new TextureFilter();
        //filter.set
        //filter.setElevation(getFloatRango(0.5f, 1.5f));
        //filter.setEmboss(true);
        //filter.setAzimuth(0.5f);

        //BumpFilter filter = new BumpFilter();
        //filter.setEdgeAction(1);
        //filter.setUseAlpha(true);
        //filter.setPremultiplyAlpha(true);
        //GradientWipeFilter filter = new GradientWipeFilter();
        //OpacityFilter filter = new OpacityFilter();
        //filter.setOpacity(160);
         HalftoneFilter filter = new  HalftoneFilter();
         
        //PointillizeFilter filter = new PointillizeFilter ();
        //filter.setFadeEdges(true);
        //filter.setScale(5f);
        //filter.setInvert(false);
        //filter.setMask(config.getBackgroundImageRandom());
        //filter.setSoftness(0.1f);
        //DoGFilter filter = new DoGFilter();
        //EdgeFilter  filter = new EdgeFilter ();
        //MotionBlurFilter  filter = new MotionBlurFilter ();
        //filter.setWrapEdges(false);
        //filter.setZoom(0.19f);
        //filter.setPremultiplyAlpha(true);
        //filter.setRotation(getFloatRango(-0.11f, 0.11f));
        //LensBlurFilter   filter = new LensBlurFilter  ();
        //filter.setRadius(2.2f);
        //ScratchFilter filter = new ScratchFilter();
        //filter.setWidth(2.4f);
        //filter.setColor(config.getTextColorRandom().getRGB());
        //filter.setDensity(getFloatRango(0.015f, 0.08f));

        filter.filter(clon, clon);

        return clon;
    }

}
