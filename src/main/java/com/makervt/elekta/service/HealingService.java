package com.makervt.elekta.service;


import org.springframework.stereotype.Service;

import com.makervt.elekta.domain.Healing;

@Service("HealingService")
public class HealingService{
	public Healing queryHealing(Healing proc)
	{
		return MipProviderService.queryHealingByMip(proc);
	}
}
