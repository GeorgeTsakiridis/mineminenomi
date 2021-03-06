package xyz.pixelatedw.mineminenomi.entities.abilityprojectiles;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import xyz.pixelatedw.mineminenomi.ModMain;
import xyz.pixelatedw.mineminenomi.api.WyRegistry;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityAttribute;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityProjectile;
import xyz.pixelatedw.mineminenomi.api.abilities.AbilityProjectile.Data;
import xyz.pixelatedw.mineminenomi.config.CommonConfig;
import xyz.pixelatedw.mineminenomi.init.ModAttributes;
import xyz.pixelatedw.mineminenomi.particles.CustomParticleData;
import xyz.pixelatedw.mineminenomi.values.ModValuesParticles;

public class MeraProjectiles
{
	public static HashMap<AbilityAttribute, AbilityProjectile.Data> projectiles = new HashMap<AbilityAttribute, AbilityProjectile.Data>();
	
	public static final EntityType HIKEN = WyRegistry.registerEntityType("hiken", Hiken::new);
	public static final EntityType HIGAN = WyRegistry.registerEntityType("higan", Higan::new);
	public static final EntityType DAI_ENKAI_ENTEI = WyRegistry.registerEntityType("dai_enkai_entei", DaiEnkaiEntei::new);
	public static final EntityType HIDARUMA = WyRegistry.registerEntityType("hidaruma", Hidaruma::new);
	public static final EntityType JUJIKA = WyRegistry.registerEntityType("jujika", Jujika::new);
		
	static
	{
		projectiles.put(ModAttributes.HIKEN, new Data(HIKEN, Hiken.class));
		projectiles.put(ModAttributes.HIGAN, new Data(HIGAN, Higan.class));
		projectiles.put(ModAttributes.DAI_ENKAI_ENTEI, new Data(DAI_ENKAI_ENTEI, DaiEnkaiEntei.class));
		projectiles.put(ModAttributes.HIDARUMA, new Data(HIDARUMA, Hidaruma.class));
		projectiles.put(ModAttributes.JUJIKA, new Data(JUJIKA, Jujika.class));
	}

	public static class Hiken extends AbilityProjectile
	{
		public Hiken(World world)
		{super(HIKEN, world);}
		
		public Hiken(EntityType type, World world)
		{super(type, world);}
		
		public Hiken(World world, double x, double y, double z)
		{super(HIKEN, world, x, y, z);}
		
		public Hiken(World world, LivingEntity player, AbilityAttribute attr) 
		{		
			super(HIKEN, world, player, attr);		
		}
		
		@Override
		public void tick()
		{		
			if(this.world.isRemote)
			{
				for (int i = 0; i < 25; i++)
				{
					double offsetX = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
					double offsetY = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
					double offsetZ = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;

					CustomParticleData data = new CustomParticleData();
					data.setTexture(ModValuesParticles.PARTICLE_ICON_MERA);
					data.setPosX(posX + offsetX);
					data.setPosY(posY + offsetY);
					data.setPosZ(posZ + offsetZ);
					
					data.setMaxAge(10);
					data.setScale(1.3F);
					
					ModMain.proxy.spawnParticles(world, data);
				}
				
				for (int i = 0; i < 5; i++)
				{
					double offsetX = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
					double offsetY = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
					double offsetZ = (new Random().nextInt(50) + 1.0D - 25.0D) / 30.0D;
					
					CustomParticleData data = new CustomParticleData();
					data.setTexture(ModValuesParticles.PARTICLE_ICON_MOKU);
					data.setPosX(posX + offsetX);
					data.setPosY(posY + offsetY);
					data.setPosZ(posZ + offsetZ);
					
					data.setMaxAge(7);
					data.setScale(1.2F);
					
					ModMain.proxy.spawnParticles(world, data);
				}
			}
			super.tick();
		}
	}
	
	public static class Higan extends AbilityProjectile
	{
		public Higan(World world)
		{super(HIGAN, world);}
		
		public Higan(EntityType type, World world)
		{super(type, world);}
		
		public Higan(World world, double x, double y, double z)
		{super(HIGAN, world, x, y, z);}
		
		public Higan(World world, LivingEntity player, AbilityAttribute attr) 
		{		
			super(HIGAN, world, player, attr);		
		}
		
		@Override
		public void tasksImapct(RayTraceResult hit)
		{
			this.world.setBlockState(new BlockPos(this.posX, this.posY, this.posZ), Blocks.FIRE.getDefaultState());
		}
		
		@Override
		public void tick()
		{	
			if(this.world.isRemote)
			{
				double posXOffset = this.world.rand.nextGaussian() * 0.42D;
				double posYOffset = this.world.rand.nextGaussian() * 0.22D;
				double posZOffset = this.world.rand.nextGaussian() * 0.42D;		
	
				CustomParticleData data = new CustomParticleData();
				data.setTexture(ModValuesParticles.PARTICLE_ICON_MERA);
				data.setPosX(posX + posXOffset);
				data.setPosY(posY + posYOffset);
				data.setPosZ(posZ + posZOffset);
				
				data.setMaxAge(6);
				data.setScale(1.2F);
				
				ModMain.proxy.spawnParticles(world, data);
			}
			super.tick();
		}
	}
	
