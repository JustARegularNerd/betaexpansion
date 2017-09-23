// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

// Referenced classes of package net.minecraft.src:
//            KeyBinding, StringTranslate, EnumOptions, SoundManager, 
//            RenderGlobal, RenderEngine, EnumOptionsMappingHelper, StatCollector

public class GameSettings
{

    public GameSettings(Minecraft minecraft, File file)
    {
        musicVolume = 1.0F;
        soundVolume = 1.0F;
        mouseSensitivity = 0.5F;
        invertMouse = false;
        renderDistance = 0;
        viewBobbing = true;
        anaglyph = false;
        advancedOpengl = 0;
        limitFramerate = 0;
        fancyGraphics = true;
        ambientOcclusion = true;
        skin = "Default";
        keyBindForward = new KeyBinding("key.forward", 17);
        keyBindLeft = new KeyBinding("key.left", 30);
        keyBindBack = new KeyBinding("key.back", 31);
        keyBindRight = new KeyBinding("key.right", 32);
        keyBindJump = new KeyBinding("key.jump", 57);
        keyBindInventory = new KeyBinding("key.inventory", 18);
        keyBindDrop = new KeyBinding("key.drop", 16);
        keyBindChat = new KeyBinding("key.chat", 20);
        keyBindToggleFog = new KeyBinding("key.fog", 33);
        keyBindSneak = new KeyBinding("key.sneak", 42);
        keyBindAttack = new KeyBinding("key.attack", -100);
        keyBindUse = new KeyBinding("key.use", -99);
        keyBindPickItem = new KeyBinding("key.pickItem", -98);
        keyBindHotbar1 = new KeyBinding("key.hotbar.1", 2);
        keyBindHotbar2 = new KeyBinding("key.hotbar.2", 3);
        keyBindHotbar3 = new KeyBinding("key.hotbar.3", 4);
        keyBindHotbar4 = new KeyBinding("key.hotbar.4", 5);
        keyBindHotbar5 = new KeyBinding("key.hotbar.5", 6);
        keyBindHotbar6 = new KeyBinding("key.hotbar.6", 7);
        keyBindHotbar7 = new KeyBinding("key.hotbar.7", 8);
        keyBindHotbar8 = new KeyBinding("key.hotbar.8", 9);
        keyBindHotbar9 = new KeyBinding("key.hotbar.9", 10);
        keyToggleGui = new KeyBinding("key.toggleGui", 59);
        keyScreenShot = new KeyBinding("key.screenshot", 60);
        keyDebug = new KeyBinding("key.debug", 61);
        keyTogglePerspective = new KeyBinding("key.togglePerspective", 63);
        keySmoothCamera = new KeyBinding("key.smoothCamera", 66);
        keyFullscreen = new KeyBinding("key.fullscreen", 87);
        keyBindings = (new KeyBinding[] {
            keyBindForward, keyBindLeft, keyBindBack, keyBindRight, keyBindJump, keyBindSneak, keyBindDrop, keyBindInventory, keyBindChat, keyBindToggleFog, keyBindAttack,
            keyBindUse, keyBindPickItem, keyBindHotbar1, keyBindHotbar2, keyBindHotbar3, keyBindHotbar4, keyBindHotbar5, keyBindHotbar6, keyBindHotbar7, keyBindHotbar8,
            keyBindHotbar9, keyToggleGui, keyScreenShot, keyDebug, keyTogglePerspective, keySmoothCamera, keyFullscreen
        });
        hotbarKeys = (new KeyBinding[] {
        	keyBindHotbar1, keyBindHotbar2, keyBindHotbar3, keyBindHotbar4, keyBindHotbar5, keyBindHotbar6, keyBindHotbar7, keyBindHotbar8,
        	keyBindHotbar9
        });
        difficulty = 2;
        hideGUI = false;
        thirdPersonView = false;
        showDebugInfo = false;
        lastServer = "";
        field_22275_C = false;
        smoothCamera = false;
        field_22273_E = false;
        field_22272_F = 1.0F;
        field_22271_G = 1.0F;
        guiScale = 0;
        fov = 0.0F;
        modelPart_cape = true;
        modelPart_jacket = true;
        modelPart_left_sleeve = true;
        modelPart_right_sleeve = true;
        modelPart_left_pants_leg = true;
        modelPart_right_pants_leg = true;
        modelPart_hat = true;
        fancyGrass = false;
        fullscreen = false;
        brightness = 0.0f;
        g_Clouds = 0;
        g_Grass = 0;
        g_Vignette = 0;
        g_Leaves = 0;
        g_Shadows = 0;
        a_waterStill = true;
        a_waterFlow = true;
        a_lavaStill = true;
        a_lavaFlow = true;
        a_portal = true;
        a_fire = true;
        p_explode = true;
        p_reddust = true;
        p_smoke = true;
        p_flame = true;
        mc = minecraft;
        optionsFile = new File(file, "options.txt");
        loadOptions();
    }

