// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


public enum EnumOptions
{
    MUSIC("MUSIC", 0, "options.music", true, false),
    SOUND("SOUND", 1, "options.sound", true, false),
    INVERT_MOUSE("INVERT_MOUSE", 2, "options.invertMouse", false, true),
    SENSITIVITY("SENSITIVITY", 3, "options.sensitivity", true, false),
    RENDER_DISTANCE("RENDER_DISTANCE", 4, "options.renderDistance", false, false),
    VIEW_BOBBING("VIEW_BOBBING", 5, "options.viewBobbing", false, true),
    ANAGLYPH("ANAGLYPH", 6, "options.anaglyph", false, true),
    ADVANCED_OPENGL("ADVANCED_OPENGL", 7, "options.advancedOpengl", false, false),
    FRAMERATE_LIMIT("FRAMERATE_LIMIT", 8, "options.framerateLimit", false, false),
    DIFFICULTY("DIFFICULTY", 9, "options.difficulty", false, false),
    GRAPHICS("GRAPHICS", 10, "options.graphics", false, false),
    AMBIENT_OCCLUSION("AMBIENT_OCCLUSION", 11, "options.ao", false, true),
    GUI_SCALE("GUI_SCALE", 12, "options.guiScale", false, false),
    FOV("FOV", 13, "FOV", true, false),
	M_CAPE("M_CAPE", 14, "Cape", false, true),
	M_JACKET("M_JACKET", 15, "Jacket", false, true),
	M_LEFTSLEEVE("M_LEFTSLEEVE", 16, "Left Sleeve", false, true),
	M_RIGHTSLEEVE("M_RIGHTSLEEVE", 17, "Right Sleeve", false, true),
	M_LEFTLEG("M_LEFTLEG", 18, "Left Pants Leg", false, true),
	M_RIGHTLEG("M_RIGHTLEG", 19, "Right Pants Leg", false, true),
	M_HAT("M_HAT", 20, "Hat", false, true),
    FANCYGRASS("FANCYGRASS", 21, "Better Grass", false, true),
    BRIGHTNESS("BRIGHTNESS", 22, "Brightness", true, false),
    G_CLOUDS("G_CLOUDS", 17, "Clouds", false, false),
    G_GRASS("G_GRASS", 18, "Grass", false, false),
    G_VIGNETTE("G_VIGNETTE", 19, "Vignette", false, false),
    G_LEAVES("G_LEAVES", 20, "Leaves", false, false),
    G_SHADOWS("G_SHADOWS", 21, "Entity Shadows", false, false),
    A_WATERSTILL("A_WATERSTILL", 22, "Stationary Water", false, true),
    A_WATERFLOW("A_WATERFLOW", 23, "Flowing Water", false, true),
    A_LAVASTILL("A_LAVASTILL", 24, "Stationary Lava", false, true),
    A_LAVAFLOW("A_LAVAFLOW", 25, "Flowing Lava", false, true),
    A_PORTAL("A_PORTAL", 26, "Portal", false, true),
    A_FIRE("A_FIRE", 27, "Fire", false, true),
	P_EXPLODE("P_EXPLODE", 24, "Explosion", false, true),
	P_REDDUST("P_REDDUST", 25, "Redstone Dust", false, true),
	P_SMOKE("P_SMOKE", 26, "Smoke", false, true),
	P_FLAME("P_FLAME", 27, "Flames", false, true);
    
    //FANCYAO("FANCYAO", 22, "Better Lighting", false, true);

/*
    public static EnumOptions[] values()
    {
        return (EnumOptions[])field_20141_n.clone();
    }

    public static EnumOptions valueOf(String s)
    {
        return (EnumOptions)Enum.valueOf(net.minecraft.src.EnumOptions.class, s);
    }
*/
    public static EnumOptions getEnumOptions(int i)
    {
        EnumOptions aenumoptions[] = values();
        int j = aenumoptions.length;
        for(int k = 0; k < j; k++)
        {
            EnumOptions enumoptions = aenumoptions[k];
            if(enumoptions.returnEnumOrdinal() == i)
            {
                return enumoptions;
            }
        }

        return null;
    }

