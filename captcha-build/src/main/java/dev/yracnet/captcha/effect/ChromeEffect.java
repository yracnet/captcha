/*
 * Copyright 2020 yracnet.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.yracnet.captcha.effect;

import com.jhlabs.image.ChromeFilter;
import dev.yracnet.captcha.CaptchaConfig;
import java.awt.image.BufferedImage;

/**
 *
 * @author yracnet
 */
public class ChromeEffect extends NoneEffect {

//    @Override
//    public BufferedImage applyText(BufferedImage src, CaptchaConfig config) {
//        BufferedImage clon = super.applyText(src, config);
//        ChromeFilter filter = new ChromeFilter();
//        filter.setAmount(0.055f);
//        filter.setExposure(2.6f);
//        filter.setBumpSoftness(2f);
//        filter.filter(clon, clon);
//        return clon;
//    }

    @Override
    public BufferedImage applyMask(BufferedImage src, CaptchaConfig config) {
        BufferedImage clon = super.applyMask(src, config);
        ChromeFilter filter = new ChromeFilter();
        filter.setAmount(0.055f);
        filter.setExposure(2.6f);
        filter.filter(clon, clon);
        return clon;
    }

    @Override
    public BufferedImage applyMerge(BufferedImage src, BufferedImage mask, CaptchaConfig config) {
        BufferedImage clon = super.applyMerge(src, mask, config);
        ChromeFilter filter = new ChromeFilter();
        filter.setAmount(0.1f);
        filter.setExposure(2.3f);
        filter.filter(clon, clon);
        return clon;
    }
}
