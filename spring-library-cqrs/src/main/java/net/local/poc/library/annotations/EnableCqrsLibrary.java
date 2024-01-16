package net.local.poc.library.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import net.local.poc.library.configuration.CqrsLibraryConfig;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CqrsLibraryConfig.class)
public @interface EnableCqrsLibrary {}