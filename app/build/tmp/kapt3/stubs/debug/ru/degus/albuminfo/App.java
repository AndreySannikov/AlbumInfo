package ru.degus.albuminfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lru/degus/albuminfo/App;", "Landroid/app/Application;", "()V", "appComponent", "Lru/degus/albuminfo/di/AppComponent;", "<set-?>", "", "name", "getName", "()Ljava/lang/String;", "viewModelSubComponent", "Lru/degus/albuminfo/di/ViewModelSubComponent;", "getAppComponent", "getViewModelSubComponent", "onCreate", "", "Companion", "app_debug"})
public final class App extends android.app.Application {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name;
    private ru.degus.albuminfo.di.AppComponent appComponent;
    private ru.degus.albuminfo.di.ViewModelSubComponent viewModelSubComponent;
    @org.jetbrains.annotations.NotNull()
    private static ru.degus.albuminfo.App instance;
    public static final ru.degus.albuminfo.App.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.degus.albuminfo.di.AppComponent getAppComponent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ru.degus.albuminfo.di.ViewModelSubComponent getViewModelSubComponent() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public App() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lru/degus/albuminfo/App$Companion;", "", "()V", "<set-?>", "Lru/degus/albuminfo/App;", "instance", "getInstance", "()Lru/degus/albuminfo/App;", "setInstance", "(Lru/degus/albuminfo/App;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final ru.degus.albuminfo.App getInstance() {
            return null;
        }
        
        private final void setInstance(ru.degus.albuminfo.App p0) {
        }
        
        private Companion() {
            super();
        }
    }
}