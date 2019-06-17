import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule, Optional, SkipSelf, ErrorHandler } from '@angular/core';
import { EffectsModule } from '@ngrx/effects';
import {
  RouterStateSerializer,
  StoreRouterConnectingModule
} from '@ngrx/router-store';
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { environment } from 'src/environments/environment';
import { LayoutComponent } from './components/layout.component';
import { NavItemComponent } from './components/nav-item.component';
import { SidenavComponent } from './components/sidenav.component';
import { ToolbarComponent } from './components/toolbar.component';
import { metaReducers, ROOT_REDUCERS } from './core.state';
import { MaterialModule } from './material';
import { CustomSerializer } from './router/custom-serializer';
import { RouterModule } from '@angular/router';
import { AppErrorHandler } from './error-handler/error-handler.service';
import { httpInterceptorProviders } from './http-interceptor';

export const COMPONENTS = [
  ToolbarComponent,
  LayoutComponent,
  SidenavComponent,
  NavItemComponent
];

@NgModule({
  declarations: [COMPONENTS],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    RouterModule,

    // ngrx
    StoreModule.forRoot(ROOT_REDUCERS, { metaReducers }),
    EffectsModule.forRoot([]),
    !environment.production
      ? StoreDevtoolsModule.instrument({ name: 'The Agile App UI' })
      : [],
    StoreRouterConnectingModule.forRoot()
  ],
  exports: [COMPONENTS],
  providers: [
    httpInterceptorProviders,
    { provide: ErrorHandler, useClass: AppErrorHandler },
    { provide: RouterStateSerializer, useClass: CustomSerializer }
  ]
})
export class CoreModule {
  constructor(
    @Optional()
    @SkipSelf()
    parentModule: CoreModule
  ) {
    if (parentModule) {
      throw new Error('CoreModule is already loaded.');
    }
  }
}