    public GameSettings()
    {
        musicVolume = 1.0F;
        soundVolume = 1.0F;
        mouseSensitivity = 0.5F;
        invertMouse = false;
        renderDistance = 0;
        viewBobbing = true;
        anaglyph = false;
        advancedOpengl = 0;
        limitFramerate = 0;
        fancyGraphics = true;
        ambientOcclusion = true;
        skin = "Default";
        keyBindForward = new KeyBinding("key.forward", 17);
        keyBindLeft = new KeyBinding("key.left", 30);
        keyBindBack = new KeyBinding("key.back", 31);
        keyBindRight = new KeyBinding("key.right", 32);
        keyBindJump = new KeyBinding("key.jump", 57);
        keyBindInventory = new KeyBinding("key.inventory", 18);
        keyBindDrop = new KeyBinding("key.drop", 16);
        keyBindChat = new KeyBinding("key.chat", 20);
        keyBindToggleFog = new KeyBinding("key.fog", 33);
        keyBindSneak = new KeyBinding("key.sneak", 42);
        keyBindAttack = new KeyBinding("key.attack", -100);
        keyBindUse = new KeyBinding("key.use", -99);
        keyBindPickItem = new KeyBinding("key.pickItem", -98);
        keyBindHotbar1 = new KeyBinding("key.hotbar.1", 2);
        keyBindHotbar2 = new KeyBinding("key.hotbar.2", 3);
        keyBindHotbar3 = new KeyBinding("key.hotbar.3", 4);
        keyBindHotbar4 = new KeyBinding("key.hotbar.4", 5);
        keyBindHotbar5 = new KeyBinding("key.hotbar.5", 6);
        keyBindHotbar6 = new KeyBinding("key.hotbar.6", 7);
        keyBindHotbar7 = new KeyBinding("key.hotbar.7", 8);
        keyBindHotbar8 = new KeyBinding("key.hotbar.8", 9);
        keyBindHotbar9 = new KeyBinding("key.hotbar.9", 10);
        keyToggleGui = new KeyBinding("key.toggleGui", 59);
        keyScreenShot = new KeyBinding("key.screenshot", 60);
        keyDebug = new KeyBinding("key.debug", 61);
        keyTogglePerspective = new KeyBinding("key.togglePerspective", 63);
        keySmoothCamera = new KeyBinding("key.smoothCamera", 66);
        keyFullscreen = new KeyBinding("key.fullscreen", 87);
        
        keyBindings = (new KeyBinding[] {
            keyBindForward, keyBindLeft, keyBindBack, keyBindRight, keyBindJump, keyBindSneak, keyBindDrop, keyBindInventory, keyBindChat, keyBindToggleFog, keyBindAttack,
            keyBindUse, keyBindPickItem, keyBindHotbar1, keyBindHotbar2, keyBindHotbar3, keyBindHotbar4, keyBindHotbar5, keyBindHotbar6, keyBindHotbar7, keyBindHotbar8,
            keyBindHotbar9, keyToggleGui, keyScreenShot, keyDebug, keyTogglePerspective, keySmoothCamera, keyFullscreen
        });
        hotbarKeys = (new KeyBinding[] {
            keyBindHotbar1, keyBindHotbar2, keyBindHotbar3, keyBindHotbar4, keyBindHotbar5, keyBindHotbar6, keyBindHotbar7, keyBindHotbar8,
            keyBindHotbar9
        });
        difficulty = 2;
        hideGUI = false;
        thirdPersonView = false;
        showDebugInfo = false;
        lastServer = "";
        field_22275_C = false;
        smoothCamera = false;
        field_22273_E = false;
        field_22272_F = 1.0F;
        field_22271_G = 1.0F;
        guiScale = 0;
        fov = 0.0F;
        modelPart_cape = true;
        modelPart_jacket = true;
        modelPart_left_sleeve = true;
        modelPart_right_sleeve = true;
        modelPart_left_pants_leg = true;
        modelPart_right_pants_leg = true;
        modelPart_hat = true;
        fancyGrass = false;
        fullscreen = false;
        brightness = 0.0f;
        g_Clouds = 0;
        g_Grass = 0;
        g_Vignette = 0;
        g_Leaves = 0;
        g_Shadows = 0;
        a_waterStill = true;
        a_waterFlow = true;
        a_lavaStill = true;
        a_lavaFlow = true;
        a_portal = true;
        a_fire = true;
        p_explode = true;
        p_reddust = true;
        p_smoke = true;
        p_flame = true;
    }