	public static class DaiEnkaiEntei extends AbilityProjectile
	{
		public DaiEnkaiEntei(World world)
		{ super(DAI_ENKAI_ENTEI, world); }
		
		public DaiEnkaiEntei(EntityType type, World world)
		{ super(type, world); }
		
		public DaiEnkaiEntei(World world, double x, double y, double z)
		{ super(DAI_ENKAI_ENTEI, world, x, y, z); }
		
		public DaiEnkaiEntei(World world, LivingEntity player, AbilityAttribute attr) 
		{		
			super(DAI_ENKAI_ENTEI, world, player, attr);		
		}
		
		@Override
		public void tick()
		{	
			if(this.world.isRemote)
			{
				for (int i = 0; i < 75; i++)
				{
					double offsetX = (new Random().nextInt(40) + 2.0D - 20.0D) / 10.0D;
					double offsetY = (new Random().nextInt(40) + 2.0D - 20.0D) / 10.0D;
					double offsetZ = (new Random().nextInt(40) + 2.0D - 20.0D) / 10.0D;
			      
					CustomParticleData data = new CustomParticleData();
					data.setTexture(ModValuesParticles.PARTICLE_ICON_MERA);
					data.setPosX(posX + offsetX);
					data.setPosY(posY + offsetY);
					data.setPosZ(posZ + offsetZ);
					
					data.setMaxAge(10);
					data.setScale(1.3F);
					
					ModMain.proxy.spawnParticles(world, data);
				}
				
				for (int i = 0; i < 10; i++)
				{
					double offsetX = (new Random().nextInt(40) + 2.0D - 20.0D) / 10.0D;
					double offsetY = (new Random().nextInt(40) + 2.0D - 20.0D) / 10.0D;
					double offsetZ = (new Random().nextInt(40) + 2.0D - 20.0D) / 10.0D;
			      
					CustomParticleData data = new CustomParticleData();
					data.setTexture(ModValuesParticles.PARTICLE_ICON_MOKU);
					data.setPosX(posX + offsetX);
					data.setPosY(posY + offsetY);
					data.setPosZ(posZ + offsetZ);
					
					data.setMaxAge(7);
					data.setScale(1.1F);
					
					ModMain.proxy.spawnParticles(world, data);
				}
			}
			
			super.tick();
		}
	}
	
	public static class Hidaruma extends AbilityProjectile
	{
		public Hidaruma(World world)
		{super(HIDARUMA, world);}
		
		public Hidaruma(EntityType type, World world)
		{ super(type, world); }
		
		public Hidaruma(World world, double x, double y, double z)
		{super(HIDARUMA, world, x, y, z);}
		
		public Hidaruma(World world, LivingEntity player, AbilityAttribute attr) 
		{		
			super(HIDARUMA, world, player, attr);		
		}
		
		@Override
		public void tasksImapct(RayTraceResult hit)
		{
			if(hit.getType() == Type.ENTITY)
			{
				EntityRayTraceResult entityHit = (EntityRayTraceResult) hit;

				entityHit.getEntity().setFire(this.ticks);
			}

			this.world.setBlockState(new BlockPos(this.posX, this.posY, this.posZ), Blocks.FIRE.getDefaultState());
		};
		
		@Override
		public void tick()
		{	
			for (int i = 0; i < 10; i++)
			{
				double offsetX = (new Random().nextInt(10) + 1.0D - 5.0D) / 10.0D;
				double offsetY = (new Random().nextInt(10) + 1.0D - 5.0D) / 10.0D;
				double offsetZ = (new Random().nextInt(10) + 1.0D - 5.0D) / 10.0D;
		      
				ModMain.proxy.spawnVanillaParticle(ParticleTypes.HAPPY_VILLAGER, this.posX + offsetX, this.posY + offsetY, this.posZ + offsetZ, 0.0D, 0.05D, 0.0D);			
			}
			
			super.tick();
		}
	}
	
	public static class Jujika extends AbilityProjectile
	{
		public Jujika(World world)
		{super(JUJIKA, world);}
		
		public Jujika(EntityType type, World world)
		{ super(type, world); }
		
		public Jujika(World world, double x, double y, double z)
		{super(JUJIKA, world, x, y, z);}
		
		public Jujika(World world, LivingEntity player, AbilityAttribute attr) 
		{		
			super(JUJIKA, world, player, attr);		
		}
		
		@Override
		public void tasksImapct(RayTraceResult hit)
		{
			int posX;
			int posY;
			int posZ;

			if(CommonConfig.instance.isGriefingEnabled())
			{
				for(int j = -2; j <= 2; j++)
				{
					for(int i = -5; i <= 5; i++)
						if(this.world.isAirBlock(new BlockPos(hit.getHitVec().x + i, hit.getHitVec().y + j, hit.getHitVec().z)))
							this.world.setBlockState(new BlockPos(hit.getHitVec().x + i, hit.getHitVec().y + j, hit.getHitVec().z), Blocks.FIRE.getDefaultState());
						
					for(int i = -5; i <= 5; i++)
						if(this.world.isAirBlock(new BlockPos(hit.getHitVec().x, hit.getHitVec().y + j, hit.getHitVec().z + i)))
							this.world.setBlockState(new BlockPos(hit.getHitVec().x, hit.getHitVec().y + j, hit.getHitVec().z + i), Blocks.FIRE.getDefaultState());
				}
			}
		};
	}
}

