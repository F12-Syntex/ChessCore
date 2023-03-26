package com.chess.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * NOTICE, this annotation is not yet ready for use
 * marker annotation responsibile for marking event runnable methods
 * this annotation is used by the {@link EventController} to find and run event methods
 * @author https://github.com/F12-Syntex
 * @version 1.0.0
 * @since 1.0.0
 * @see com.chess.controller.EventController
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ChessEvent {}
