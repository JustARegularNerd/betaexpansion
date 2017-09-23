package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiCustomizeWorld extends GuiScreen 
{
    public GuiCustomizeWorld(GuiScreen guiscreen)
    {
        field_22131_a = guiscreen;
        Keyboard.enableRepeatEvents(true);
    }
    
    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
        controlList.clear();
        controlList.add(new GuiButton(0, width / 2 - 100, 76 + 12, 100, 20, seasons?"On":"Off"));
        controlList.add(new GuiButton(1, width / 2, 76 + 12, 100, 20, names[startSeason]));
        controlList.add(new GuiButton(2, width / 2 - 100, 136 + 12, "Done"));
        textboxLength = new GuiTextField(this, fontRenderer, width / 2 + 30, 120, 30, 20, "");
        textboxLength.setMaxStringLength(3);
        textboxLength.setText(""+seasonLength);
		((GuiButton)controlList.get(1)).enabled = seasons;
        textboxLength.isEnabled = seasons?(textboxLength.getText().length() > 0 && Integer.parseInt(textboxLength.getText()) != 0):false;
    }
    
    public void updateScreen()
    {
        textboxLength.updateCursorCounter();
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }
    
    protected void keyTyped(char c, int i)
    {
    	if((int)c > 47 && (int)c < 58 || (int)c == 8)
    	{
    		textboxLength.textboxKeyTyped(c, i);
    		seasonLength = textboxLength.getText().length() > 0 ? Integer.parseInt(textboxLength.getText()) : 2;
    	}
        ((GuiButton)controlList.get(2)).enabled = (textboxLength.getText().length() > 0 && Integer.parseInt(textboxLength.getText()) != 0);
    }
    
    protected void actionPerformed(GuiButton guibutton)
    {
        if(!guibutton.enabled)
        {
            return;
        }
        if(guibutton.id == 0)
        {
        	seasons = !seasons;
        	guibutton.displayString = seasons?"On":"Off";
    		textboxLength.isEnabled = seasons;
    		((GuiButton)controlList.get(1)).enabled = seasons;
        	((GuiButton)controlList.get(2)).enabled = seasons?(textboxLength.getText().length() > 0 && Integer.parseInt(textboxLength.getText()) != 0):true;
        }else
        if(guibutton.id == 1)
        {
        	startSeason = (startSeason + 1)%4;
        	guibutton.displayString = names[startSeason];
        }else
        if(guibutton.id == 2)
        {
            mc.displayGuiScreen(field_22131_a);
        }
    }

    protected void mouseClicked(int i, int j, int k)
    {
        super.mouseClicked(i, j, k);
        textboxLength.mouseClicked(i, j, k);
    }

    public void drawScreen(int i, int j, float f)
    {  
        drawDefaultBackground();
        drawCenteredString(fontRenderer, "Customize World", width / 2, (height / 4 - 60) + 20, 0xffffff);
        drawCenteredString(fontRenderer, "Seasons", width / 2 - 50,  66 + 12, 0xffffff);
        drawCenteredString(fontRenderer, "Initial Season", width / 2 + 50,  66 + 12, 0xffffff);
        drawCenteredString(fontRenderer, "Timescale:", width / 2,  128, 0xffffff);
        drawCenteredString(fontRenderer, "days", width / 2 + 76,  128, 0xa0a0a0);
        textboxLength.drawTextBox();
        super.drawScreen(i, j, f);
    }
    
    private static String[] names = new String[]{"Spring", "Summer", "Autumn", "Winter"};
    public boolean seasons = true;
    public int seasonLength = 2;
    public int startSeason = 0;
    private GuiTextField textboxLength;
    private GuiScreen field_22131_a;
}