    public String getKeyBindingDescription(int i)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        return stringtranslate.translateKey(keyBindings[i].keyDescription);
    }

    public String getOptionDisplayString(int i)
    {
    	if(keyBindings[i].keyCode < 0)
    	{
    		return Mouse.getButtonName(keyBindings[i].keyCode + 100);
    	}
        return Keyboard.getKeyName(keyBindings[i].keyCode);
    }

    public void setKeyBinding(int i, int j)
    {
        keyBindings[i].keyCode = j;
        saveOptions();
    }

    public void setOptionFloatValue(EnumOptions enumoptions, float f)
    {
        if(enumoptions == EnumOptions.MUSIC)
        {
            musicVolume = f;
            mc.sndManager.onSoundOptionsChanged();
        }
        if(enumoptions == EnumOptions.SOUND)
        {
            soundVolume = f;
            mc.sndManager.onSoundOptionsChanged();
        }
        if(enumoptions == EnumOptions.SENSITIVITY)
        {
            mouseSensitivity = f;
        }
        if(enumoptions == EnumOptions.FOV)
        {
            fov = f;
        }
        if(enumoptions == EnumOptions.BRIGHTNESS)
        {
        	brightness = f;
        	if(mc.theWorld != null)
        	{
        		mc.theWorld.worldProvider.generateLightBrightnessTable();
        		mc.renderGlobal.loadRenderers(false);
        	}
        }
    }

    public void setOptionValue(EnumOptions enumoptions, int i)
    {
        if(enumoptions == EnumOptions.INVERT_MOUSE)
        {
            invertMouse = !invertMouse;
        }
        if(enumoptions == EnumOptions.RENDER_DISTANCE)
        {
            renderDistance = renderDistance + i & 3;
        }
        if(enumoptions == EnumOptions.GUI_SCALE)
        {
            guiScale = guiScale + i & 3;
        }
        if(enumoptions == EnumOptions.VIEW_BOBBING)
        {
            viewBobbing = !viewBobbing;
        }
        if(enumoptions == EnumOptions.ADVANCED_OPENGL)
        {
            advancedOpengl = (advancedOpengl + i) % 3;
            mc.renderGlobal.loadRenderers(false);
        }
        if(enumoptions == EnumOptions.ANAGLYPH)
        {
            anaglyph = !anaglyph;
            mc.renderEngine.refreshTextures();
        }
        if(enumoptions == EnumOptions.FRAMERATE_LIMIT)
        {
            limitFramerate = (limitFramerate + i + 4) % 4;
            Display.setVSyncEnabled(limitFramerate == 3);
        }
        if(enumoptions == EnumOptions.DIFFICULTY)
        {
            difficulty = difficulty + i & 3;
        }
        if(enumoptions == EnumOptions.GRAPHICS)
        {
            fancyGraphics = !fancyGraphics;
            mc.renderGlobal.loadRenderers(false);
        }
        if(enumoptions == EnumOptions.AMBIENT_OCCLUSION)
        {
            ambientOcclusion = !ambientOcclusion;
            mc.renderGlobal.loadRenderers(false);
        }
        if(enumoptions == EnumOptions.FANCYGRASS)
        {
            fancyGrass = !fancyGrass;
            RenderBlocks.grassSide = fancyGrass;
            mc.renderGlobal.loadRenderers(false);
        }
  
        if(enumoptions == EnumOptions.M_CAPE) {modelPart_cape = !modelPart_cape;}
        if(enumoptions == EnumOptions.M_JACKET) {modelPart_jacket = !modelPart_jacket;}
        if(enumoptions == EnumOptions.M_LEFTSLEEVE) {modelPart_left_sleeve = !modelPart_left_sleeve;}
        if(enumoptions == EnumOptions.M_RIGHTSLEEVE) {modelPart_right_sleeve = !modelPart_right_sleeve;}
        if(enumoptions == EnumOptions.M_LEFTLEG) {modelPart_left_pants_leg = !modelPart_left_pants_leg;}
        if(enumoptions == EnumOptions.M_RIGHTLEG) {modelPart_right_pants_leg = !modelPart_right_pants_leg;}
        if(enumoptions == EnumOptions.M_HAT) {modelPart_hat = !modelPart_hat;}
        
        if(enumoptions == EnumOptions.G_CLOUDS)
        {
            g_Clouds = (g_Clouds + i + 4) % 4;
        }
        if(enumoptions == EnumOptions.G_GRASS)
        {
            g_Grass = (g_Grass + i + 3) % 3;
            mc.renderGlobal.loadRenderers(false);
        }
        if(enumoptions == EnumOptions.G_VIGNETTE)
        {
            g_Vignette = (g_Vignette + i + 3) % 3;
        }
        if(enumoptions == EnumOptions.G_LEAVES)
        {
            g_Leaves = (g_Leaves + i + 3) % 3;
            mc.renderGlobal.loadRenderers(false);
        }
        if(enumoptions == EnumOptions.G_SHADOWS)
        {
            g_Shadows = (g_Shadows + i + 3) % 3;
        }
        
        if(enumoptions == EnumOptions.A_WATERSTILL) {a_waterStill = !a_waterStill; mc.renderEngine.reloadFX(); mc.renderGlobal.loadRenderers(false);}
        if(enumoptions == EnumOptions.A_WATERFLOW) {a_waterFlow = !a_waterFlow; mc.renderEngine.reloadFX(); mc.renderGlobal.loadRenderers(false);}
        if(enumoptions == EnumOptions.A_LAVASTILL) {a_lavaStill = !a_lavaStill; mc.renderEngine.reloadFX(); mc.renderGlobal.loadRenderers(false);}
        if(enumoptions == EnumOptions.A_LAVAFLOW) {a_lavaFlow = !a_lavaFlow; mc.renderEngine.reloadFX(); mc.renderGlobal.loadRenderers(false);}
        if(enumoptions == EnumOptions.A_PORTAL) {a_portal = !a_portal; mc.renderEngine.reloadFX(); mc.renderGlobal.loadRenderers(false);}
        if(enumoptions == EnumOptions.A_FIRE) {a_fire = !a_fire; mc.renderEngine.reloadFX(); mc.renderGlobal.loadRenderers(false);}
        
        if(enumoptions == EnumOptions.P_EXPLODE) {p_explode = !p_explode;}
        if(enumoptions == EnumOptions.P_REDDUST) {p_reddust = !p_reddust;}
        if(enumoptions == EnumOptions.P_SMOKE) {p_smoke = !p_smoke;}
        if(enumoptions == EnumOptions.P_FLAME) {p_flame = !p_flame;}
        saveOptions();
    }

    public float getOptionFloatValue(EnumOptions enumoptions)
    {
        if(enumoptions == EnumOptions.MUSIC)
        {
            return musicVolume;
        }
        if(enumoptions == EnumOptions.SOUND)
        {
            return soundVolume;
        }
        if(enumoptions == EnumOptions.SENSITIVITY)
        {
            return mouseSensitivity;
        }
        if(enumoptions == EnumOptions.FOV)
        {
        	return fov;
        }
        if(enumoptions == EnumOptions.BRIGHTNESS)
        {
        	return brightness;
        } else
        {
            return 0.0F;
        }
    }

    public boolean getOptionOrdinalValue(EnumOptions enumoptions)
    {
        if(enumoptions == EnumOptions.FANCYGRASS) {return fancyGrass;}

        if(enumoptions == EnumOptions.M_CAPE) {return modelPart_cape;}
        if(enumoptions == EnumOptions.M_JACKET) {return modelPart_jacket;}
        if(enumoptions == EnumOptions.M_LEFTSLEEVE) {return modelPart_left_sleeve;}
        if(enumoptions == EnumOptions.M_RIGHTSLEEVE) {return modelPart_right_sleeve;}
        if(enumoptions == EnumOptions.M_LEFTLEG) {return modelPart_left_pants_leg;}
        if(enumoptions == EnumOptions.M_RIGHTLEG) {return modelPart_right_pants_leg;}
        if(enumoptions == EnumOptions.M_HAT) {return modelPart_hat;}

        if(enumoptions == EnumOptions.A_WATERSTILL) {return a_waterStill;}
        if(enumoptions == EnumOptions.A_WATERFLOW) {return a_waterFlow;}
        if(enumoptions == EnumOptions.A_LAVASTILL) {return a_lavaStill;}
        if(enumoptions == EnumOptions.A_LAVAFLOW) {return a_lavaFlow;}
        if(enumoptions == EnumOptions.A_PORTAL) {return a_portal;}
        if(enumoptions == EnumOptions.A_FIRE) {return a_fire;}
        
        if(enumoptions == EnumOptions.P_EXPLODE) {return p_explode;}
        if(enumoptions == EnumOptions.P_REDDUST) {return p_reddust;}
        if(enumoptions == EnumOptions.P_SMOKE) {return p_smoke;}
        if(enumoptions == EnumOptions.P_FLAME) {return p_flame;}
        
        switch(EnumOptionsMappingHelper.enumOptionsMappingHelperArray[enumoptions.ordinal()])
        {
        case 1: // '\001'
            return invertMouse;

        case 2: // '\002'
            return viewBobbing;

        case 3: // '\003'
            return anaglyph;

        case 4: // '\005'
            return ambientOcclusion;
        }
        return false;
    }

    public String getKeyBinding(EnumOptions enumoptions)
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        String s = (new StringBuilder()).append(stringtranslate.translateKey(enumoptions.getEnumString())).append(": ").toString();
        if(enumoptions.getEnumFloat())
        {
            float f = getOptionFloatValue(enumoptions);
            if(enumoptions == EnumOptions.SENSITIVITY)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.sensitivity.min")).toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.sensitivity.max")).toString();
                } else
                {
                    return (new StringBuilder()).append(s).append((int)(f * 200F)).append("%").toString();
                }
            }
            if(enumoptions == EnumOptions.FOV)
            {
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s).append("Normal").toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s).append("Quake Pro").toString();
                } else
                {
                    return (new StringBuilder()).append(s).append((int)(70F + f * 40F)).toString();
                }
            }
            if(f == 0.0F)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.off")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append((int)(f * 100F)).append("%").toString();
            }
        }
        if(enumoptions.getEnumBoolean())
        {
            boolean flag = getOptionOrdinalValue(enumoptions);
            if(flag)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.on")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.off")).toString();
            }
        }
        if(enumoptions == EnumOptions.RENDER_DISTANCE)
        {
            return (new StringBuilder()).append(s).append(stringtranslate.translateKey(RENDER_DISTANCES[renderDistance])).toString();
        }
        if(enumoptions == EnumOptions.DIFFICULTY)
        {
            return (new StringBuilder()).append(s).append(stringtranslate.translateKey(DIFFICULTIES[difficulty])).toString();
        }
        if(enumoptions == EnumOptions.GUI_SCALE)
        {
            return (new StringBuilder()).append(s).append(stringtranslate.translateKey(GUISCALES[guiScale])).toString();
        }
        if(enumoptions == EnumOptions.FRAMERATE_LIMIT)
        {
            return (new StringBuilder()).append(s).append(StatCollector.translateToLocal(LIMIT_FRAMERATES[limitFramerate])).toString();
        }
        if(enumoptions == EnumOptions.ADVANCED_OPENGL)
        {
            return (new StringBuilder()).append(s).append(OPENGL[advancedOpengl]).toString();
        }
        if(enumoptions == EnumOptions.GRAPHICS)
        {
            if(fancyGraphics)
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.graphics.fancy")).toString();
            } else
            {
                return (new StringBuilder()).append(s).append(stringtranslate.translateKey("options.graphics.fast")).toString();
            }
        }
        if(enumoptions == EnumOptions.G_CLOUDS)
        {
        	return (new StringBuilder()).append(s).append(DETAIL4[g_Clouds]).toString();
        }
        if(enumoptions == EnumOptions.G_GRASS)
        {
        	return (new StringBuilder()).append(s).append(DETAIL[g_Grass]).toString();
        }
        if(enumoptions == EnumOptions.G_VIGNETTE)
        {
        	return (new StringBuilder()).append(s).append(ONOFF[g_Vignette]).toString();
        }
        if(enumoptions == EnumOptions.G_LEAVES)
        {
        	return (new StringBuilder()).append(s).append(DETAIL[g_Leaves]).toString();
        }
        if(enumoptions == EnumOptions.G_SHADOWS)
        {
        	return (new StringBuilder()).append(s).append(ONOFF[g_Shadows]).toString();
        } else
        {
            return s;
        }
    }

    public void loadOptions()
    {
        try
        {
            if(!optionsFile.exists())
            {
                return;
            }
            BufferedReader bufferedreader = new BufferedReader(new FileReader(optionsFile));
            for(String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                try
                {
                    String as[] = s.split(":");
                    if(as[0].equals("music"))
                    {
                        musicVolume = parseFloat(as[1]);
                    }
                    if(as[0].equals("sound"))
                    {
                        soundVolume = parseFloat(as[1]);
                    }
                    if(as[0].equals("mouseSensitivity"))
                    {
                        mouseSensitivity = parseFloat(as[1]);
                    }
                    if(as[0].equals("invertYMouse"))
                    {
                        invertMouse = as[1].equals("true");
                    }
                    if(as[0].equals("viewDistance"))
                    {
                        renderDistance = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("guiScale"))
                    {
                        guiScale = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("bobView"))
                    {
                        viewBobbing = as[1].equals("true");
                    }
                    if(as[0].equals("anaglyph3d"))
                    {
                        anaglyph = as[1].equals("true");
                    }
                    if(as[0].equals("advancedOpengl"))
                    {
                        advancedOpengl = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("fpsLimit"))
                    {
                        limitFramerate = Integer.parseInt(as[1]);
                        Display.setVSyncEnabled(limitFramerate == 3);
                    }
                    if(as[0].equals("difficulty"))
                    {
                        difficulty = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("fancyGraphics"))
                    {
                        fancyGraphics = as[1].equals("true");
                    }
                    if(as[0].equals("ao"))
                    {
                        ambientOcclusion = as[1].equals("true");
                    }
                    if(as[0].equals("skin"))
                    {
                        skin = as[1];
                    }
                    if(as[0].equals("lastServer") && as.length >= 2)
                    {
                        lastServer = as[1];
                    }
                    if(as[0].equals("fov"))
                    {
                        fov = parseFloat(as[1]);
                    }
                    
                    int i = 0;
                    while(i < keyBindings.length) 
                    {
                        if(as[0].equals((new StringBuilder()).append("key_").append(keyBindings[i].keyDescription).toString()))
                        {
                            keyBindings[i].keyCode = Integer.parseInt(as[1]);
                        }
                        i++;
                    }
                    if(as[0].equals("modelPart_cape"))
                    {
                    	modelPart_cape = as[1].equals("true");
                    }
                    if(as[0].equals("modelPart_jacket"))
                    {
                    	modelPart_jacket = as[1].equals("true");
                    }
                    if(as[0].equals("modelPart_left_sleeve"))
                    {
                    	modelPart_left_sleeve = as[1].equals("true");
                    }
                    if(as[0].equals("modelPart_right_sleeve"))
                    {
                    	modelPart_right_sleeve = as[1].equals("true");
                    }
                    if(as[0].equals("modelPart_left_pants_leg"))
                    {
                    	modelPart_left_pants_leg = as[1].equals("true");
                    }
                    if(as[0].equals("modelPart_right_pants_leg"))
                    {
                    	modelPart_right_pants_leg = as[1].equals("true");
                    }
                    if(as[0].equals("modelPart_hat"))
                    {
                    	modelPart_hat = as[1].equals("true");
                    }
                    if(as[0].equals("fancyGrass"))
                    {
                    	fancyGrass = as[1].equals("true");
                    }
                    if(as[0].equals("fullscreen"))
                    {
                    	fullscreen = as[1].equals("true");
                    }
                    if(as[0].equals("brightness"))
                    {
                    	brightness = parseFloat(as[1]);
                    }
                    if(as[0].equals("g_Clouds"))
                    {
                    	g_Clouds = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("g_Grass"))
                    {
                    	g_Grass = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("g_Vignette"))
                    {
                    	g_Vignette = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("g_Leaves"))
                    {
                    	g_Leaves = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("g_Shadows"))
                    {
                    	g_Shadows = Integer.parseInt(as[1]);
                    }
                    if(as[0].equals("a_waterStill"))
                    {
                    	a_waterStill = as[1].equals("true");
                    }
                    if(as[0].equals("a_waterFlow"))
                    {
                    	a_waterFlow = as[1].equals("true");
                    }
                    if(as[0].equals("a_lavaStill"))
                    {
                    	a_lavaStill = as[1].equals("true");
                    }
                    if(as[0].equals("a_lavaFlow"))
                    {
                    	a_lavaFlow = as[1].equals("true");
                    }
                    if(as[0].equals("a_Portal"))
                    {
                    	a_portal = as[1].equals("true");
                    }
                    if(as[0].equals("a_Fire"))
                    {
                    	a_fire = as[1].equals("true");
                    }
                    if(as[0].equals("p_explode"))
                    {
                    	p_explode = as[1].equals("true");
                    }
                    if(as[0].equals("p_reddust"))
                    {
                    	p_reddust = as[1].equals("true");
                    }
                    if(as[0].equals("p_smoke"))
                    {
                    	p_smoke = as[1].equals("true");
                    }
                    if(as[0].equals("p_flame"))
                    {
                    	p_flame = as[1].equals("true");
                    }
                }
                catch(Exception exception1)
                {
                    System.out.println((new StringBuilder()).append("Skipping bad option: ").append(s).toString());
                }
            }

            bufferedreader.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
    }

    private float parseFloat(String s)
    {
        if(s.equals("true"))
        {
            return 1.0F;
        }
        if(s.equals("false"))
        {
            return 0.0F;
        } else
        {
            return Float.parseFloat(s);
        }
    }

    public void saveOptions()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(optionsFile));
            printwriter.println((new StringBuilder()).append("music:").append(musicVolume).toString());
            printwriter.println((new StringBuilder()).append("sound:").append(soundVolume).toString());
            printwriter.println((new StringBuilder()).append("invertYMouse:").append(invertMouse).toString());
            printwriter.println((new StringBuilder()).append("mouseSensitivity:").append(mouseSensitivity).toString());
            printwriter.println((new StringBuilder()).append("viewDistance:").append(renderDistance).toString());
            printwriter.println((new StringBuilder()).append("guiScale:").append(guiScale).toString());
            printwriter.println((new StringBuilder()).append("bobView:").append(viewBobbing).toString());
            printwriter.println((new StringBuilder()).append("anaglyph3d:").append(anaglyph).toString());
            printwriter.println((new StringBuilder()).append("advancedOpengl:").append(advancedOpengl).toString());
            printwriter.println((new StringBuilder()).append("fpsLimit:").append(limitFramerate).toString());
            printwriter.println((new StringBuilder()).append("difficulty:").append(difficulty).toString());
            printwriter.println((new StringBuilder()).append("fancyGraphics:").append(fancyGraphics).toString());
            printwriter.println((new StringBuilder()).append("ao:").append(ambientOcclusion).toString());
            printwriter.println((new StringBuilder()).append("skin:").append(skin).toString());
            printwriter.println((new StringBuilder()).append("lastServer:").append(lastServer).toString());
            printwriter.println((new StringBuilder()).append("fov:").append(fov).toString());
            printwriter.println((new StringBuilder()).append("modelPart_cape:").append(modelPart_cape).toString());
            printwriter.println((new StringBuilder()).append("modelPart_jacket:").append(modelPart_jacket).toString());
            printwriter.println((new StringBuilder()).append("modelPart_left_sleeve:").append(modelPart_left_sleeve).toString());
            printwriter.println((new StringBuilder()).append("modelPart_right_sleeve:").append(modelPart_right_sleeve).toString());
            printwriter.println((new StringBuilder()).append("modelPart_left_pants_leg:").append(modelPart_left_pants_leg).toString());
            printwriter.println((new StringBuilder()).append("modelPart_right_pants_leg:").append(modelPart_right_pants_leg).toString());
            printwriter.println((new StringBuilder()).append("modelPart_hat:").append(modelPart_hat).toString());
            printwriter.println((new StringBuilder()).append("fancyGrass:").append(fancyGrass).toString());
            printwriter.println((new StringBuilder()).append("fullscreen:").append(fullscreen).toString());
            printwriter.println((new StringBuilder()).append("brightness:").append(brightness).toString());
            printwriter.println((new StringBuilder()).append("g_Clouds:").append(g_Clouds).toString());
            printwriter.println((new StringBuilder()).append("g_Grass:").append(g_Grass).toString());
            printwriter.println((new StringBuilder()).append("g_Vignette:").append(g_Vignette).toString());
            printwriter.println((new StringBuilder()).append("g_Leaves:").append(g_Leaves).toString());
            printwriter.println((new StringBuilder()).append("g_Shadows:").append(g_Shadows).toString());
            printwriter.println((new StringBuilder()).append("a_waterStill:").append(a_waterStill).toString());
            printwriter.println((new StringBuilder()).append("a_waterFlow:").append(a_waterFlow).toString());
            printwriter.println((new StringBuilder()).append("a_lavaStill:").append(a_lavaStill).toString());
            printwriter.println((new StringBuilder()).append("a_lavaFlow:").append(a_lavaFlow).toString());
            printwriter.println((new StringBuilder()).append("a_portal:").append(a_portal).toString());
            printwriter.println((new StringBuilder()).append("a_fire:").append(a_fire).toString());
            printwriter.println((new StringBuilder()).append("p_explode:").append(p_explode).toString());
            printwriter.println((new StringBuilder()).append("p_reddust:").append(p_reddust).toString());
            printwriter.println((new StringBuilder()).append("p_smoke:").append(p_smoke).toString());
            printwriter.println((new StringBuilder()).append("p_flame:").append(p_flame).toString());
            for(int i = 0; i < keyBindings.length; i++)
            {
                printwriter.println((new StringBuilder()).append("key_").append(keyBindings[i].keyDescription).append(":").append(keyBindings[i].keyCode).toString());
            }
            printwriter.close();
        }
        catch(Exception exception)
        {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
    }

    private static final String RENDER_DISTANCES[] = {
        "options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"
    };
    private static final String DIFFICULTIES[] = {
        "options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"
    };
    private static final String GUISCALES[] = {
        "options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"
    };
    private static final String LIMIT_FRAMERATES[] = {
        "performance.max", "performance.balanced", "performance.powersaver", "VSync"
    };
    private static final String OPENGL[] = {
        "OFF", "Fast", "Fancy"
    };
    private static final String ONOFF[] = {
        "Default", "OFF", "ON"
    };
    private static final String DETAIL[] = {
        "Default", "Fast", "Fancy"
    };
    private static final String DETAIL4[] = {
        "Default", "Fast", "Fancy", "OFF"
    };
    public float musicVolume;
    public float soundVolume;
    public float mouseSensitivity;
    public boolean invertMouse;
    public int renderDistance;
    public boolean viewBobbing;
    public boolean anaglyph;
    public static int advancedOpengl;
    public int limitFramerate;
    public boolean fancyGraphics;
    public boolean ambientOcclusion;
    public String skin;
    public KeyBinding keyBindForward;
    public KeyBinding keyBindLeft;
    public KeyBinding keyBindBack;
    public KeyBinding keyBindRight;
    public KeyBinding keyBindJump;
    public KeyBinding keyBindInventory;
    public KeyBinding keyBindDrop;
    public KeyBinding keyBindChat;
    public KeyBinding keyBindToggleFog;
    public KeyBinding keyBindSneak;
    public KeyBinding keyBindAttack;
    public KeyBinding keyBindUse;
    public KeyBinding keyBindPickItem;
    public KeyBinding keyBindHotbar1;
    public KeyBinding keyBindHotbar2;
    public KeyBinding keyBindHotbar3;
    public KeyBinding keyBindHotbar4;
    public KeyBinding keyBindHotbar5;
    public KeyBinding keyBindHotbar6;
    public KeyBinding keyBindHotbar7;
    public KeyBinding keyBindHotbar8;
    public KeyBinding keyBindHotbar9;
    public KeyBinding keyToggleGui;
    public KeyBinding keyScreenShot;
    public KeyBinding keyDebug;
    public KeyBinding keyTogglePerspective;
    public KeyBinding keySmoothCamera;
    public KeyBinding keyFullscreen;

    public KeyBinding keyBindings[];
    public KeyBinding hotbarKeys[];
    protected Minecraft mc;
    private File optionsFile;
    public int difficulty;
    public boolean hideGUI;
    public boolean thirdPersonView;
    public boolean showDebugInfo;
    public String lastServer;
    public boolean field_22275_C;
    public boolean smoothCamera;
    public boolean field_22273_E;
    public float field_22272_F;
    public float field_22271_G;
    public int guiScale;
    public float fov;
    public static boolean modelPart_cape;
    public static boolean modelPart_jacket;
    public static boolean modelPart_left_sleeve;
    public static boolean modelPart_right_sleeve;
    public static boolean modelPart_left_pants_leg;
    public static boolean modelPart_right_pants_leg;
    public static boolean modelPart_hat;
    public boolean fancyGrass;
    public boolean fullscreen;
    public static float brightness;
    public int g_Clouds;
    public int g_Grass;
    public int g_Vignette;
    public int g_Leaves;
    public int g_Shadows;
    public boolean a_waterStill;
    public boolean a_waterFlow;
    public boolean a_lavaStill;
    public boolean a_lavaFlow;
    public boolean a_portal;
    public boolean a_fire;
    public boolean p_explode;
    public boolean p_reddust;
    public boolean p_smoke;
    public boolean p_flame;
}
