package net.minecraft.src;

public class BEItems {
	public static Item[] origItemsList;
    public static Item spyGlass;
    public static Item recordBlocks;
    public static Item recordChirp;
    public static Item recordFar;
    public static Item recordMall;
    public static Item recordMellohi;
    public static Item recordStal;
    public static Item recordStrad;
    public static Item recordWard;
    public static Item record11;
    public static Item recordWait;
    public static Item battleAxeWood;
    public static Item battleAxeStone;
    public static Item battleAxeIron;
    public static Item battleAxeGold;
    public static Item battleAxeDiamond;
    public static Item berry;
    public static Item pieSlice;
    static
    {
		origItemsList = Item.itemsList.clone();
		spyGlass = (new ItemSpyglass(1500)).setIconCoord(0,0).setItemName("spyGlass");
        recordBlocks = (new ItemRecord(2002, "blocks")).setIconCoord(0, 15).setItemName("record");
        recordChirp = (new ItemRecord(2003, "chirp")).setIconCoord(1, 15).setItemName("record");
        recordFar = (new ItemRecord(2004, "far")).setIconCoord(2, 15).setItemName("record");
        recordMall = (new ItemRecord(2005, "mall")).setIconCoord(3, 15).setItemName("record");
        recordMellohi = (new ItemRecord(2006, "mellohi")).setIconCoord(4, 15).setItemName("record");
        recordStal = (new ItemRecord(2007, "stal")).setIconCoord(5, 15).setItemName("record");
        recordStrad = (new ItemRecord(2008, "strad")).setIconCoord(6, 15).setItemName("record");
        recordWard = (new ItemRecord(2009, "ward")).setIconCoord(7, 15).setItemName("record");
        record11 = (new ItemRecord(2010, "11")).setIconCoord(8, 15).setItemName("record");
        recordWait = (new ItemRecord(2011, "wait")).setIconCoord(9, 15).setItemName("record");
        battleAxeWood = (new ItemBattleAxe(1501, EnumToolMaterial.WOOD)).setIconCoord(0, 14).setItemName("battleAxeWood");
        battleAxeStone = (new ItemBattleAxe(1502, EnumToolMaterial.STONE)).setIconCoord(1, 14).setItemName("battleAxeStone");
        battleAxeIron = (new ItemBattleAxe(1503, EnumToolMaterial.IRON)).setIconCoord(2, 14).setItemName("battleAxeIron");
        battleAxeGold = (new ItemBattleAxe(1504, EnumToolMaterial.GOLD)).setIconCoord(4, 14).setItemName("battleAxeGold");
        battleAxeDiamond = (new ItemBattleAxe(1505, EnumToolMaterial.EMERALD)).setIconCoord(3, 14).setItemName("battleAxeDiamond");
        berry = (new ItemBerry(1506, 1)).setIconCoord(0, 12).setHasSubtypes(true).setItemName("berry");
        pieSlice = (new ItemPieSlice(1507, 10)).setIconCoord(1, 12).setHasSubtypes(true).setItemName("pieSlice");
		ModLoader.AddName(spyGlass, "Spyglass");
		ModLoader.AddName(battleAxeWood, "Wooden Battle Axe");
		ModLoader.AddName(battleAxeStone, "Stone Battle Axe");
		ModLoader.AddName(battleAxeIron, "Iron Battle Axe");
		ModLoader.AddName(battleAxeGold, "Gold Battle Axe");
		ModLoader.AddName(battleAxeDiamond, "Diamond Battle Axe");
		ModLoader.AddLocalization("item.berry.blue.name", "Blueberry");
		ModLoader.AddLocalization("item.berry.red.name", "Raspberry");
		ModLoader.AddLocalization("item.pieSlice.name", "Pie Slice");
		ModLoader.AddLocalization("item.pieSlice.name", "Pie Slice");
    }
}