    private EnumOptions(String s, int i, String s1, boolean flag, boolean flag1)
    {
//        super(s, i);
        enumString = s1;
        enumFloat = flag;
        enumBoolean = flag1;
    }

    public boolean getEnumFloat()
    {
        return enumFloat;
    }

    public boolean getEnumBoolean()
    {
        return enumBoolean;
    }

    public int returnEnumOrdinal()
    {
        return ordinal();
    }

    public String getEnumString()
    {
        return enumString;
    }
/*
    public static final EnumOptions MUSIC;
    public static final EnumOptions SOUND;
    public static final EnumOptions INVERT_MOUSE;
    public static final EnumOptions SENSITIVITY;
    public static final EnumOptions RENDER_DISTANCE;
    public static final EnumOptions VIEW_BOBBING;
    public static final EnumOptions ANAGLYPH;
    public static final EnumOptions ADVANCED_OPENGL;
    public static final EnumOptions FRAMERATE_LIMIT;
    public static final EnumOptions DIFFICULTY;
    public static final EnumOptions GRAPHICS;
    public static final EnumOptions AMBIENT_OCCLUSION;
    public static final EnumOptions GUI_SCALE;
*/
    private final boolean enumFloat;
    private final boolean enumBoolean;
    private final String enumString;
    private static final EnumOptions field_20141_n[]; /* synthetic field */

    static 
    {
/*
        MUSIC = new EnumOptions("MUSIC", 0, "options.music", true, false);
        SOUND = new EnumOptions("SOUND", 1, "options.sound", true, false);
        INVERT_MOUSE = new EnumOptions("INVERT_MOUSE", 2, "options.invertMouse", false, true);
        SENSITIVITY = new EnumOptions("SENSITIVITY", 3, "options.sensitivity", true, false);
        RENDER_DISTANCE = new EnumOptions("RENDER_DISTANCE", 4, "options.renderDistance", false, false);
        VIEW_BOBBING = new EnumOptions("VIEW_BOBBING", 5, "options.viewBobbing", false, true);
        ANAGLYPH = new EnumOptions("ANAGLYPH", 6, "options.anaglyph", false, true);
        ADVANCED_OPENGL = new EnumOptions("ADVANCED_OPENGL", 7, "options.advancedOpengl", false, true);
        FRAMERATE_LIMIT = new EnumOptions("FRAMERATE_LIMIT", 8, "options.framerateLimit", false, false);
        DIFFICULTY = new EnumOptions("DIFFICULTY", 9, "options.difficulty", false, false);
        GRAPHICS = new EnumOptions("GRAPHICS", 10, "options.graphics", false, false);
        AMBIENT_OCCLUSION = new EnumOptions("AMBIENT_OCCLUSION", 11, "options.ao", false, true);
        GUI_SCALE = new EnumOptions("GUI_SCALE", 12, "options.guiScale", false, false);
*/
        field_20141_n = (new EnumOptions[] {
            MUSIC, SOUND, INVERT_MOUSE, SENSITIVITY, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, ADVANCED_OPENGL, FRAMERATE_LIMIT, DIFFICULTY, 
            GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, FOV, M_CAPE, M_LEFTSLEEVE, M_RIGHTSLEEVE, M_LEFTLEG, M_RIGHTLEG, M_HAT, FANCYGRASS, BRIGHTNESS, 
            G_CLOUDS, G_GRASS, G_VIGNETTE, G_LEAVES, G_SHADOWS, A_WATERSTILL, A_WATERFLOW, A_LAVASTILL, A_LAVAFLOW, A_PORTAL, A_FIRE, P_EXPLODE, P_REDDUST,
            P_SMOKE, P_FLAME
        });
    }
}
