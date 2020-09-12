# captcha

## Java Captcha Image Buffer Generator.

This lib generate a catcha image from random FONT and IMAGE Background, and apply different effect to the text and image. cut a random ZONE from image.

```java
// Config Singleton Instance
build = CaptchaBuild.createInstance();
CaptchaConfig config = build.getConfig();
config.addTextFont(urlFromName("/fontA.ttf"));
config.addTextFont(urlFromName("/fontB.ttf"));
config.addTextFont(urlFromName("/fontC.ttf"));
config.addTextColor("#30106c");
config.addTextColor("#0093d6");
config.addTextColor("#11476d");
config.addMaskImage(urlFromName("/bgA.jpg"));
config.addMaskImage(urlFromName("/bgB.jpg"));
config.addMaskImage(urlFromName("/bgC.jpg"));

// Generate a Random Code
String code = build.createCodeRandom(5);

// Apply Random Text Effect
BufferedImage text = build.createEffectText(code, 1, 60);

// Apply Random Background Effect
BufferedImage back = build.createEffectMask(text);

// Apply Random Captcha Effect
BufferedImage catpcha = build.createCaptcha(text, back);

// Apply Random Captcha Effect
catpcha = build.createCaptcha(code, 1, 90);
```



