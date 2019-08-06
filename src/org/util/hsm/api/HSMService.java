package org.util.hsm.api;

import java.util.ServiceLoader;

public interface HSMService {

	public abstract String getName();

	public abstract TranslationService translator();

	public abstract CVVService cvv();

	public abstract KeyService key();

	public abstract ThalesService thales();

	public abstract PVVService pvv();

	public abstract IBMService ibm();

	public abstract boolean shutdown();

	public static HSMService getService(final String name) throws Exception {
		final ServiceLoader<HSMService> serviceLoader = ServiceLoader.load(HSMService.class, HSMService.class.getClassLoader());
		for (final HSMService service : serviceLoader) {
			if (service.getName().equalsIgnoreCase(name)) return service;
		}
		throw new Exception("hsm service not found for name : " + name);
	}
}
