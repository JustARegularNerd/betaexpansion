// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet232Season extends Packet
{

    public Packet232Season()
    {
    }
    public Packet232Season(boolean b, int b1, int b2)
    {
    	seasons = b;
    	length = b1;
    	offset = b2;
    }
    public void readPacketData(DataInputStream datainputstream)
    		throws IOException
    {
    	seasons = datainputstream.read() != 0;
    	length = datainputstream.readInt();
    	offset = datainputstream.readInt();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
    		throws IOException
    {
    	dataoutputstream.writeBoolean(seasons);
    	dataoutputstream.writeInt(length);
    	dataoutputstream.writeInt(offset);
    }

    public void processPacket(NetHandler nethandler)
    {
    	((NetClientHandler)nethandler).handleSeason(this);
    }

    public int getPacketSize()
    {
    	return 9;
    }

    public boolean seasons;
    public int offset;
    public int length;
}
