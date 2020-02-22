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

import com.jhlabs.image.HalftoneFilter;
import dev.yracnet.captcha.CaptchaConfig;
import static dev.yracnet.captcha.CaptchaHelp.cloneImage;
import java.awt.image.BufferedImage;

/**
 *
 * @author yracnet
 */
public class HalftoneEffect extends NoneEffect {

    public BufferedImage applyMerge(BufferedImage src, BufferedImage mask, CaptchaConfig config) {
        BufferedImage clon = cloneImage(mask);
        HalftoneFilter filter = new HalftoneFilter();
        filter.setMask(src);
        filter.setInvert(true);
        filter.setSoftness(0.5f);
        //filter.setMonochrome(true);
        filter.filter(clon, clon);
        //mask.get
        return clon;
    }

}
