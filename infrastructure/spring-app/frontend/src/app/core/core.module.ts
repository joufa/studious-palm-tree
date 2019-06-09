import { NgModule } from '@angular/core';

import { MaterialModule } from './material';
import { AppComponent } from './containers/app.component';
import { RouterModule } from '@angular/router';
import { ToolbarComponent } from './components/toolbar.component';
import { LayoutComponent } from './components/layout.component';
import { SidenavComponent } from './components/sidenav.component';
import { NavItemComponent } from './components/nav-item.component';
import { CommonModule } from '@angular/common';

export const COMPONENTS = [AppComponent, ToolbarComponent, LayoutComponent, SidenavComponent, NavItemComponent];

@NgModule({
  declarations: [COMPONENTS],
  imports: [CommonModule, RouterModule, MaterialModule],
  exports: [COMPONENTS]
})
export class CoreModule {}
