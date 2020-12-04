package ru.degus.albuminfo.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lru/degus/albuminfo/di/AppComponent;", "", "activitySubComponentBuilder", "Lru/degus/albuminfo/di/ActivitySubComponent$Builder;", "viewModelSubComponentBuilder", "Lru/degus/albuminfo/di/ViewModelSubComponent$Builder;", "Builder", "app_debug"})
@javax.inject.Singleton()
@dagger.Component(modules = {ru.degus.albuminfo.di.modules.ApiFactoryModule.class, ru.degus.albuminfo.di.modules.AlbumRepoModule.class})
public abstract interface AppComponent {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.degus.albuminfo.di.ViewModelSubComponent.Builder viewModelSubComponentBuilder();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.degus.albuminfo.di.ActivitySubComponent.Builder activitySubComponentBuilder();
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\'J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lru/degus/albuminfo/di/AppComponent$Builder;", "", "application", "appModule", "Lru/degus/albuminfo/App;", "build", "Lru/degus/albuminfo/di/AppComponent;", "app_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        public abstract ru.degus.albuminfo.di.AppComponent build();
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract ru.degus.albuminfo.di.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        ru.degus.albuminfo.App appModule);
    }
}