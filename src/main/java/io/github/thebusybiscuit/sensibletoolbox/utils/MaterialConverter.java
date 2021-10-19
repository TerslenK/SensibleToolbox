package io.github.thebusybiscuit.sensibletoolbox.utils;

import java.util.Optional;

import org.bukkit.Material;

public final class MaterialConverter {
	public static Optional<Material> getSaplingFromLog(Material log) {
		if (!isLog(log))
			return Optional.empty();

		String type = log.name().substring(0, log.name().lastIndexOf('_'));
		type = type.replace("STRIPPED_", "");
		try {
			return Optional.ofNullable(Material.valueOf(type + "_SAPLING"));
		} catch (IllegalArgumentException ignored) {
			return Optional.empty();
		}
	}

	public static Optional<Material> getPlanksFromLog(Material log) {
		if (!isLog(log))
			return Optional.empty();

		String type = log.name().substring(0, log.name().lastIndexOf('_'));
		type = type.replace("STRIPPED_", "");
		try {
			return Optional.ofNullable(Material.valueOf(type + "_PLANKS"));
		} catch (IllegalArgumentException ignored) {
			return Optional.empty();
		}
	}

	public static boolean isLog(Material log) {
		return log.name().endsWith("_LOG") || log.name().endsWith("_WOOD");
	}
}
