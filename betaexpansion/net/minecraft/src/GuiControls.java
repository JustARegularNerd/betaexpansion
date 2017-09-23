// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GameSettings, GuiSmallButton, 
//            GuiButton

public class GuiControls extends GuiScreen
{

    public GuiControls(GuiScreen guiscreen, GameSettings gamesettings)
    {
        screenTitle = "Controls";
        buttonId = -1;
        parentScreen = guiscreen;
        options = gamesettings;
        screen = 0;
        screens = new List[3];
    }

    private int func_20080_j()
    {
        return width / 2 - 155;
    }

    public void initGui()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        bGeneral = new GuiButton(201, width / 2 - 150, 36, 100, 20, "General");
        bHotbar = new GuiButton(202, width / 2 - 50, 36, 100, 20, "Hotbar");
        bFunction = new GuiButton(203, width / 2 + 50, 36, 100, 20, "Other");
        for(int x = 0; x < 3; x++)
        {
        	screens[x] = new ArrayList();
        	screens[x].add(bGeneral);
        	screens[x].add(bHotbar);
        	screens[x].add(bFunction);
            screens[x].add(new GuiButton(200, width / 2 - 100, (int)(height / 6F) + 168, stringtranslate.translateKey("gui.done")));
        }
        int i = width / 2 - 200;
        for(int j = 0; j < 13; j++)
        {
            screens[0].add(new GuiSmallButton(j, i + (j % 3) * 135, (int)(height / 3.5F) + 24 * (j/3), 70, 20, options.getOptionDisplayString(j)));
        }
        i = width / 2 - 165;
        for(int j = 0; j < 9; j++)
        {
            screens[1].add(new GuiSmallButton(j + 13, i + (j % 2) * 180, (int)(height / 3.5F) + 24 * (j >> 1), 70, 20, options.getOptionDisplayString(j + 13)));
        }
        for(int j = 0; j < 6; j++)
        {
            screens[2].add(new GuiSmallButton(j + 22, i + (j % 2) * 180, (int)(height / 3.5F) + 24 * (j >> 1), 70, 20, options.getOptionDisplayString(j + 22)));
        }
        controlList = screens[0];

        updateButtons();
        screenTitle = stringtranslate.translateKey("controls.title");
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        for(int i = 0; i < controlList.size(); i++)
        {
        	if(((GuiButton)controlList.get(i)).id < 200)
        	{
        		((GuiButton)controlList.get(i)).displayString = options.getOptionDisplayString(((GuiButton)controlList.get(i)).id);
        	}
        }
        
        if(guibutton.id == 203)
        {
        	screen = 2;
            buttonId = -1;
        }else
        if(guibutton.id == 202)
        {
        	screen = 1;
            buttonId = -1;
        }else
        if(guibutton.id == 201)
        {
        	screen = 0;
            buttonId = -1;
        }else
        if(guibutton.id == 200)
        {
            mc.displayGuiScreen(parentScreen);
        } else
        {
            buttonId = guibutton.id;
            guibutton.displayString = (new StringBuilder()).append("> ").append(options.getOptionDisplayString(guibutton.id)).append(" <").toString();
        }
    	updateButtons();
    }

    protected void keyTyped(char c, int i)
    {
        if(buttonId >= 0)
        {
        	if(i != 1)
        	{
        		options.setKeyBinding(buttonId, i);
        	}
            ((GuiButton)controlList.get(buttonId + 4 - (screen > 0 ? screen == 1 ? 13 : 22 : 0))).displayString = options.getOptionDisplayString(buttonId);
            buttonId = -1;
        } else
        {
            super.keyTyped(c, i);
        }
    }

    protected void mouseClicked(int i, int j, int k)
    {
        if(buttonId >= 0)
        {
            options.setKeyBinding(buttonId, k - 100);
            ((GuiButton)controlList.get(buttonId + 4 - (screen > 0 ? screen == 1 ? 13 : 22 : 0))).displayString = options.getOptionDisplayString(buttonId);
            buttonId = -1;
        } else
        {
            super.mouseClicked(i, j, k);
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, screenTitle, width / 2, 20, 0xffffff);
        int k = func_20080_j();
        if(screen == 0)
        {
        	for(int l = 4; l < controlList.size(); l++)
        	{
        		drawString(fontRenderer, options.getKeyBindingDescription((l - 4) + ((GuiButton)controlList.get(4)).id), k + ((l - 4) % 3) * 135 + 24 + 6, (int)(height / 3.5F) + 24 * ((l - 4)/3) + 7, -1);
        	}
        }else
        {
        	for(int l = 4; l < controlList.size(); l++)
        	{
        		drawString(fontRenderer, options.getKeyBindingDescription((l - 4) + ((GuiButton)controlList.get(4)).id), k + ((l - 4) % 2) * 180 + 60 + 6, (int)(height / 3.5F) + 24 * ((l - 4) >> 1) + 7, -1);
        	}
        }

        super.drawScreen(i, j, f);
    }

    private void updateButtons()
    {
        bGeneral.enabled = !(screen == 0);
        bHotbar.enabled = !(screen == 1);
        bFunction.enabled = !(screen == 2);
        controlList = screens[screen];
    }
    
    
    private int screen;
    private List[] screens;
    private GuiButton bGeneral;
    private GuiButton bHotbar;
    private GuiButton bFunction;
    private GuiScreen parentScreen;
    protected String screenTitle;
    private GameSettings options;
    private int buttonId;
}