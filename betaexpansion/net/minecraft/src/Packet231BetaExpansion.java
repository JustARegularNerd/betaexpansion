// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet231BetaExpansion extends Packet
{

    public Packet231BetaExpansion()
    {
    }
    public Packet231BetaExpansion(int i)
    {
        version = i;
    }
    public void readPacketData(DataInputStream datainputstream)
    		throws IOException
    {
    	version = datainputstream.readInt();
    }

    public void writePacketData(DataOutputStream dataoutputstream)
    		throws IOException
    {
    	dataoutputstream.writeInt(version);
    }

    public void processPacket(NetHandler nethandler)
    {
    	((NetClientHandler)nethandler).handleBE(this);
    }

    public int getPacketSize()
    {
    	return 4;
    }

    public int version;
}
