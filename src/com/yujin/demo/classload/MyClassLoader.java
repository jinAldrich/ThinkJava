package com.yujin.demo.classload;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

public class MyClassLoader extends java.lang.ClassLoader {
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		System.out.println("<---loadClass--->");
		System.out.println("name: " + name);
		return super.loadClass(name);
	}

	@Override
	protected synchronized Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		System.out.println("<---loadClass--->");
		System.out.println("name: " + name + " resolve: " + resolve);
		return super.loadClass(name, resolve);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("<---findClass--->");
		System.out.println("name: " + name);
		return super.findClass(name);
	}

	@Override
	public URL getResource(String name) {
		System.out.println("<---getResource--->");
		System.out.println("name: " + name);
		return super.getResource(name);
	}

	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		System.out.println("<---getResources--->");
		System.out.println("name: " + name);
		return super.getResources(name);
	}

	@Override
	protected URL findResource(String name) {
		System.out.println("<---findResource--->");
		System.out.println("name: " + name);
		return super.findResource(name);
	}

	@Override
	protected Enumeration<URL> findResources(String name) throws IOException {
		System.out.println("<---findResources--->");
		System.out.println("name: " + name);
		return super.findResources(name);
	}

	@Override
	public InputStream getResourceAsStream(String name) {
		System.out.println("<---getResourceAsStream--->");
		System.out.println("name: " + name);
		return super.getResourceAsStream(name);
	}

	@Override
	protected Package definePackage(String name, String specTitle,
			String specVersion, String specVendor, String implTitle,
			String implVersion, String implVendor, URL sealBase)
			throws IllegalArgumentException {
		System.out.println("<---definePackage--->");
		System.out.println("name: " + name);
		return super.definePackage(name, specTitle, specVersion, specVendor, implTitle,
				implVersion, implVendor, sealBase);
	}

	@Override
	protected Package getPackage(String name) {
		System.out.println("<---getPackage--->");
		System.out.println("name: " + name);
		return super.getPackage(name);
	}

	@Override
	protected Package[] getPackages() {
		System.out.println("<---getPackages--->");
		return super.getPackages();
	}

	@Override
	protected String findLibrary(String libname) {
		System.out.println("<---findLibrary--->");
		System.out.println("libname: " + libname);
		return super.findLibrary(libname);
	}

	@Override
	public synchronized void setDefaultAssertionStatus(boolean enabled) {
		System.out.println("<---setDefaultAssertionStatus--->");
		System.out.println("enabled: " + enabled);
		super.setDefaultAssertionStatus(enabled);
	}

	@Override
	public synchronized void setPackageAssertionStatus(String packageName,
			boolean enabled) {
		System.out.println("<---setPackageAssertionStatus--->");
		System.out.println("packageName: " + packageName + " enabled: " + enabled);
		super.setPackageAssertionStatus(packageName, enabled);
	}

	@Override
	public synchronized void setClassAssertionStatus(String className,
			boolean enabled) {
		System.out.println("<---setClassAssertionStatus--->");
		System.out.println("className: " + className + " enabled: " + enabled);
		super.setClassAssertionStatus(className, enabled);
	}

	@Override
	public synchronized void clearAssertionStatus() {
		System.out.println("<---clearAssertionStatus--->");
		super.clearAssertionStatus();
	}

}
