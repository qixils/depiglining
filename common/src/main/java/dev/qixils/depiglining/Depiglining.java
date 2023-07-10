package dev.qixils.depiglining;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// TODO: what is PiglinBarterLoot? does it need to be mixin'd? is it used??
//  same with PIGLIN_BRUTE usage in AdventureAdvancements
//  it seems like overriding the JSON files works just fine so IDK what these are for, I guess generating the JSON?

public class Depiglining
{
	public static final String MOD_ID = "depiglining";
	public static final Logger LOGGER = LogManager.getLogger("Depiglining");
	public static final Set<UUID> TO_REMOVE = new HashSet<>();
	private static final Set<UUID> IN_TO_REMOVE = new HashSet<>();
	private static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();

	public static void init() {
		LOGGER.info("Loading Depiglining");
		EXECUTOR.scheduleAtFixedRate(() -> {
			Iterator<UUID> iterator = IN_TO_REMOVE.iterator();
			while (iterator.hasNext()) {
				UUID uuid = iterator.next();
				iterator.remove();
				if (TO_REMOVE.remove(uuid))
					LOGGER.warn("Clearing stuck entity {} from removal queue", uuid);
			}
			IN_TO_REMOVE.addAll(TO_REMOVE);
		}, 10, 10, TimeUnit.SECONDS);
	}
}