package xyz.pixelatedw.MineMineNoMi3.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xyz.pixelatedw.MineMineNoMi3.api.EnumParticleTypes;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper;
import xyz.pixelatedw.MineMineNoMi3.api.WyHelper.Direction;
import xyz.pixelatedw.MineMineNoMi3.ieep.ExtendedEntityStats;
import xyz.pixelatedw.MineMineNoMi3.lists.ListMisc;


public class BlockSunaSand extends Block
{	
	public BlockSunaSand()
	{
		super(Material.sand);
	} 

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) 
    { 
    	if(entity instanceof EntityLivingBase)
    	{
	    	ExtendedEntityStats props = ExtendedEntityStats.get((EntityLivingBase) entity);	    	

	    	if(!props.getUsedFruit().equals("sunasuna"))
	    		entity.setInWeb(); 
    	}
    	else 
    		entity.setInWeb();
    }
	
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity entity)
    {
    	if(entity instanceof EntityLivingBase)
    	{
	    	ExtendedEntityStats props = ExtendedEntityStats.get((EntityLivingBase) entity);	    	

	    	if(props.getUsedFruit().equals("sunasuna"))
	    	{
	    		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	    		super.addCollisionBoxesToList(world, x, y, z, mask, list, entity);
	    	}
    	}
	}
	
}