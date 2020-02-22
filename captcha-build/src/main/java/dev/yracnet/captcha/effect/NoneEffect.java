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

import dev.yracnet.captcha.CaptchaConfig;
import java.awt.image.BufferedImage;
import dev.yracnet.captcha.CaptchaEffect;
import static dev.yracnet.captcha.CaptchaHelp.cloneImage;

/**
 *
 * @author yracnet
 */
public class NoneEffect implements CaptchaEffect {
    
    public BufferedImage applyText(BufferedImage src, CaptchaConfig config){
        return cloneImage(src);
    }
    
    public BufferedImage applyMask(BufferedImage mask, CaptchaConfig config){
        return cloneImage(mask);
    }
    
    public BufferedImage applyMerge(BufferedImage src, BufferedImage mask, CaptchaConfig config){
        mask = cloneImage(mask);
        mask.getGraphics().drawImage(src, 0, 0, null);
        return mask;
    }
}
