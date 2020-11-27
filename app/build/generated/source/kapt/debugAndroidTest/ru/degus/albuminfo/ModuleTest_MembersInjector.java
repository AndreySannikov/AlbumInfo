// Generated by Dagger (https://dagger.dev).
package ru.degus.albuminfo;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ModuleTest_MembersInjector implements MembersInjector<ModuleTest> {
  private final Provider<App> appProvider;

  public ModuleTest_MembersInjector(Provider<App> appProvider) {
    this.appProvider = appProvider;
  }

  public static MembersInjector<ModuleTest> create(Provider<App> appProvider) {
    return new ModuleTest_MembersInjector(appProvider);}

  @Override
  public void injectMembers(ModuleTest instance) {
    injectApp(instance, appProvider.get());
  }

  @InjectedFieldSignature("ru.degus.albuminfo.ModuleTest.app")
  public static void injectApp(ModuleTest instance, App app) {
    instance.app = app;
  }
}
