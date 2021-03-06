package xyz.pixelatedw.mineminenomi.particles.effects.suna;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import xyz.pixelatedw.mineminenomi.api.WyHelper;
import xyz.pixelatedw.mineminenomi.api.math.WyMathHelper;
import xyz.pixelatedw.mineminenomi.particles.CustomParticle;
import xyz.pixelatedw.mineminenomi.particles.effects.ParticleEffect;
import xyz.pixelatedw.mineminenomi.values.ModValuesParticles;

public class ParticleEffectDesertSpada extends ParticleEffect
{

	@Override
	public void spawn(PlayerEntity player, double posX, double posY, double posZ)
	{
		Random rand = player.getRNG();
		
		for(int i = 0; i < 200; i++)
		{
			double x = 0;
			double z = 0;

			double motionX = 0;
			double motionY = 0.05 + (WyMathHelper.randomDouble() / 50);
			double motionZ = 0;
			
			if(WyHelper.get4Directions(player) == WyHelper.Direction.NORTH)
			{
				x = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
				z = -i * 0.2;
			}
			else if(WyHelper.get4Directions(player) == WyHelper.Direction.EAST)
			{
				x = i * 0.2;
				z = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
			}
			else if(WyHelper.get4Directions(player) == WyHelper.Direction.SOUTH)
			{
				x = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
				z = i * 0.2;
			}
			else if(WyHelper.get4Directions(player) == WyHelper.Direction.WEST)
			{
				x = -i * 0.2;
				z = WyMathHelper.randomWithRange(-4, 4) + WyMathHelper.randomDouble();
			}
			
			CustomParticle cp = new CustomParticle(player.world, ModValuesParticles.PARTICLE_ICON_SUNA,
					posX + x, 
					posY + 0.1,
					posZ + z, 
					motionX, 
					motionY, 
					motionZ)
					.setParticleAge(10).setParticleScale(5);
			Minecraft.getInstance().particles.addEffect(cp);
		}
	}
}
