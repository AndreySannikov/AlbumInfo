package ru.degus.albuminfo.di.modules;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\b\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lru/degus/albuminfo/di/modules/AppModule;", "", "app", "Lru/degus/albuminfo/App;", "(Lru/degus/albuminfo/App;)V", "app$app_debug", "app_debug"})
@dagger.Module()
public final class AppModule {
    private final ru.degus.albuminfo.App app = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final ru.degus.albuminfo.App app$app_debug() {
        return null;
    }
    
    public AppModule(@org.jetbrains.annotations.NotNull()
    ru.degus.albuminfo.App app) {
        super();
    }
}